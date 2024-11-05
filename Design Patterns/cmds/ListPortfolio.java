package org.poo.cb.cmds;

import org.poo.cb.user.User;
import org.poo.cb.utils.Command;
import org.poo.cb.utils.Database;

public class ListPortfolio implements Command {
	@Override
	public void execute(String[] args) {
		Database db = Database.getInstance();
		String email = args[0];

		for (User u : db.getUsers()) {
			if (u.getEmail().equals(email)) {
				System.out.println(u.getPortfolio());
				return;
			}
		}

		System.out.println("User with " + email + " doesn't exist");
	}
}
