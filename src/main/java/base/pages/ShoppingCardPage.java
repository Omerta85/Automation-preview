package base.pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static base.helpers.Conditions.*;

// Клас, який представляє сторінку кошика покупок
public class ShoppingCardPage {

    // Елемент для кнопки "Продовжити покупки"
    private final SelenideElement continueShopping = $(By.xpath("//button[@id='continue-shopping']"));

    // Метод для кліку на кнопку "Продовжити покупки"
    public void clickContinueShopping() {
        continueShopping.shouldBe(clickableCondition).click();
    }
}
