package org.poo.cb.cmds;

import org.poo.cb.user.Portfolio;
import org.poo.cb.user.User;
import org.poo.cb.user.UserBuilder;
import org.poo.cb.utils.Command;
import org.poo.cb.utils.Database;

import java.util.ArrayList;

public class CreateUser implements Command {
	@Override
	public void execute(String[] args) {
		Database db = Database.getInstance();

		for (User u : db.getUsers()) {
			if (u.getEmail().equals(args[0])) {
				System.out.println("User with " + args[0] + " already exists");
				return;
			}
		}

		StringBuilder address = new StringBuilder();
		for (int i = 3; i < args.length; i++) {
			address.append(args[i]);
			if (i < args.length - 1)
				address.append(" ");
		}

		User user = new UserBuilder().setEmail(args[0]).setFirstname(args[1]).setLastname(args[2])
				.setAddress(address.toString()).setFriends(new ArrayList<>()).setPortfolio(new Portfolio()).build();
		db.addUser(user);
	}
}
