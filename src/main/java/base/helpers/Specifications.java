package base.helpers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    //Цей метод створює і повертає специфікацію запиту. Він приймає URL в якості параметру, встановлює базовий URI та вказує, що дані передаються у форматі JSON
    public static RequestSpecification requestSpecification(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    //Цей метод створює і повертає специфікацію відповіді. Він приймає очікуваний код статусу в якості параметру.
    public static ResponseSpecification responseSpecification(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }

    //Цей метод встановлює глобальні специфікації для RestAssured. Він приймає специфікацію запиту та специфікацію відповіді та встановлює їх для RestAssured.requestSpecification та RestAssured.responseSpecification відповідно.
    public static void getSpecification(RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }
}
