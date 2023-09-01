package projects.test_builder;

import java.util.HashMap;
import java.util.Map;

public class TestBuilder {
	private static final Map<String, Class<? extends TestCommand>> commandMap = new HashMap<>();

		static {
			commandMap.put("click", ClickCommand.class);
			commandMap.put("type", TypeCommand.class);
		}

	public static Map<String, Class<? extends TestCommand>> getCommandMap() {
		return commandMap;
	}
}
