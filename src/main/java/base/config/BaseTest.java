package base.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

// Базовий клас для налаштування тестів
public class BaseTest {

    // Метод, який виконує конфігурацію перед початком виконання класу
    @BeforeClass
    public void configuration(){
        Configuration.browser = "edge";// Вибір браузера (за замовчуванням - Chrome)
        Configuration.browserSize = "1280x920";// Розмір вікна браузера
        Configuration.holdBrowserOpen = true;// Для дебагу
        Configuration.timeout = 10000; // Час очікування для знаходження елемента
        Configuration.pageLoadTimeout = 30000; // Час очікування завантаження сторінки
        Configuration.headless = false; // Невідображення браузера (за замовчуванням - false)
        Configuration.screenshots = true;// Зйомка екрану при помилці
        Configuration.savePageSource = false;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    // Метод, який виконує підготовку перед кожним тестом
    @BeforeMethod
    public void setUp(){
        Selenide.open("https://www.saucedemo.com/");
    }

//    @AfterMethod
//    public void cleanWebDriver(){
//        Selenide.clearBrowserCookies();
//        Selenide.refresh();
//        Selenide.open("about:blank");
//    }

    // Метод, який виконує завершення роботи після виконання всіх тестів у класі
    @AfterClass
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
