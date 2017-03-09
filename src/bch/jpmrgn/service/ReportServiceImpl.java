package bch.jpmrgn.service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
 

import bch.jpmrgn.view.TradeView;

public class ReportServiceImpl implements ReportService{
	final public static ReportServiceImpl INSTANCE = new ReportServiceImpl();

	@Override
	public void print(OutputStream os, List<TradeView> result, Date d,
			float incomming, float outComming) throws IOException {
		// TODO Auto-generated method stub
		try(PrintWriter pw = new PrintWriter(os);) {
			pw.append("Date:").append(d.toString()).println();
			pw.append("Incomming:").println(incomming);
			pw.append("Out Comming:").println(outComming);
			result.forEach((r)->{
				pw.print("Rank:");
				pw.print(r.getRank());
				
				pw.print(" Entity:");
				pw.print(r.getEntity());
				pw.print(" Buyed:");
				pw.print(r.getBuyedAmount());
				pw.print(" Solde:");
				pw.println(r.getSoldAmount());
			});
		}
	}

	

}
