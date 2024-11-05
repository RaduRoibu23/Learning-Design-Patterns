package org.poo.cb.user;

import java.util.List;

public class User {
	private final String email;
	private final String firstname;
	private final String lastname;
	private final String address;
	private final List<String> friends;
	private final Portfolio portfolio;

	public User(UserBuilder builder) {
		this.email = builder.email;
		this.firstname = builder.firstname;
		this.lastname = builder.lastname;
		this.address = builder.address;
		this.friends = builder.friends;
		this.portfolio = builder.portfolio;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public List<String> getFriends() {
		return friends;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void addFriend(String friend) {
		friends.add(friend);
	}

	public boolean isFriendWith(String email) {
		return friends.contains(email);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"email\":\"");
		sb.append(email);
		sb.append("\",\"firstname\":\"");
		sb.append(firstname);
		sb.append("\",\"lastname\":\"");
		sb.append(lastname);
		sb.append("\",\"address\":\"");
		sb.append(address);
		sb.append("\",\"friends\":[");
		for (String friend : friends) {
			sb.append("\"");
			sb.append(friend);
			if (friends.indexOf(friend) != friends.size() - 1)
				sb.append("\",");
			else
				sb.append("\"");
		}
		sb.append("]}");
		return sb.toString();
	}
}
