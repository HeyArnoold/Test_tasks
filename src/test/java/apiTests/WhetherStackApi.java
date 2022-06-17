package apiTests;

import apiTests.pojos.LocationPojo;
import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static apiTests.servise.ServicesObj.*;
import static apiTests.testData.TestData.expectedResultInCity;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;


class WhetherStackApi {

    @DisplayName("Запрашиваем текущую погоду по четырем городам и сравниваем поле location с ожидаемыми данными")
    @Description("Сравниваем объект полученный с Json'a с ожидаемыми тестовыми данными в виде объекта")
    @Test
    void getResponsesAndCheck() {
        Assertions.assertThat(getLocation("London")).usingRecursiveComparison()
                .isEqualTo(expectedResultInCity("London"));

        Assertions.assertThat(getLocation("New York")).usingRecursiveComparison()
                .isEqualTo(expectedResultInCity("New York"));

        Assertions.assertThat(getLocation("Shanghai")).usingRecursiveComparison()
                .isEqualTo(expectedResultInCity("Shanghai"));

        Assertions.assertThat(getLocation("Singapur")).usingRecursiveComparison()
                .isEqualTo(expectedResultInCity("Singapur"));
    }

    @DisplayName("Получаем 4 варианта ошибок из списка API Errors и проверяем тип ошибки в ответе")
    @Test
    void getAPIErrorResponse() {
        String missingKey = given()
                .spec(REQ_SPEC_WITHOUT_KEY)
                .when().get()
                .then().log().all()
                .extract().jsonPath().getString("error.type");

        String invalidKey = given()
                .spec(REQ_SPEC_INVALID_KEY)
                .when().get()
                .then().log().all()
                .extract().jsonPath().getString("error.type");

        String missingQuery = given()
                .spec(REQ_SPEC)
                .queryParam("query")
                .when().get()
                .then().log().all()
                .extract().jsonPath().getString("error.type");

        String requestFailed = given()
                .spec(REQ_SPEC)
                .queryParam("query", "    ")
                .when().get()
                .then().log().all()
                .extract().jsonPath().getString("error.type");

        Assertions.assertThat(missingKey).isEqualTo("missing_access_key");
        Assertions.assertThat(invalidKey).isEqualTo("invalid_access_key");
        Assertions.assertThat(missingQuery).isEqualTo("missing_query");
        Assertions.assertThat(requestFailed).isEqualTo("request_failed");
    }
}
