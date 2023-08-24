package projects.rozetka.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ComparisonPopup {
    private final By comparisonProducts = By.xpath("//li[@class='comparison-modal__item ng-star-inserted']");
    private final By hrefOnComparison = By.xpath(".//a[@class='comparison-modal__link']");
    private final By delButton = By.xpath(".//button[@class='button button--medium button--icon button--white comparison-modal__remove']");
    private final By closeButton = By.xpath("//button[@class='modal__close']");

    public ElementsCollection getComparisonProducts() {
        return $$(comparisonProducts);
    }

    public ComparisonPopup openComparisonPage() {
        $(comparisonProducts).find(hrefOnComparison).click();
        return this;
    }

    public ComparisonPopup cleanComparison() {
        ElementsCollection products = $$(comparisonProducts);
        if (products.size()!=0) {
            for (SelenideElement product : products) {
                product.find(delButton).click();
            }
        }
        return this;
    }

    public void closeComparisonPopup() {
        $(closeButton).click();
    }
}
