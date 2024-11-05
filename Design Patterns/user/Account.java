package org.poo.cb.user;

public class Account {
	private String currencyname;
	private double amount;

	public Account() {
		this.currencyname = "";
		this.amount = 0;
	}

	public Account(String currencyname, double amount) {
		this.currencyname = currencyname;
		this.amount = amount;
	}

	public String getCurrencyname() {
		return currencyname;
	}

	public void setCurrencyname(String currencyname) {
		this.currencyname = currencyname;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void addMoney(double amount) {
		this.amount += amount;
	}

	public double getCommission(double amount) {
		if (this.amount / 2 < amount)
			return amount * 0.01;
		return 0;
	}

	@Override
	public String toString() {
		String doubleAsString = String.format("%.2f", amount);
		return "{\"currencyname\":\"" + currencyname + "\",\"amount\":\"" + doubleAsString + "\"}";
	}
}
