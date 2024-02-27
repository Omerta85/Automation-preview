package base.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static base.helpers.Conditions.*;

// Клас, який представляє сторінку входу на сайт
public class LoginPage {
    // Елемент для поля введення імені користувача
    private final SelenideElement usernameInput = $(By.xpath("//input[@placeholder='Username']"));
    // Елемент для поля введення пароля
    private final SelenideElement passwordInput = $(By.xpath("//input[@placeholder='Password']"));
    // Елемент для кнопки відправки форми
    private final SelenideElement submitButton = $(By.xpath("//input[@value='Login']"));

    // Метод для введення імені користувача
    public void typeUsername(String username) {
        usernameInput.shouldBe(inputCondition).append(username);
    }

    // Метод для введення пароля
    public void typePassword(String password) {
        passwordInput.shouldBe(inputCondition).append(password);
    }

    // Метод для кліку на кнопку відправки форми
    public void clickSubmit() {
        submitButton.shouldBe(clickableCondition).click();
    }
}
