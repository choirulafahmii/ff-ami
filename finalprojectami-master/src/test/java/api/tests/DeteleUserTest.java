package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class DeteleUserTest {

    @Test
    public void deleteUser(){
        //ganti dengan id user yang valid dari hasil create user
        String userID = "67dbc2893c86350d7f90d9db";

        //set base URI RestAssured
        RestAssured.baseURI = "https://dummyapi.io/data/v1";

        // 🔍 **Langkah 1: Periksa apakah user masih ada sebelum menghapusnya**
        Response checkUser = given()
                .header("app-id", "63a804408eb0cb069b57e43a") //App ID valid
                .when()
                .get("/user/" +  userID)
                .then()
                .extract().response();

        System.out.println("Check User Response: " + checkUser.getBody().asPrettyString());

        //jika user tidak ditemukan (404), tidak perlu lanjut delete
        if (checkUser.statusCode() == 400) {
            System.out.println("user tidak ditemukan atau sudah dihapus sebelumnya.");
            return; // stop eksekusikarena user sudah tidak ada

        }

        // 🗑️ **Langkah 2: Kirim request DELETE jika user masih ada**
        Response deleteResponse = given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .when()
                .delete("/user/" + userID)
                .then()
                .log().all() //Log detail request & response
                .extract().response();

        // 🔍 **Langkah 3: Validasi hasil DELETE**
        System.out.println("Delete Response: " + deleteResponse.getBody().asPrettyString());

        if (deleteResponse.statusCode() == 200) {
            deleteResponse.then().body("message", containsString("success"));
        } else {
            throw new AssertionError("Unexpected response: " + deleteResponse.statusCode());
        }
    }
}
