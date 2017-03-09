package bch.jpmrgn.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bch.jpmrgn.service.*;
import bch.jpmrgn.entity.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		if (args.length == 0) {
			System.err.println("Please type the path of the file report");
			System.exit(0);
		}
		ReportServiceImpl.INSTANCE.printReport(new FileOutputStream(args[0]),
				createTrades(), Date.valueOf("2017-03-06"));
	}

	private static Map<String, bch.jpmrgn.entity.Currency> createCurrencies() {
		return Arrays
				.asList(new Currency("SAR", Calendar.SUNDAY, Calendar.THURSDAY),
						new Currency("AED", Calendar.SUNDAY, Calendar.THURSDAY),
						new Currency("SEK", Calendar.MONDAY, Calendar.FRIDAY),
						new Currency("USD", Calendar.MONDAY, Calendar.FRIDAY),
						new Currency("EUR", Calendar.MONDAY, Calendar.FRIDAY))
				.stream()
				.collect(Collectors.toMap(Currency::getCode, (c) -> c));

	}

	private static List<Trade> createTrades() {
		Map<String, bch.jpmrgn.entity.Currency> currency = createCurrencies();
		return Arrays.asList(
				new Trade("IBM", BuySell.BUY, currency.get("SAR"), Date
						.valueOf("2017-03-01"), Date.valueOf("2017-03-06"),
						0.266649f, 200, 673.22f),
				new Trade("NCR", BuySell.SELL, currency.get("USD"), Date
						.valueOf("2017-03-01"), Date.valueOf("2017-03-06"), 1f,
						100, 473.22f),
				new Trade("AT&T", BuySell.BUY, currency.get("AED"), Date
						.valueOf("2017-03-01"), Date.valueOf("2017-03-07"),
						0.266649f, 100, 473.22f),
				new Trade("IBM", BuySell.BUY, currency.get("SEK"), Date
						.valueOf("2017-03-01"), Date.valueOf("2017-03-06"),
						0.110432f, 150, 673.22f)

		);

	}

}
