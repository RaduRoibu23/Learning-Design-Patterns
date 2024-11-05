package org.poo.cb.utils;

import org.poo.cb.cmds.*;

public class CommandExecutor {
	public static CommandExecutor instance = null;

	private CommandExecutor() {
	}

	public static CommandExecutor getInstance() {
		if (instance == null)
			instance = new CommandExecutor();

		return instance;
	}

	public Command getCommand(String commandName) {
		if (commandName.equals("CREATE USER"))
			return new CreateUser();
		else if (commandName.equals("ADD FRIEND"))
			return new AddFriend();
		else if (commandName.equals("ADD ACCOUNT"))
			return new AddAccount();
		else if (commandName.equals("ADD MONEY"))
			return new AddMoney();
		else if (commandName.equals("EXCHANGE MONEY"))
			return new ExchangeMoney();
		else if (commandName.equals("TRANSFER MONEY"))
			return new TransferMoney();
		else if (commandName.equals("BUY STOCKS"))
			return new BuyStocks();
		else if (commandName.equals("RECOMMEND STOCKS"))
			return new RecommendStocks();
		else if (commandName.equals("LIST USER"))
			return new ListUser();
		else if (commandName.equals("LIST PORTFOLIO"))
			return new ListPortfolio();
		else
			return null;
	}

	public void run(String commandName, String[] args) {
		Command command = getCommand(commandName);
		if (command != null)
			command.execute(args);
	}
}
