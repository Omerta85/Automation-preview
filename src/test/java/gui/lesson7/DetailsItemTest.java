package gui.lesson7;

import base.Pages;
import base.config.BaseTest;
import base.pages.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

// Клас для тестування отримання детальної інформації про товар
public class DetailsItemTest extends BaseTest {

    // Тест для перевірки отримання детальної інформації про товар
    @Test
    public void detailsTest(){
        // Авторизація на сайті
        Pages.loginPage().typeUsername("standard_user");
        Pages.loginPage().typePassword("secret_sauce");
        Pages.loginPage().clickSubmit();

        // Очікування завантаження головної сторінки
        Pages.mainPage().waitUntilMainPage();

        // Отримання списку товарів на головній сторінці
        List<Item> itemListFromMainPage = Pages.mainPage().getItemList();

        // Клік на певний товар для отримання детальної інформації
        Pages.mainPage().getItemHeaders().get(5).click();

        // Отримання детальної інформації про товар
        Item detailedItem = Pages.detailsItemPage().getDetailedItem();

        // Перевірка, чи міститься отриманий товар у списку товарів з головної сторінки
        Assert.assertTrue(itemListFromMainPage.contains(detailedItem), "Item is not present in the list of items");
    }
}
