package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class UpdateUserTest extends BaseTest {

    @Test
    public void updateUser (){
        String userId = "67da684b34b1cbbc0ca55fe1"; // Ganti dengan ID user yang valid

        //Set Base URI secara explicit agar import RestAssured digunakan
        RestAssured.baseURI = "https://dummyapi.io/data/v1";

        //Membuat JSON Payload untuk update user
        JSONObject updateData = new JSONObject();
        updateData.put("firstName", "sasha");
        updateData.put("lastName", "looking");

        //kirim request PUT untuk memperbarui user
        Response response = (Response) given()
                .header("app-id", "63a804408eb0cb069b57e43a") // Tambahkan app-id untuk autentikasi
                .contentType("application/json")
                .body(updateData.toString())
                .when()
                .put("/user/" + userId)
                .then()
                .statusCode(200)
                .body("firstName", equalTo("sasha"))
                .body("lastName", equalTo("looking"))

                .extract().response();

        System.out.println("user updated Response: " + response.prettyPrint());


    }
}
