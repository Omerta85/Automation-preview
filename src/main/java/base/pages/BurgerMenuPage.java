package base.pages;

import base.config.PageTools;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static base.helpers.Conditions.*;

// Клас, який представляє сторінку з бургер-меню
public class BurgerMenuPage extends PageTools {
    // Елемент кнопки виходу
    private final SelenideElement logoutButton = $(By.xpath("//a[text()='Logout']"));
    private final By linkByID = By.xpath("//div[@class='bm-menu']//a[%d]");

    // Метод для клікання кнопки виходу
    public void clickLogout(){
        // Перевірка, чи кнопка виходу є клікабельною, а потім клікання на неї
        logoutButton.shouldBe(clickableCondition).click();
    }

    // Метод для клікання посилання на бургер-меню за ID
    public void clickLinkByID(int id){
        click(linkByID, id);
    }
}
