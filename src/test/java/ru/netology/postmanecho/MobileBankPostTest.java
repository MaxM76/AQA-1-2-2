package ru.netology.postmanecho;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MobileBankPostTest {
    @Test
    void shouldPostData() {
        JSONObject requestParams = new JSONObject()
                .put("id", "007")
                .put("name", "Vasya")
                .put("number", "332223332")
                .put("balance", "100500")
                .put("currency", "RUB")
        ;

        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body(requestParams.toString()) // отправляемые данные (заголовки и query можно выставлять аналогично)

// Выполняемые действия
        .when()
                .post("/post")
// Проверки
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", equalTo("007"))
                .body("data.name", equalTo("Vasily"))
                .body("data.number", equalTo("332223332"))
                .body("data.balance", equalTo("100500"))
                .body("data.currency", equalTo("RUB"))
        ;
    }
}
