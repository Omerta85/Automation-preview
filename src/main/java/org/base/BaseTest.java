package org.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeClass
    public void configuration(){
        Configuration.browser = "chrome";//конфігурація вибору браузера(по замовчуванню chrome
        Configuration.browserSize = "1900x810";//розмір вікна браузера
        Configuration.holdBrowserOpen = false;//дебажити
        Configuration.timeout = 10000; //час на який дається найти елемент
        Configuration.pageLoadTimeout = 10000; // час коли запускаються тест після відкриття і прогрузки сайту
        Configuration.headless = false; //візуально не побачим браузера. позамовчуванню false
        Configuration.screenshots = true;// скриншот де відбулася помилка
        Configuration.savePageSource = false;
    }
    @BeforeMethod
    public void setUp(){
        Selenide.open("https://www.google.com");
    }
    @AfterMethod
    public void cleanWebDriver(){
        Selenide.clearBrowserCookies();
        Selenide.refresh();
        Selenide.open("about:blank");
    }
    @AfterClass
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
