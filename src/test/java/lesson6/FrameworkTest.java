package lesson6;

import base.Pages;
import base.config.BaseTest;
import org.testng.annotations.Test;

/**
 * Клас `FrameworkTest` виконує автоматизований тестувальний сценарій за допомогою тестового фреймворку TestNG.
 * Цей клас є частиною тестового фреймворку, який використовується для тестування веб-сторінок.
 * Він успадковує конфігураційні налаштування з класу `BaseTest`, який містить методи налаштування перед тестуванням та завершення після тестування.
 */
public class FrameworkTest extends BaseTest {

    /**
     * Метод `test` виконує тестовий сценарій, що перевіряє роботу сторінки логування.
     * Виконує введення логіна та пароля, а потім клікає на кнопку "Submit".
     */
    @Test
    public void test(){
        Pages.loginPage().typeUsername("standard_user"); // Введення логіна
        Pages.loginPage().typePassword("secret_sauce"); // Введення пароля
        Pages.loginPage().clickSubmit(); // Клік на кнопку "Submit"
    }
}
