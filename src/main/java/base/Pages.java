package base;

import base.pages.*;

// Клас, що містить статичні посилання на сторінки
public class Pages {

    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static ShoppingCardPage shoppingCardPage;
    public static BurgerMenuPage burgerMenuPage;

    // Метод для отримання сторінки входу на сайт
    public static LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    // Метод для отримання головної сторінки
    public static MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    // Метод для отримання сторінки кошика покупок
    public static ShoppingCardPage shoppingCartPage() {
        if (shoppingCardPage == null) {
            shoppingCardPage = new ShoppingCardPage();
        }
        return shoppingCardPage;
    }

    // Метод для отримання сторінки бургер-меню
    public static BurgerMenuPage burgerMenuPage() {
        if (burgerMenuPage == null) {
            burgerMenuPage = new BurgerMenuPage();
        }
        return burgerMenuPage;
    }
}
