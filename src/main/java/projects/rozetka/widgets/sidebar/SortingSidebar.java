package projects.rozetka.widgets.sidebar;

import com.codeborne.selenide.SelenideElement;
import projects.rozetka.pages.ProductsPage;


import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class SortingSidebar {
    private final SelenideElement sortingSidebar = $(byXpath("//rz-filter-stack[@class='ng-star-inserted']"));

    public ProductsPage sortBySalesman() {
        sortingSidebar.find(byXpath(".//a[contains(@href, 'seller=rozetka')]")).click();
        return new ProductsPage();
    }

    public ProductsPage sorting(String subcategory, String checkbox) {
        sortingSidebar
                .find(byXpath("//span[text()=' "+subcategory+" ']/../.."))
                .find(withText(checkbox))
                .click();
        return new ProductsPage();
    }
}
