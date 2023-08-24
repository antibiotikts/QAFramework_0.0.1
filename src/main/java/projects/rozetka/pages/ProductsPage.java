package projects.rozetka.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import projects.rozetka.widgets.header.Header;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage extends Header {
    private final SelenideElement sortingSidebar = $(byXpath("//rz-filter-stack[@class='ng-star-inserted']"));
    private final SelenideElement sortingSelect = $(byXpath("//select[@class='select-css ng-untouched ng-pristine ng-valid ng-star-inserted']"));
    private final SelenideElement product = $(byClassName("goods-tile__inner"));
    private final SelenideElement productTab = $(byXpath("//rz-tabs[@class='product-tabs']"));

    public ProductsPage sortBySalesman() {
        sortingSidebar.find(byXpath(".//a[contains(@href, 'seller=rozetka')]")).click();
        return new ProductsPage();
    }

    public ProductsPage sorting(String checkbox) {
        sortingSidebar.find(withText(checkbox)).click();
        return new ProductsPage();
    }

    public ProductsPage sortBy(String sort) {
        sortingSelect.click();
        sortingSelect.find(byText(sort)).click();
        return new ProductsPage();
    }

    public ProductPage openProduct() {
        product.scrollIntoView(false).click();
        productTab.should(Condition.visible);
        return new ProductPage();
    }
}
