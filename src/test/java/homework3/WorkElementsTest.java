package homework3;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
            // Клікаємо на елемент, щоб відкрити сторінку товару
            item.click();

            // Клікаємо на кнопку "Add to cart"
            $(By.xpath("//button[text()='Add to cart']")).click();

            // Повертаємося назад до списку товарів
            $(By.xpath("//button[text()='Back to products']")).click();
        }
    }

}
