package projects.rozetka.pages;

import org.openqa.selenium.By;
import projects.rozetka.widgets.header.Header;


import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final By emailInput = By.xpath("//input[@type='email']");
    private final By passwordInput = By.xpath("//input[@type='password']");
    private final By closeButton = By.xpath("//button[@class='modal__close']");
    private final By segInButton = By.xpath("//button[@class='modal__close']");

    public LoginPage enterEmail(String email) {
        $(emailInput).setValue(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $(passwordInput).setValue(password);
        return this;
    }

    public void segInClick() {
        $(segInButton).click();
    }

    public Header closeLoginPage() {
        $(closeButton).click();
        return new Header();
    }
}
