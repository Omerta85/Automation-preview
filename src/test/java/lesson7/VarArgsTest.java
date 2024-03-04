package lesson7;

import base.Pages;
import base.config.BaseTest;
import base.pages.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

// Клас для тестування різних сценаріїв використання сторінок
public class VarArgsTest extends BaseTest {

    // Тест для перевірки отримання детальної інформації про товари зі списку
    @Test
    public void test(){
        // Авторизація на сайті
        Pages.loginPage().typeUsername("standard_user");
        Pages.loginPage().typePassword("secret_sauce");
        Pages.loginPage().clickSubmit();

        // Очікування завантаження головної сторінки
        Pages.mainPage().waitUntilMainPage();

        // Отримання списку товарів на головній сторінці
        List<Item> itemListFromMainPage = Pages.mainPage().getItemList();

        // Перебір всіх товарів на головній сторінці
        for (int i = 1; i <= itemListFromMainPage.size(); i++) {
            // Клік на заголовок товару за його індексом
            Pages.mainPage().clickHeaderByID(i);

            // Отримання детальної інформації про товар
            Item detailedItem = Pages.detailsItemPage().getDetailedItem();

            // Перевірка, чи міститься отриманий товар у списку товарів з головної сторінки
            Assert.assertTrue(itemListFromMainPage.contains(detailedItem), "Item is not present in the list of items");

            // Повернення на головну сторінку
            Pages.detailsItemPage().clickBackToProducts();
        }
    }

    // Тест для перевірки переходу за посиланням у бургер-меню
    @Test
    public void test2(){
        // Авторизація на сайті
        Pages.loginPage().typeUsername("standard_user");
        Pages.loginPage().typePassword("secret_sauce");
        Pages.loginPage().clickSubmit();

        // Очікування завантаження головної сторінки
        Pages.mainPage().waitUntilMainPage();

        // Клік на кнопку бургер-меню
        Pages.mainPage().clickBurgerMenuButton();

        // Клік на певне посилання у бургер-меню за його індексом
        Pages.burgerMenuPage().clickLinkByID(3);
    }
}
