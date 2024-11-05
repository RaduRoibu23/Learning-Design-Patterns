package org.poo.cb.cmds;

import org.poo.cb.user.Account;
import org.poo.cb.user.User;
import org.poo.cb.utils.Command;
import org.poo.cb.utils.Database;

public class ExchangeMoney implements Command {
	@Override
	public void execute(String[] args) {
		Database db = Database.getInstance();
		User user = db.getUser(args[0]);
		Account account1 = user.getPortfolio().getAccount(args[1]);
		Account account2 = user.getPortfolio().getAccount(args[2]);

		if (account1.getAmount() < Double.parseDouble(args[3])) {
			System.out.println("Insufficient amount in account " + args[1] + " for exchange");
			return;
		}

		double exchangeRate = db.getExchangeRate(args[1], args[2]);
		double commission = account1.getCommission(Double.parseDouble(args[3]) * exchangeRate);
		account1.addMoney(-(Double.parseDouble(args[3]) * exchangeRate + commission));
		account2.addMoney(Double.parseDouble(args[3]));
	}
}
