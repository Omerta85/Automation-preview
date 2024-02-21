package homework3;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
public class WorkElementsTest  extends BaseTest{
    @BeforeMethod
    public void logIn() {
        $(By.id("user-name")).append("standard_user");
        $(By.name("password")).append("secret_sauce");
        $(By.xpath("//input[@value='Login']")).click();
    }
    @Test
    public void elementsTest() {
        // Отримуємо список всіх товарів
        ElementsCollection itemsList = $$(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']"));

        // Проводимо ітерацію по кожному товару
        for (SelenideElement item : itemsList) {
            // Зберігаємо назву товару
            String itemName = item.$(By.className("inventory_item_name")).text();

            // Клікаємо на елемент, щоб відкрити сторінку товару
            item.click();

            // Перевіряємо, чи відкривається правильна сторінка товару
            $(By.className("inventory_details_name")).shouldHave(text(itemName));
            // Або $(By.xpath("//div[text()='" + itemName + "']")).shouldBe(visible);

            // Клікаємо на кнопку "Add to cart"
            $(By.xpath("//button[text()='Add to cart']")).click();

            // Перевіряємо, чи додається товар до кошика
            $(By.className("shopping_cart_badge")).shouldHave(text(String.valueOf(itemsList.indexOf(item) + 1)));

            // Повертаємося назад до списку товарів
            $(By.xpath("//button[text()='Back to products']")).click();

            // Перевіряємо, чи зберігається кошик
            $(By.className("shopping_cart_badge")).shouldHave(text(String.valueOf(itemsList.indexOf(item) + 1)));
        }
    }
}
