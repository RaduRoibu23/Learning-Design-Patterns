package org.poo.cb;

import org.poo.cb.utils.CommandExecutor;
import org.poo.cb.utils.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		if (args == null) {
			System.out.println("Running Main");
			return;
		}

		List<String> commands = new ArrayList<>();
		String path = "src/main/resources/";

		try {
			FileReader fr = new FileReader(path + args[2]);
			BufferedReader reader = new BufferedReader(fr);
			String line;

			while ((line = reader.readLine()) != null)
				commands.add(line);

			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		Database.getInstance().init(path + args[1], path + args[0]);
		CommandExecutor executor = CommandExecutor.getInstance();

		for (String command : commands) {
			String[] split = command.split(" ");
			String commandName = split[0] + " " + split[1];
			String[] commandArgs = new String[split.length - 2];
			commandArgs = List.of(split).subList(2, split.length).toArray(commandArgs);
			executor.run(commandName, commandArgs);
		}
	}
}