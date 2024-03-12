package gui.lesson3;

import com.codeborne.selenide.*;
import org.apache.commons.io.FileUtils;
import base.config.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class WorkWithElementsTest extends BaseTest {

   // @BeforeMethod
    public void logIn(){
        $(By.id("user-name")).append("standard_user");
//        $(By.className("input_error")).append("test");
//        $(By.tagName("input")).append("Test2");
        $(By.name("password")).append("secret_sauce");
        //      $(By.xpath("//input[@value='Login']")).submit();
       // $(By.xpath("//input[@value='Login']")).click();
        Selenide.actions().sendKeys(Keys.ENTER).perform(); //Вхід використанням клавіші ентер

        $(By.xpath("//select[@class='product_sort_container']")).click();
        sleep(1000);
        Selenide.actions().sendKeys(Keys.ESCAPE).perform();
    }

   // @Test (priority = 1)
    public void oktenHoverTest(){
        Selenide.open("https://owu.com.ua/");
        sleep(1000);
        $(By.xpath("//nav/div[1]")).hover();
    }

    @BeforeMethod
    public void download(){
        Configuration.fileDownload = FileDownloadMode.FOLDER;
    }

    public static String getFilePathByName(String fileName){
        return new File("src/main/resources/files/" + fileName).getAbsolutePath();
    }

    //@Test
    public void downloadTest(){
        Selenide.open("https://www.stats.govt.nz/large-datasets/csv-files-for-download/");
        sleep(1000);
        $(By.xpath("(//h3/a)[1]")).scrollTo();

        try{
           File download = $(By.xpath("(//h3/a)[1]")).download();

           sleep(3000);

           String path = download.getPath();

            System.out.println(path);

            FileUtils.deleteDirectory(new File("build/downloads"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void uploadFileTest(){
        Selenide.open("https://ps.uci.edu/~franklin/doc/file_upload.html");

        sleep(3000);

        $(By.xpath("//input[@type='file']")).uploadFile(new File(getFilePathByName("annual-enterprise-survey-2021-financial-year-provisional-size-bands-csv.csv")));
    }


    //@Test(priority = 2)
    public void elementsTest(){
        String app_Logo_Text = $(By.xpath("//div[@class='app_logo']")).getText();
        System.out.println(app_Logo_Text);
    //$(By.xpath("(//div[@class='inventory_list']/div[@class='inventory_item']//*[text()='Add to cart'])[4]")).click();
    $(By.xpath("//div[text()='Sauce Labs Fleece Jacket']//ancestor::div[@class='inventory_item_description']//*[text()='Add to cart']")).click();

    ElementsCollection headerList =  $$(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name ']"));
    // headerList.get(1).click();

    ElementsCollection buttonList = $$(By.xpath("//button[text()='Add to cart']"));
    // while ($$(By.xpath("//button[text()='Add to cart']")).size() > 0) {
//            $(By.xpath("//button[text()='Add to cart']")).click();
//        }
    for(SelenideElement button : buttonList) {
        button.click();
    }

    List<String> headersTextsList = $$(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name ']")).texts();

    int sauceLabsFleeceJacket = headersTextsList.indexOf("Sauce Labs Fleece Jacket");
    headerList.get(sauceLabsFleeceJacket).click();
    }
}
