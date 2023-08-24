package projects.rozetka.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderMenuPage {
    private final SelenideElement headerMenu = $(By.xpath("//div[@class='side-menu drawer-content drawer-content_state_visible']"));
}
