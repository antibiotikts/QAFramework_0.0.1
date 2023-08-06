package demoqa.positive_tests;

import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Configuration.*;

public class BaseTest {
	@BeforeSuite
	public static void setUp() {
		browserSize = "1920x1080";
		timeout = 4000;
		browser = "firefox";
		baseUrl = "https://demoqa.com/";
	}
}
