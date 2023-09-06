import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
public class CreateCourierTest {

    private static final String PATH = "/api/v1/courier";
    private static CreateCourier courier = new CreateCourier("crusader66", "1234", "jotaro");;

    @Before
    public void setBaseURL() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
    }

    @Test
    @DisplayName("check creating courier with valid test data")
    @Description("Basic test for /api/v1/courier, positive")
    public void createCourierReturnStatus201() {
        CourierApi courierApi = new CourierApi(PATH);
        Response response = courierApi.getResponseByPost(courier);
        response.then().assertThat().body("ok", equalTo(true))
                .and()
                .statusCode(201);
    }

    @Test
    @DisplayName("check creating courier without password")
    @Description("Test for /api/v1/courier, negative")
    public void creatingCourierWithoutPasswordReturn400() {
        CourierApi courierApi = new CourierApi(PATH);
        CreateCourier testCourier = new CreateCourier("crusader66", null, "jotaro");
        Response response = courierApi.getResponseByPost(testCourier);
        response.then().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and()
                .statusCode(400);
    }

    @Test
    @DisplayName("check creating courier without login")
    @Description("Test for /api/v1/courier, negative")
    public void creatingCourierWithoutLoginReturn400() {
        CreateCourier testCourier = new CreateCourier(null, "1234", "jotaro");
        CourierApi courierApi = new CourierApi(PATH);
        Response response = courierApi.getResponseByPost(testCourier);
        response.then().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and()
                .statusCode(400);
    }
    @Test
    @DisplayName("check creating one courier twice")
    @Description("Test for /api/v1/courier, negative")
    public void createCourierWithDuplicatedLogin() {
        CreateCourier testCourier = new CreateCourier("detective", "1234", "josuke");
        CourierApi courierApi = new CourierApi(PATH);
        courierApi.getResponseByPost(testCourier);
        Response response = courierApi.getResponseByPost(testCourier);
        response.then().assertThat().statusCode(409);
    }

    @AfterClass
    public static void deleteTestData(){
        CourierApi courierApi = new CourierApi("/api/v1/courier/login");
        Response response1 = courierApi.getResponseByPost(courier);
        String[] responseArray = response1.getBody().asString().replace("}", "")
                .split(":");
        DeleteCourier deleteCourier = new DeleteCourier(responseArray[1]);
        Response response2 = new CourierApi("/api/v1/courier/" + deleteCourier.id()).getResponseByDelete(deleteCourier);
        System.out.println(response2.statusCode());
    }
}
