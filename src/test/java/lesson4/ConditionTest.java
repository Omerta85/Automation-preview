package lesson4;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ConditionTest extends BaseTest {

    @Test
    public void checkBoxTest() {
        // Відкриваємо сторінку з чекбоксами
        open("https://faculty.washington.edu/chudler/java/boxes.html");
        Selenide.sleep(3000);

        // Отримуємо колекцію чекбоксів
        ElementsCollection checkBoxes = $$(By.xpath("//input[@type='checkbox']"));

        // Клікаємо на кожен чекбокс та перевіряємо, що він відмічений
        for (int i = 0; i < checkBoxes.size(); i++) {
            checkBoxes.get(i).click();
            Assert.assertTrue(checkBoxes.get(i).is(Condition.checked));
        }
    }

    // @Test
    public void conditionTest() {
        // Умова "клікабельно"
        Condition clickable = Condition.and("should be clickable", Condition.visible, Condition.enabled);

        // Використовуємо умови для перевірки різних станів елементів на сторінці

        // Перевіряємо видимість елементу та вставляємо текст(перевіряємо імпути)
        // $(By.xpath("//input[@placeholder='Username']")).shouldNotBe(Condition.visible).append("standard_user");
        $(By.xpath("//input[@placeholder='Username']")).shouldBe(Condition.visible).append("standard_user");
        // Перевіряємо існування елементу
        System.out.println($(By.xpath("//div[@id='root']")).is(Condition.exist));
        //        $(By.xpath("//input[@placeholder='Username']")).shouldNotBe(Condition.readonly).append("standard_user");
//        $(By.xpath("//input[@placeholder='Username']")).shouldBe(Condition.empty).append("standard_user");

        //        $(By.xpath("//input[@type='submit']")).shouldBe(Condition.enabled).click();
//        System.out.println($(By.xpath("//div[@id='root']")).is(Condition.visible));

//        $(By.xpath("//div[@class='loading_spinner']")).shouldBe(Condition.hidden, Duration.ofMillis(60000));

        // Перевіряємо пустоту елементу та вставляємо текст
        $(By.xpath("//input[@placeholder='Password']")).shouldHave(Condition.id("password")).shouldBe(Condition.empty).append("secret_sauce");

        // Перевіряємо атрибут та клацати на елемент
        $(By.xpath("//input[@type='submit']")).shouldHave(Condition.name("login-button")).shouldBe(clickable).click();

        // Перевірка вмісту списку елементів та інших умов
        //        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.empty);
        List<String> itemHeadersList = $$(By.xpath("//div[@class='inventory_item_name ']")).texts();
        ElementsCollection itemsList = $$(By.xpath("//div[@class='inventory_item_name ']"));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.size(6));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.sizeNotEqual(0));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.sizeLessThan(7));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.sizeLessThanOrEqual(6));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.sizeGreaterThan(5));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.sizeGreaterThanOrEqual(6));

        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.texts("Backpack", "Light", "Bolt", "fleece", "Onesie", "red"));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.textsInAnyOrder("Backpack", "Light", "Bolt", "fleece", "red", "onesie"));


        // Перевірка тексту та інших умов для списку елементів
        List<String> expectedItemHeadersList = new ArrayList<>();
        expectedItemHeadersList.add("Sauce Labs Backpack");
        expectedItemHeadersList.add("Sauce Labs Bike Light");
        expectedItemHeadersList.add("Sauce Labs Bolt T-Shirt");
        expectedItemHeadersList.add("Sauce Labs Fleece Jacket");
        expectedItemHeadersList.add("Sauce Labs Onesie");
        expectedItemHeadersList.add("Test.allTheThings() T-Shirt (Red)");


        // Перевірка наявності елементів в колекції та наявності конкретного значення
        Assert.assertEquals(itemHeadersList.get(1), "Sauce Labs Bike Light", "Values are not equals");
        Assert.assertEquals(itemHeadersList, expectedItemHeadersList, "Lists are not equals");

        Assert.assertFalse(itemsList.isEmpty());
        Assert.assertTrue(itemsList.texts().contains("Sauce Labs Bike Light"));
    }
}
