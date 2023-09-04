import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class CreateCourierTest {

    private String incorrectJsonDataForCreatingCourier;

    public CreateCourierTest(String incorrectJsonDataForCreatingCourier) {
        this.incorrectJsonDataForCreatingCourier = incorrectJsonDataForCreatingCourier;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"{\"login\": \"mafioso\", \"firstName\": \"jiorno\"}"},
                {"{\"password\": \"1234\", \"firstName\": \"jiorno\"}"}
        };
    }

    @Before
    public void setBaseURL() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
    }

    public Response getResponseByPost(String json, String url) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(json)
                .when()
                .post(url);
    }

    @Test
    @DisplayName("check creating courier with valid test data")
    @Description("Basic test for /api/v1/courier, positive")
    public void createCourierReturnStatus201() {
        String json = "{\"login\": \"crusader" + (int) (Math.random() * 99996) + "\", \"password\": \"1234\", \"firstName\": \"jotaro\"}";
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(json)
                .when()
                .post("/api/v1/courier");
        response.then().assertThat().body("ok", equalTo(true))
                .and()
                .statusCode(201);
    }

    @Test
    @DisplayName("check creating courier without required parameters")
    @Description("Test for /api/v1/courier, negative")
    public void creatingCourierWithIncorrectDataReturn400() {
        Response response = getResponseByPost(incorrectJsonDataForCreatingCourier, "/api/v1/courier");
        response.then().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and()
                .statusCode(400);
    }

    @Test
    @DisplayName("check creating one courier twice")
    @Description("Test for /api/v1/courier, negative")
    public void createCourierWithDuplicatedLogin() {
        String json1 = "{\"login\": \"serterser\", \"password\": \"1234\", \"firstName\": \"josuke\"}";
        Response response1 = getResponseByPost(json1, "/api/v1/courier");
        String json2 = "{\"login\": \"serterser\", \"password\": \"12345\", \"firstName\": \"josuke_higashikata\"}";
        Response response2 = getResponseByPost(json2, "/api/v1/courier");
        response2.then().assertThat().statusCode(409);
    }
}
