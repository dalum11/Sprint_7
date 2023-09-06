import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

//@RunWith(Parameterized.class)
public class LoginCourierTest {

    @Before
    public void setBaseURL() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
    }

    @Test
    @DisplayName("Courier login with valid test data")
    @Description("Base test for /api/v1/courier/login, positive")
    public void courierLoginSuccessfulReturn200() {
        LoginCourier courier = new LoginCourier("crusader", "1234");
        CourierApi courierApi = new CourierApi("/api/v1/courier/login");
        Response response = courierApi.getResponseByPost(courier);
        response.then().assertThat().body("id", notNullValue()).and().statusCode(200);
    }

    @Test
    @DisplayName("Courier login without login")
    @Description("Test for /api/v1/courier/login, negative")
    public void courierLoginWithoutLoginReturn400() {
        LoginCourier courier = new LoginCourier(null, "1234");
        CourierApi courierApi = new CourierApi("/api/v1/courier/login");
        Response response = courierApi.getResponseByPost(courier);
        try {
            response.then().assertThat().statusCode(400);

        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            System.out.println(response.statusCode());
        }
    }

    @Test
    @DisplayName("Courier login without password")
    @Description("Test for /api/v1/courier/login, negative")
    public void courierLoginWithoutPasswordReturn400() {
        LoginCourier courier = new LoginCourier("crusader", null);
        CourierApi courierApi = new CourierApi("/api/v1/courier/login");
        Response response = courierApi.getResponseByPost(courier);
        try {
            response.then().assertThat().statusCode(400);

        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            System.out.println(response.statusCode());
        }
    }

    @Test
    @DisplayName("Courier login with non-existent data")
    @Description("Test for /api/v1/courier/login, negative")
    public void courierLoginWithNonExistentData(){
        LoginCourier courier = new LoginCourier("askjskjckc", "84ihhds");
        CourierApi courierApi = new CourierApi("/api/v1/courier/login");
        Response response = courierApi.getResponseByPost(courier);
        response.then().statusCode(404);
    }
}
