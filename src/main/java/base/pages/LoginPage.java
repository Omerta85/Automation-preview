package base.pages;

import base.config.PageTools;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static base.helpers.Conditions.*;

// Клас, який представляє сторінку входу на сайт
public class LoginPage extends PageTools {
    // Елемент для поля введення імені користувача
    private final By usernameInput = By.xpath("//input[@placeholder='Username']");
    // Елемент для поля введення пароля
    private final By passwordInput = By.xpath("//input[@placeholder='Password']");
    // Елемент для кнопки відправки форми
    private final By submitButton = By.xpath("//input[@value='Login']");

    // Метод для введення імені користувача
    public void typeUsername(String username) {
        type(username, usernameInput);
    }

    // Метод для введення пароля
    public void typePassword(String password) {
        type(password, passwordInput);
    }

    // Метод для кліку на кнопку відправки форми
    public void clickSubmit() {
       click(submitButton);
    }
}
