package base.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static base.helpers.Conditions.*;

// Клас, який представляє сторінку з бургер-меню
public class BurgerMenuPage {
    // Елемент кнопки виходу
    private final SelenideElement logoutButton = $(By.xpath("//a[text()='Logout']"));

    // Метод для клікання кнопки виходу
    public void clickLogout(){
        // Перевірка, чи кнопка виходу є клікабельною, а потім клікання на неї
        logoutButton.shouldBe(clickableCondition).click();
    }
}
