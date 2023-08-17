package demoqa.positive_tests;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import projects.demoqa.pages.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class HomePageTest extends BaseTest {

	private static final String URL = "https://demoqa.com/";

	private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

	private final HomePage homePage = new HomePage();

	@BeforeClass
	public void openSite() {
		open(URL);
		logger.info(URL + "is opened");
	}

	@DataProvider(name = "data")
	public Object[][] testDat() {
		Object[][] data = new Object[homePage.getCardsName().length][1];
		for (int i = 0; i < homePage.getCardsName().length; i++) {
			data[i][0] = homePage.getCardsName()[i];
		}
		return data;
	}

	@Test(dataProvider = "data")
	public void testing(String name) {

		homePage.openCard(name);
		logger.info("test param: " + name);
		Assert.assertEquals(name, $(By.className("main-header")).getText());
		back();
	}
}
