package demoqa.positive_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import projects.demoqa.pages.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class HomePageTest extends BaseTest {

	private final HomePage homePage = new HomePage();

	@BeforeTest
	public void openSite() {
		System.out.println("open site");
		open("https://demoqa.com/");
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
		System.out.println($(By.className("main-header")).getText());
		Assert.assertEquals(name, $(By.className("main-header")).getText());
		back();
	}
}
