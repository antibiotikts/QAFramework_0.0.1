package test_builder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projects.test_builder.CommandExecutor;
import projects.test_builder.TestBuilder;
import projects.test_builder.commands.JsonReader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

public class TestSuite {

	@BeforeMethod
	public void openURL() {
		open("https://rozetka.com.ua/");
	}

	@Test
	public void runJsonBasedTest() throws IllegalAccessException, InstantiationException, JSONException, IOException, InvocationTargetException, NoSuchMethodException {
		String configFileName = "testsConfig.json";
		String currentDirectory = System.getProperty("user.dir");
		Path configFilePath = Paths.get(currentDirectory, "src", "test", "java", "test_builder", configFileName);

		TestBuilder tests = new TestBuilder(configFilePath);
		tests.buildTests();
		tests.executeCommands();
	}
}
