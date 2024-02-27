/**
 * Клас `PageTools` надає набір методів для взаємодії з елементами веб-сторінок.
 * Використовується для автоматизованого тестування за допомогою Selenium та Selenide.
 */
package base.config;

import base.logger.*;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static base.helpers.Conditions.*;


public class PageTools extends CustomLogger {

    /**
     * Повертає назву попереднього методу як текст.
     * @return назва попереднього методу у вигляді тексту
     */
    private static String getPreviousMethodNameAsText() {
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        String replacedName = methodName.replaceAll(String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " ");
        return replacedName.substring(0, 1).toUpperCase() + replacedName.substring(1).toLowerCase();

    }
    /**
     * Повертає локатор `By` з врахуванням аргументів.
     * @param by локатор елемента
     * @param args аргументи для формування локатора
     * @return `By` локатор з врахуванням аргументів
     */
    public By byLocator(By by, Object... args) {
        return LocatorParser.parseLocator(by, args);
    }

    protected SelenideElement shouldBe(Condition condition, By by, Object... args) {
        return $(byLocator(by, args)).shouldBe(condition);
    }
    /**
     * Перевіряє, чи відповідає елемент заданій умові і клікає на нього.
     * @param by локатор елемента
     * @param args аргументи для формування локатора
     */
    protected void click(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " 'element -> " + byLocator(by, args));
        shouldBe(clickableCondition, by, args).click();
    }
    /**
     * Вводить текст у вказаний елемент.
     * @param text текст для введення
     * @param by локатор елемента
     * @param args аргументи для формування локатора
     */
    protected void type(String text, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " 'element -> " + byLocator(by, args));
        shouldBe(Condition.visible, by, args).clear();
        shouldBe(inputCondition, by, args).append(text);
    }
    /**
     * Перевіряє наявність елемента на сторінці.
     * @param by локатор елемента
     * @param args аргументи для формування локатора
     * @return `true`, якщо елемент існує, в іншому випадку - `false`
     */
    protected boolean isElementExists(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " 'element exists -> " + byLocator(by, args));
        return $(byLocator(by, args)).is(Condition.visible);
    }
    /**
     * Повертає текст елемента.
     * @param by локатор елемента
     * @param args аргументи для формування локатора
     * @return текст елемента
     */
    protected String getElementText(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " 'element text -> " + byLocator(by, args));
        return shouldBe(Condition.visible, by, args).text();
    }
    /**
     * Повертає текст усіх елементів колекції.
     * @param by локатор колекції елементів
     * @param args аргументи для формування локатора
     * @return список текстів елементів колекції
     */
    protected List<String> getElementsText(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " 'elements collection texts -> " + byLocator(by, args));
        return $$(byLocator(by, args)).texts();
    }

    protected ElementsCollection getElements(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " 'elements collection  -> " + byLocator(by, args));
        return $$(byLocator(by, args));
    }
}