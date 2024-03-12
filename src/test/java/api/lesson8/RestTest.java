package api.lesson8;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {

    // Базовий URL для API-запитів
    public static final String BASE_URL = "https://reqres.in/";

    // Об'єкт JSON для зберігання даних запиту
    public JSONObject request = new JSONObject();

    // Метод для тестування HTTP GET запиту
    //@Test
    public void getTest() {
        // Виконання GET запиту за вказаним URL
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        // Виведення відповіді у вигляді рядка
        System.out.println(response.asString());

        // Виведення коду статусу відповіді
        System.out.println(response.statusCode());

        // Перевірка на співпадіння отриманого коду статусу з очікуваним (200)
        Assert.assertEquals(response.statusCode(), 200);

        // Використання RestAssured для перевірки відповіді з використанням Hamcrest
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200).log().body()
                .body("data.id[1]", equalTo(8));

        // Отримання відповіді з використанням RestAssured та використання JSONPath для отримання конкретних даних
        Response response1 = given()
                .accept(ContentType.JSON)
                .get(BASE_URL + "api/users?page=2")
                .then()
                .statusCode(200)
                .extract().response();

        // Перевірка конкретних даних у відповіді
        Assert.assertEquals(response1.jsonPath().getString("data.first_name[0]"), "Michael");
    }

    // Метод для тестування HTTP POST запиту
    //@Test
    public void postTest() {
        // Додавання даних до об'єкта JSON для використання в POST запиті
        request.put("name", "Marian");
        request.put("job", "aqa");

        // Виконання POST запиту з об'єктом JSON у тілі запиту
        given()
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post(BASE_URL + "api/users")
                .then()
                .statusCode(201).log().body();
    }

    // Метод для тестування HTTP PUT запиту
    //@Test
    public void putTest() {
        // Додавання даних до об'єкта JSON для використання в PUT запиті
        request.put("name", "Marian");
        request.put("job", "aqa");

        // Виконання PUT запиту з об'єктом JSON у тілі запиту
        given()
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put(BASE_URL + "api/users/2")
                .then()
                .statusCode(200).log().body();
    }

    // Метод для тестування HTTP DELETE запиту
    @Test
    public void deleteTest(){
        // Виконання DELETE запиту для видалення ресурсу
        given().
                delete(BASE_URL + "api/users/2")
                .then()
                .statusCode(204).log().all();
    }
}
