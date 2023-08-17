package demoqa.positive_tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Configuration.*;

public class BaseTest {
	private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

	@BeforeSuite
	public static void setUp() {
		browserSize = "1920x1080";
		timeout = 4000;
		browser = "firefox";

		logger.info("Set Up: browser size- " + browserSize);
		logger.info("Set Up: timeout- " + timeout);
		logger.info("Set Up: browser- " + browser);
	}
}
