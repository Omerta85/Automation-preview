package base.pages;

import java.util.Objects;

// Клас, який представляє товар
public class Item {
    private String name; // Назва товару
    private String description; // Опис товару
    private String price; // Ціна товару

    // Конструктор за замовчуванням
    public Item(){
    }

    // Метод для встановлення назви товару
    public void setName(String name) {
        this.name = name;
    }

    // Метод для встановлення опису товару
    public void setDescription(String description) {
        this.description = description;
    }

    // Метод для встановлення ціни товару
    public void setPrice(String price) {
        this.price = price;
    }

    // Перевизначений метод для порівняння об'єктів класу Item
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(description, item.description) && Objects.equals(price, item.price);
    }

    // Перевизначений метод для обчислення хеш-коду об'єкту
    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }

    // Перевизначений метод для представлення об'єкту у вигляді рядка
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
