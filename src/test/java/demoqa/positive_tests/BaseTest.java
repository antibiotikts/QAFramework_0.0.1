package demoqa.positive_tests;

import com.codeborne.selenide.Selenide;
import demoqa.tests_config.BaseTestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

import static com.codeborne.selenide.Configuration.*;
import java.nio.file.Paths;
public class BaseTest {
	private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

	@BeforeSuite
	public static void setUp() {
		String configFileName = "testConfig.json";
		String currentDirectory = System.getProperty("user.dir");
		String configFilePath = Paths.get(currentDirectory, "src", "test", "java", "demoqa", "tests_config", configFileName).toString();

		try (FileReader reader = new FileReader(configFilePath)) {
			Gson gson = new Gson();
			BaseTestConfig testConfig = gson.fromJson(reader, BaseTestConfig.class);

			browserSize = testConfig.getBrowserSize();
			timeout = testConfig.getTimeout();
			browser = testConfig.getBrowser();

			logger.info("Set Up: browser size- " + browserSize);
			logger.info("Set Up: timeout- " + timeout);
			logger.info("Set Up: browser- " + browser);

		} catch (IOException e) {
			e.printStackTrace();
			logger.error("File with settings not found", e);
		}
	}

	@AfterSuite
	public void closeBrowser() {
		Selenide.closeWebDriver();
	}
}
