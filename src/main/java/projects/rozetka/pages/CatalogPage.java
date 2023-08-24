package projects.rozetka.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import projects.rozetka.widgets.header.Header;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class CatalogPage extends Header {
    private final SelenideElement menu = $(By.xpath("//div[@class='menu-wrapper menu-wrapper_state_animated']"));

    public CatalogPage goToMenuItem(By item) {
        actions().moveToElement(menu.find(item)).perform();
        return this;
    }

    public ProductsPage openProducts(String category, String subcategory, String products) {
        actions().moveToElement($(byText(category))).perform();
        $(byXpath("//a[text() = '"+subcategory+"']/..")).find(byText(products)).click();
        return new ProductsPage();
    }
}
