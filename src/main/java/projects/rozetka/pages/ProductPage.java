package projects.rozetka.pages;

import org.openqa.selenium.By;
import projects.rozetka.widgets.header.Header;


import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;


public class ProductPage extends Header {
    private final By productBody = By.xpath("//div[@class='product-about']");
    private final By product = By.xpath("//button[@class='buy-button button button--with-icon button--green button--medium ng-star-inserted']");
    private final By basketClose = By.xpath("//button[@class='modal__close']");
    private final By comparisonButton = By.xpath("//button[@class='compare-button ng-star-inserted']");

    public ProductPage addOnBasket2() {
        actions().moveToElement($(product)).click().perform();
        $(basketClose).should(appear, Duration.ofSeconds(10)).click();
        return this;
    }

    public ProductPage addOnComparison() {
        actions().scrollToElement($(comparisonButton)).click().perform();
        return this;
    }
}
