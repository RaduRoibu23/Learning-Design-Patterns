package org.poo.cb.cmds;

import org.poo.cb.user.User;
import org.poo.cb.utils.Command;
import org.poo.cb.utils.Database;

public class BuyStocks implements Command {
	@Override
	public void execute(String[] args) {
		Database db = Database.getInstance();
		User user = db.getUser(args[0]);
		double stockValue = db.getStockValue(args[1]);
		if (user.getPortfolio().getAccount("USD").getAmount() < stockValue * Integer.parseInt(args[2])) {
			System.out.println("Insufficient amount in account for buying stock");
			return;
		}
		user.getPortfolio().buyStocks(args[1], args[2]);
		user.getPortfolio().getAccount("USD").addMoney(-stockValue * Integer.parseInt(args[2]));
	}
}
