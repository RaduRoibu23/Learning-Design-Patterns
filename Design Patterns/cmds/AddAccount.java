package org.poo.cb.cmds;

import org.poo.cb.user.Account;
import org.poo.cb.user.User;
import org.poo.cb.utils.Command;
import org.poo.cb.utils.Database;

public class AddAccount implements Command {
	@Override
	public void execute(String[] args) {
		Database db = Database.getInstance();
		User user = db.getUser(args[0]);
		Account account = user.getPortfolio().getAccount(args[1]);
		if (account != null) {
			System.out.println("Account in currency " + args[1] + " already exists");
			return;
		}
		user.getPortfolio().addAccount(new Account(args[1], 0));
	}
}
