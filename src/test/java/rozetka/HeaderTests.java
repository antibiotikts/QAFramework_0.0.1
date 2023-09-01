package rozetka;

import com.codeborne.selenide.Selenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;

public class HeaderTests extends BaseTest {
	private static final Logger logger = LoggerFactory.getLogger(HeaderTests.class);

	@BeforeMethod
	public void openUrl() {
		open("https://rozetka.com.ua/");
	}

	@AfterMethod
	public void closeBrowser() {
		Selenide.closeWebDriver();
	}

	@Test
	public void searchInputTest() {
		header.headerSearchInput(testsConfig.getSearchInput());
	}
}
