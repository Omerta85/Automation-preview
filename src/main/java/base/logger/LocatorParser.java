package base.logger;

import org.openqa.selenium.By;

public class LocatorParser {

    /**
     * Парсить локатор із врахуванням аргументів та повертає об'єкт типу By.
     * @param by локатор
     * @param args аргументи для формування локатора
     * @return об'єкт типу By
     */
    public static By parseLocator(By by, Object... args) {
        String locatorFormat = locatorPattern(by.toString(), args);
        String locatorTypeName = getLocatorTypeName(by);
        switch (locatorTypeName) {
            case "ByCssSelector":
                return By.cssSelector(locatorFormat);
            case "ById":
                return By.id(locatorFormat);
            case "ByName":
                return By.name(locatorFormat);
            case "ByClassName":
                return By.className(locatorFormat);
            case "ByTagName":
                return By.tagName(locatorFormat);
            default:
                return By.xpath(locatorFormat);
        }
    }

    /**
     * Формує паттерн локатора.
     * @param str рядок з локатором
     * @param args аргументи для формування локатора
     * @return паттерн локатора
     */
    private static String locatorPattern(String str, Object... args) {
        return String.format(str.replaceAll("By\\.[^:]*:", "").trim(), args);
    }
    /**
     * Повертає ім'я типу локатора.
     * @param by локатор
     * @return ім'я типу локатора
     */
    private static String getLocatorTypeName(By by) {
        return by.getClass().getSimpleName();
    }
}