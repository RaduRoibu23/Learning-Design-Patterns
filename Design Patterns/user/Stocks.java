package org.poo.cb.user;

public class Stocks {
	private String stockname;
	private int amount;

	public Stocks() {
		this.stockname = "";
		this.amount = 0;
	}

	public Stocks(String stockname, int amount) {
		this.stockname = stockname;
		this.amount = amount;
	}

	public String getStockname() {
		return stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void addStocks(int amount) {
		this.amount += amount;
	}

	@Override
	public String toString() {
		return "{\"stockname\":\"" + stockname + "\",\"amount\":" + amount + "}";
	}
}
