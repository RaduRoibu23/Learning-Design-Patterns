package org.poo.cb.cmds;

import org.poo.cb.utils.Command;
import org.poo.cb.utils.Database;

import java.util.ArrayList;
import java.util.List;

public class RecommendStocks implements Command {
	@Override
	public void execute(String[] args) {
		Database db = Database.getInstance();
		List<String> stocks = new ArrayList<>();

		for (String stockValues : db.getStockValues()) {
			String[] values = stockValues.split(",");
			if (values[0].equals("Stock"))
				continue;
			double medie5 = 0;
			for (int i = 10; i > 5; i--)
				medie5 += Double.parseDouble(values[i]);
			double medie10 = medie5;
			for (int i = 5; i > 0; i--)
				medie10 += Double.parseDouble(values[i]);
			medie5 /= 5;
			medie10 /= 10;
			if (medie5 > medie10)
				stocks.add(values[0]);
		}

		System.out.print("{\"stockstobuy\":[");
		for (int i = 0; i < stocks.size(); i++) {
			System.out.print("\"" + stocks.get(i) + "\"");
			if (i < stocks.size() - 1)
				System.out.print(",");
		}
		System.out.println("]}");
	}
}
