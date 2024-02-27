package lesson5;

import base.Pages;
import base.config.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class PatternsTest extends BaseTest {

    String username = "standard_user";
    String password = "secret_sauce";

    // Тест для перевірки патернів
    @Test
    public void pattern(){
        // Введення імені користувача
        Pages.loginPage.typeUsername(username);
        // Введення пароля
        Pages.loginPage.typePassword(password);
        // Клік на кнопку відправки форми
        Pages.loginPage.clickSubmit();

        // Очікування завантаження головної сторінки
        Pages.mainPage.waitUntilMainPage();
//         List<String> itemHeadersTextsList = Pages.mainPage().getItemHeadersTexts();
//        System.out.println(itemHeadersTextsList);
//        Pages.mainPage().getButtons().get(3).click();
//        Pages.mainPage().clickShoppingCard();
//        Pages.shoppingCardPage().clickContinueShopping();
//        ElementsCollection itemHeaders = Pages.mainPage().getItemHeaders();
//        itemHeaders.get(1).click();
                // Клік на кнопку Twitter
                Pages.mainPage().clickTwitterButton();

                // Переключення на нове вікно
                Selenide.switchTo().window(1);

                // Затримка для завантаження сторінки
                Selenide.sleep(5000);

                // Перевірка наявності елементу на новій сторінці
                Assert.assertTrue($(By.xpath("//span[text()='Sauce Labs']")).is(Condition.visible));

                // Закриття вікна
                Selenide.closeWindow();

                // Повернення до початкового вікна
                Selenide.switchTo().window(0);

                // Клік на кнопку бургер-меню
                Pages.mainPage().clickBurgerMenuButton();

                // Клік на кнопку виходу з облікового запису
                Pages.burgerMenuPage().clickLogout();

//        actions().keyDown(Keys.CONTROL)  open new tab from the keyboard
//                .sendKeys("t")
//                .keyUp(Keys.CONTROL)
//                .build()
//                .perform();

    }
}
