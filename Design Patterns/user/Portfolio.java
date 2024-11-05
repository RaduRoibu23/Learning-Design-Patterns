package org.poo.cb.user;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
	private final List<Account> accounts;
	private final List<Stocks> stocks;

	public Portfolio() {
		accounts = new ArrayList<Account>();
		stocks = new ArrayList<Stocks>();
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public List<Stocks> getStocks() {
		return stocks;
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public void addStock(Stocks stock) {
		stocks.add(stock);
	}

	public void removeAccount(Account account) {
		accounts.remove(account);
	}

	public void removeStock(Stocks stock) {
		stocks.remove(stock);
	}

	public Account getAccount(String currencyName) {
		for (Account account : accounts)
			if (account.getCurrencyname().equals(currencyName))
				return account;
		return null;
	}

	public Stocks getStock(String stockName) {
		for (Stocks stock : stocks)
			if (stock.getStockname().equals(stockName))
				return stock;
		Stocks stock = new Stocks(stockName, 0);
		stocks.add(stock);
		return stock;
	}

	public void addMoney(String currencyName, String a) {
		Account account = getAccount(currencyName);
		double amount = Double.parseDouble(a);
		account.addMoney(amount);
	}

	public void buyStocks(String stockName, String a) {
		Stocks stock = getStock(stockName);
		int amount = Integer.parseInt(a);
		stock.addStocks(amount);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"stocks\":[");
		for (int i = 0; i < stocks.size(); i++) {
			sb.append(stocks.get(i));
			if (i < stocks.size() - 1)
				sb.append(",");
		}
		sb.append("],\"accounts\":[");
		for (int i = 0; i < accounts.size(); i++) {
			sb.append(accounts.get(i));
			if (i < accounts.size() - 1)
				sb.append(",");
		}
		sb.append("]}");
		return sb.toString();
	}
}
