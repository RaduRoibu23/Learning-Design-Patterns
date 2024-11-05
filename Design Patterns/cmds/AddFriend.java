package org.poo.cb.cmds;

import org.poo.cb.user.User;
import org.poo.cb.utils.Command;
import org.poo.cb.utils.Database;

public class AddFriend implements Command {
	@Override
	public void execute(String[] args) {
		Database db = Database.getInstance();
		User u1 = null;
		User u2 = null;

		for (User u : db.getUsers()) {
			if (u.getEmail().equals(args[0]))
				u1 = u;
			if (u.getEmail().equals(args[1]))
				u2 = u;
		}

		if (u1 == null) {
			System.out.println("User with " + args[0] + " doesn't exist");
			return;
		}
		if (u2 == null) {
			System.out.println("User with " + args[1] + " doesn't exist");
			return;
		}
		if (u1.getFriends().contains(args[1])) {
			System.out.println("User with " + args[1] + " is already a friend");
			return;
		}

		u1.addFriend(args[1]);
		u2.addFriend(args[0]);
	}
}
