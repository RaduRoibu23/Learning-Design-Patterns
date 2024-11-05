package org.poo.cb.cmds;

import org.poo.cb.user.User;
import org.poo.cb.utils.Command;
import org.poo.cb.utils.Database;

public class AddMoney implements Command {
	@Override
	public void execute(String[] args) {
		Database db = Database.getInstance();
		User user = db.getUser(args[0]);
		user.getPortfolio().addMoney(args[1], args[2]);
	}
}
