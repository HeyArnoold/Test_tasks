package apiTests.servise;

import apiTests.pojos.LocationPojo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;

import static io.restassured.RestAssured.given;

public class ServicesObj {

    private static final String BASE_URI = "http://api.weatherstack.com";
    private static final String BASE_PATH = "/current";
    public static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri(BASE_URI)
                    .setBasePath(BASE_PATH)
                    .addQueryParam("access_key", "def07a757e9c01731adefc10eeb61955")
                    .setContentType(ContentType.JSON).build();

    public static final RequestSpecification REQ_SPEC_WITHOUT_KEY =
            new RequestSpecBuilder()
                    .setBaseUri(BASE_URI)
                    .setBasePath(BASE_PATH)
                    .setContentType(ContentType.JSON).build();

    public static final RequestSpecification REQ_SPEC_INVALID_KEY =
            new RequestSpecBuilder()
                    .setBaseUri(BASE_URI)
                    .setBasePath(BASE_PATH)
                    .addQueryParam("access_key", "1234567890")
                    .setContentType(ContentType.JSON).build();

    public static LocationPojo getLocation(String city) {

        return given()
                .spec(REQ_SPEC)
                .queryParam("query", city)
                .when().get()
                .then().log().ifError()
                .extract().jsonPath().getObject("location", LocationPojo.class);
    }

    public ServicesObj compare(String city, String expectedCity) {
        Assertions.assertThat(city).isEqualTo(expectedCity);

        return this;
    }
}
