package test_builder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projects.test_builder.CommandExecutor;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.open;

public class TestSuite {

	@BeforeMethod
	public void openURL() {
		open("https://rozetka.com.ua/");
	}

	@Test
	public void runJsonBasedTest() throws IllegalAccessException, InstantiationException, JSONException, IOException {
		String configFileName = "testsConfig.json";
		String currentDirectory = System.getProperty("user.dir");
		Path configFilePath = Paths.get(currentDirectory, "src", "test", "java", "test_builder", configFileName);

		String jsonContent = new String(Files.readAllBytes(configFilePath));
		JSONArray testSteps = new JSONArray(jsonContent);

		for (int i = 0; i < testSteps.length(); i++) {
			JSONObject step = testSteps.getJSONObject(i);
			String action = step.getString("action");
			String selector = step.getString("selector");
			String value = step.optString("value", "");
			CommandExecutor.executeCommand(action, selector, value);
		}
	}
}
