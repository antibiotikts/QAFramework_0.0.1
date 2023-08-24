package projects.rozetka.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class BasketPage {
    private final By productCart = By.xpath("//div[@class='cart-product__body']");
    private final By cartProductActions = By.xpath(".//button[@class='button button--white button--small popup-menu__toggle popup-menu__toggle--context']");
    private final By deleteProduct = By.xpath(".//ul[@class='popup-menu__actions popup-menu__actions--context']");
    private final By close = By.xpath("//button[@class='modal__close']");

    public ElementsCollection getProductsOnBasket() {
        return $$(productCart);
    }

    public BasketPage cleanBasket() {
        ElementsCollection productsCarts = getProductsOnBasket();
        if (productsCarts.size() == 0) {
            System.out.println("basket is empty");
        }
        else {
            for(SelenideElement productCart : productsCarts) {
                productCart.find(cartProductActions).click();
                productCart.find(deleteProduct).click();
            }
        }
        return this;
    }
}
