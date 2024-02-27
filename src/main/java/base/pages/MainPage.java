package base.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static base.helpers.Conditions.clickableCondition;
import static base.helpers.Conditions.collectionSizeCondition;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final SelenideElement logo = $(By.xpath("//div[@class='app_logo']"));
    private final SelenideElement shoppingCard = $(By.xpath("//a[@class='shopping_cart_link']"));
    private final SelenideElement twitterButton = $(By.xpath("//a[text()='Twitter']"));
    private final SelenideElement burgerMenu = $(By.xpath("//button[text()='Open Menu']"));
    // waiters
    public void waitUntilMainPage() {
        logo.shouldBe(Condition.visible, Duration.ofMillis(20000));
    }
    private final ElementsCollection itemHeaders = $$(By.xpath("//div[@class='inventory_item_name ']"));
    private final ElementsCollection buttons = $$(By.xpath("//button[text()='Add to cart']"));
    //getters
    public ElementsCollection getItemHeaders() {
        return itemHeaders.shouldBe(collectionSizeCondition);
    }

    public List<String> getItemHeadersTexts() {
        return itemHeaders.shouldBe(collectionSizeCondition).texts();
    }

    public ElementsCollection getButtons() {
        return buttons.shouldBe(collectionSizeCondition);
    }
    //clickers
    public void clickShoppingCard(){
        shoppingCard.shouldBe(clickableCondition).click();
    }
    public void clickTwitterButton(){
        twitterButton.shouldBe(clickableCondition).click();
    }
    public void clickBurgerMenuButton(){
        burgerMenu.shouldBe(clickableCondition).click();
    }
}
