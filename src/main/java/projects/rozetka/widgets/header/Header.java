package projects.rozetka.widgets.header;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import projects.rozetka.pages.*;

import static com.codeborne.selenide.Selenide.$;

public class Header {
    private final SelenideElement header = $(By.xpath("//header[@class='header']"));
    private final By headerMenu = By.xpath(".//button[@class='header__button ng-tns-c109-1']");
    private final By headerCatalog = By.xpath(".//button[@class='button button--medium button--with-icon menu__toggle ng-star-inserted']");
    private final By headerSearchInput = By.xpath(".//input[@name='search']");
    private final By headerButtonSearchInput = By.xpath(".//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']");
    private final By headerLogin = By.xpath(".//rz-user[@class='header-actions__component']");
    private final By headerComparison = By.xpath(".//rz-comparison[@class='header-actions__component']");
    private final By headerBasket = By.xpath(".//rz-cart[@class='header-actions__component']");


    public HeaderMenuPage openHeaderMenu() {
        header.find(headerMenu).click();
        return new HeaderMenuPage();
    }

    public CatalogPage openHeaderCatalog() {
        header.find(headerCatalog).click();
        return new CatalogPage();
    }

    public ProductsPage headerSearchInput(String input) {
        header.find(headerSearchInput).setValue(input).pressEnter();
       //header.find(headerButtonSearchInput).click();
        return new ProductsPage();
    }

    public LoginPage openHeaderLogin() {
        header.find(headerLogin).click();
        return new LoginPage();
    }

    public ComparisonPopup openHeaderComparison() {
        header.find(headerComparison).click();
        return new ComparisonPopup();
    }

    public BasketPage openHeaderBasket() {
        header.find(headerBasket).click();
        return new BasketPage();
    }
}
