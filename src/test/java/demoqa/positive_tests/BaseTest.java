package demoqa.positive_tests;

import demoqa.tests_params.TestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.json.JSONObject;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static com.codeborne.selenide.Configuration.*;

public class BaseTest {
	private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

	@BeforeSuite
	public static void setUp() {

		String configFilePath = "src/test/java/demoqa/tests_params/testConfig.json";

		try (FileReader reader = new FileReader(configFilePath)) {
			Gson gson = new Gson();
			TestConfig testConfig = gson.fromJson(reader, TestConfig.class);

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
}
