package lesson4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class ConditionTest extends BaseTest {
    @Test
    public void conditionTest(){
        //$(By.xpath("input[@placeholder='Username']")).shouldNotBe(Condition.visible).append("standard_user");
        $(By.xpath("input[@placeholder='Username']")).shouldBe(Condition.visible).append("standard_user");
        System.out.println($(By.xpath("//div[@id='root']")).is(Condition.exist));
        Selenide.sleep(3000);
    }
}
