package projects.test_builder;

import projects.test_builder.commands.ClickCommand;
import projects.test_builder.commands.TestCommand;
import projects.test_builder.commands.TypeCommand;

import java.util.HashMap;
import java.util.Map;

public class RegistrarOfCommands {
	private static final Map<String, Class<? extends TestCommand>> commandMap = new HashMap<>();

		static {
			commandMap.put("click", ClickCommand.class);
			commandMap.put("type", TypeCommand.class);
		}

	public static Map<String, Class<? extends TestCommand>> getCommandMap() {
		return commandMap;
	}
}
