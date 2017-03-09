package bch.jpmrgn.service;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;

import bch.jpmrgn.entity.*;
import bch.jpmrgn.view.TradeView;
public interface ReportService {
	default float settledTrades(List<Trade> trades, BuySell flag) {
		return trades.stream().filter((t)-> t.getFlag() == flag).
				map((tr)->tr.getAgreedFx()*tr.getUnits()*tr.getPricePerUnit()).reduce((tr1,tr2)->tr1+tr2).orElse(0f);
	}
	default float settledTrades(List<Trade> trades,Date d, BuySell flag) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date startDate = cal.getTime();
		cal.add(Calendar.DATE, 1);
		Date endDate = cal.getTime();
		return trades.stream().filter((t)->t.getSettlementDate().getTime() >= startDate.getTime() && t.getSettlementDate().before(endDate) && t.getFlag() == flag).
				map((tr)->tr.getAgreedFx()*tr.getUnits()*tr.getPricePerUnit()).reduce((tr1,tr2)->tr1+tr2).orElse(0f);
	}
	
	default float incommingSettledTrades(List<Trade> trades,Date d) {
		return settledTrades(trades, d, BuySell.BUY);
	}
	
	default float outcommingSettledTrades(List<Trade> trades,Date d) {
		return settledTrades(trades, d, BuySell.SELL);
	}
	default List<TradeView> group(List<Trade> trades ) {
		Map<String,List<Trade>> grouped = trades.stream().collect(Collectors.groupingBy(Trade::getEntity));
		List<TradeView> mapTV = grouped.entrySet().stream().map( 
				e->{
					TradeView tv = new TradeView();
					tv.setEntity(e.getKey());
					tv.setBuyedAmount(settledTrades(e.getValue(),BuySell.BUY));
					tv.setSoldAmount(settledTrades(e.getValue(),BuySell.SELL));
					return tv;
				}).sorted((t1,t2)-> (int)(t2.getBuyedAmount()-t1.getBuyedAmount())). collect(Collectors.toList());
		
		int size = mapTV.size();
		for(int i=0;i<size; i++) {
			mapTV.get(i).setRank(i +1);
		}
		return mapTV;
	}
	
	void print(OutputStream os, List<TradeView> reult,Date d, float incomming,float outComming)throws IOException;
	default void printReport(OutputStream os, List<Trade> trades,Date d)throws IOException {
		List<TradeView>  result = group(trades);
		float incomming = incommingSettledTrades(trades, d);
		float outcomming = outcommingSettledTrades(trades, d);
		print(os,result,d,incomming,outcomming);
	}
}
