package api.lesson9;

import base.pojos.createUser.CreateUserRequest;
import base.pojos.createUser.CreateUserResponse;
import base.pojos.getPets.Pet;
import base.pojos.getUser.GetUserData;
import base.pojos.updateUser.UpdateUserResponse;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static base.helpers.Specifications.*;

public class PojoTest {

    public static final String BASE_URL = "https://reqres.in/";

    //@Test
    public void getUsers(){
        // Встановлює специфікації для запиту та відповіді
        getSpecification(requestSpecification(BASE_URL), responseSpecification(200));

        // Отримує список користувачів
        List<GetUserData> usersList = given()
                .when()
                .get( "api/users?page=2")
                .then()
                .extract().body().jsonPath().getList("data", GetUserData.class);

        // Перевірка, що список користувачів не є порожнім
        Assert.assertNotNull(usersList);

        // Перевірка властивостей кожного користувача в списку
        for (int i = 0; i < usersList.size(); i++) {
            Assert.assertTrue(usersList.get(i).getEmail().contains("@reqres.in"));
            Assert.assertTrue(usersList.get(i).getAvatar().contains(usersList.get(i).getId().toString()));
        }
    }

    //@Test
    public void createUserTest(){
        // Встановлює специфікації для запиту та відповіді
        getSpecification(requestSpecification(BASE_URL), responseSpecification(201));

        // Створює об'єкт запиту для створення користувача
        CreateUserRequest request = new CreateUserRequest();
        request.setName("morpheus");
        request.setJob("leader");

        // Виконує запит на створення користувача та отримує відповідь
        CreateUserResponse createUserResponse = given()
                .body(request)
                .when()
                .post("api/users")
                .then()
                .log().body().extract().as(CreateUserResponse.class);

        // Перевіряє, що отримана відповідь не є порожньою
        Assert.assertNotNull(createUserResponse);

        // Перевіряє відповідність переданих даних та отриманих від сервера
        Assert.assertEquals(request.getName(), createUserResponse.getName());
        Assert.assertEquals(request.getJob(), createUserResponse.getJob());

        // Виводить інформацію про створеного користувача
        System.out.println(createUserResponse);
    }

    //@Test
    public void updateUserTest(){
        // Встановлює специфікації для запиту та відповіді
        getSpecification(requestSpecification(BASE_URL), responseSpecification(200));

        // Створює об'єкт запиту для оновлення користувача
        CreateUserRequest requestUpdate = new CreateUserRequest("morpheus","zion resident");

        // Виконує запит на оновлення користувача та отримує відповідь
        UpdateUserResponse updateUserResponse = given()
                .body(requestUpdate)
                .when()
                .put("api/users/2")
                .then()
                .extract().as(UpdateUserResponse.class);

        // Перевіряє відповідність переданих даних та отриманих від сервера
        Assert.assertEquals(requestUpdate.getName(), updateUserResponse.getName());
        Assert.assertEquals(requestUpdate.getJob(), updateUserResponse.getJob());

        // Виводить інформацію про час оновлення користувача
        System.out.println(updateUserResponse.getUpdatedAt());
    }

    @Test
    public void getPetTest(){
        // Встановлює специфікації для запиту та відповіді
        getSpecification(requestSpecification(BASE_URL), responseSpecification(200));

        // Виконує запит на отримання інформації про тварин та отримує відповідь
        Pet[] petResponse = given()
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
                .then()
                .extract().as(Pet[].class);

        // Перетворює масив у список для зручності перевірки
        List<Pet> list = Arrays.asList(petResponse);

        // Перевіряє статус кожної тварини в списку
        for (Pet pet :list) {
            Assert.assertEquals(pet.getStatus(), "available");
        }
    }
}
