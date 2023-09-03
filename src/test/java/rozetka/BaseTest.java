package rozetka;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import projects.rozetka.widgets.header.Header;
import rozetka.tests_config.TestsConfig;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.browserSize;

public class BaseTest {
	protected Header header = new Header();
	protected static TestsConfig testsConfig;
	private static final Logger logger = LoggerFactory.getLogger(demoqa.positive_tests.BaseTest.class);

	public BaseTest() {
		String configFileName = "search_test.json";
		String currentDirectory = System.getProperty("user.dir");
		Path configFilePath = Paths.get(currentDirectory, "src", "test", "java", "rozetka", "tests_config", configFileName);

		try (FileReader reader = new FileReader(configFilePath.toFile())) {
			Gson gson = new Gson();
			testsConfig = gson.fromJson(reader, TestsConfig.class);

		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Test configuration file not found", e);
			throw new RuntimeException("Test configuration file not found");
		}
	}

	@BeforeSuite
	public static void setUp() {
			browserSize = testsConfig.getBrowserSize();
			timeout = testsConfig.getTimeout();
			browser = testsConfig.getBrowser();

			logger.info("Set Up: browser size- " + browserSize);
			logger.info("Set Up: timeout- " + timeout);
			logger.info("Set Up: browser- " + browser);
	}

}
