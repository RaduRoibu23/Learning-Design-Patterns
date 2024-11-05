package org.poo.cb.utils;

import org.poo.cb.user.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Database {
	private static Database instance = null;
	private List<User> users;
	private List<String> stockValues;
	private List<String> exchangeRates;

	private Database() {
	}

	public static Database getInstance() {
		if (instance == null)
			instance = new Database();

		return instance;
	}

	public List<User> getUsers() {
		return users;
	}

	public List<String> getStockValues() {
		return stockValues;
	}

	public List<String> getExchangeRates() {
		return exchangeRates;
	}

	public User getUser(String email) {
		for (User user : users)
			if (user.getEmail().equals(email))
				return user;
		return null;
	}

	public void addUser(User user) {
		users.add(user);
	}

	public double getExchangeRate(String currency1, String currency2) {
		String[] currencies = {"EUR", "GBP", "JPY", "CAD", "USD"};

		int index1 = -1;
		for (int i = 0; i < currencies.length; i++) {
			if (currencies[i].equals(currency1)) {
				index1 = i;
				break;
			}
		}

		for (String exchangeRate : exchangeRates) {
			String[] parts = exchangeRate.split(",");
			if (parts[0].equals(currency2)) {
				return Double.parseDouble(parts[index1 + 1]);
			}
		}

		return 0;
	}

	public double getStockValue(String stock) {
		for (String stockValue : stockValues) {
			String[] parts = stockValue.split(",");
			if (parts[0].equals(stock))
				return Double.parseDouble(parts[10]);
		}
		return 0;
	}

	public void init(String stockValuesPath, String exchangeRatesPath) {
		users = new ArrayList<>();
		stockValues = new ArrayList<>();
		exchangeRates = new ArrayList<>();

		try {
			FileReader fr1 = new FileReader(stockValuesPath);
			FileReader fr2 = new FileReader(exchangeRatesPath);
			BufferedReader reader1 = new BufferedReader(fr1);
			BufferedReader reader2 = new BufferedReader(fr2);

			String line;

			while ((line = reader1.readLine()) != null)
				stockValues.add(line);

			while ((line = reader2.readLine()) != null)
				exchangeRates.add(line);

			reader1.close();
			reader2.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
