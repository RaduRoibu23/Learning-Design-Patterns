package org.poo.cb.user;

import java.util.List;

public class UserBuilder {
	String email;
	String firstname;
	String lastname;
	String address;
	List<String> friends;
	Portfolio portfolio;

	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public UserBuilder setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public UserBuilder setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public UserBuilder setAddress(String address) {
		this.address = address;
		return this;
	}

	public UserBuilder setFriends(List<String> friends) {
		this.friends = friends;
		return this;
	}

	public UserBuilder setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
		return this;
	}

	public User build() {
		return new User(this);
	}
}
