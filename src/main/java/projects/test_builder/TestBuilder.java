package projects.test_builder;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import projects.test_builder.commands.JsonReader;
import projects.test_builder.commands.TestCommand;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TestBuilder {
	private static final Logger logger = LoggerFactory.getLogger(TestBuilder.class);
	private final Map<String, Class<? extends TestCommand>> commandMap = new HashMap<>();
	private Queue<TestCommand> commandQueue = new LinkedList<>();
	private final Path path;

	public TestBuilder(Path path) {
		this.path = path;
	}

	public void buildTests() throws JSONException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		JSONArray testSteps = JsonReader.getJsonArray(path);

		if(testSteps != null) {

			for (int i = 0; i < testSteps.length(); i++) {
				JSONObject step = testSteps.getJSONObject(i);
				String action = step.getString("action");
				String selector = step.getString("selector");
				String value = step.optString("value", "");

				Class<? extends TestCommand> commandClass = RegistrarOfCommands.getCommandMap().get(action.toLowerCase());
				if (commandClass != null) {
					SelenideElement element = Selenide.$(By.xpath(selector));
					TestCommand command = commandClass.getConstructor(SelenideElement.class, String.class).newInstance(element, value);
					commandQueue.add(command);
				} else {
					logger.error("Unknown action: " + action);
				}
			}
		}
		else {
			logger.error("JSONArray is empty");
		}
	}
	public void executeCommands() {
		while (!commandQueue.isEmpty()) {
			TestCommand command = commandQueue.poll();
			command.execute();
		}
	}
}
