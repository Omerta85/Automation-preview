package base.helpers;

import com.codeborne.selenide.*;

// Клас, який містить умови для перевірки елементів на веб-сторінці
public class Conditions {
    // Умова для перевірки поля вводу: має бути порожнім і видимим
    public static Condition inputCondition = Condition.and("повинно бути порожнім і видимим", Condition.empty, Condition.visible);

    // Умова для перевірки можливості клікнути: повинно бути видимим і активним
    public static Condition clickableCondition = Condition.and("повинно бути клікабельним", Condition.visible, Condition.enabled);

    // Умова для перевірки розміру колекції: повинен бути розмір 6
    public static CollectionCondition collectionSizeCondition = CollectionCondition.size(6);
}
