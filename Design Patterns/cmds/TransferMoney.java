package org.poo.cb.cmds;

import org.poo.cb.user.User;
import org.poo.cb.utils.Command;
import org.poo.cb.utils.Database;

public class TransferMoney implements Command {
	@Override
	public void execute(String[] args) {
		Database db = Database.getInstance();
		User user = db.getUser(args[0]);
		User target = db.getUser(args[1]);

		if (user.getPortfolio().getAccount(args[2]).getAmount() < Double.parseDouble(args[3])) {
			System.out.println("Insufficient amount in account " + args[2] + " for transfer");
			return;
		}
		if (!target.isFriendWith(user.getEmail())) {
			System.out.println("You are not allowed to transfer money to " + args[1]);
			return;
		}

		user.getPortfolio().getAccount(args[2]).addMoney(-Double.parseDouble(args[3]));
		target.getPortfolio().getAccount(args[2]).addMoney(Double.parseDouble(args[3]));
	}
}
