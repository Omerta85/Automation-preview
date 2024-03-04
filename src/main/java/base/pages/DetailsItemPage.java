package base.pages;

import base.config.PageTools;
import org.openqa.selenium.By;

// Клас, що представляє сторінку з детальною інформацією про товар
public class DetailsItemPage extends PageTools {

    // Локатори елементів на сторінці
    private final By header = By.xpath("//div[contains(@class,'inventory_details_name')]");
    private final By description = By.xpath("(//div[contains(@class,'inventory_details_desc')])[2]");
    private final By price = By.xpath("//div[@class='inventory_details_price']");
    private final By backToProducts = By.xpath("//button[text()='Back to products']");

    // Метод, який отримує детальну інформацію про товар
    public Item getDetailedItem() {
        Item item = new Item();

        // Отримання назви, опису та ціни товару із відповідних елементів на сторінці
        item.setName(getElementText(header));
        item.setDescription(getElementText(description));
        item.setPrice(getElementText(price));
        return item;
    }

    // Метод для клікання на кнопку "Back to products"
    public void clickBackToProducts(){
        click(backToProducts);
    }
}
