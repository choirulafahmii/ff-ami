package api.tests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.Request;

public class BaseTest {
    protected static RequestSpecification request;

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://dummyapi.io/data/v1"; //BASE URL API
        request = RestAssured.given()
                .header("app-id", "63a804408eb0cb069b57e43a") // API Key dari Postman
                .contentType("application/json");
    }
}
