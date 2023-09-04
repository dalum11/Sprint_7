import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.Matchers.*;
import java.util.List;

import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class GetOrderTest {

    private String firstName;
    private String lastName;
    private String address;
    private int metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private List<Color> color;

    private String track;

    public GetOrderTest(String firstName, String lastName, String address, int metroStation, String phone, int rentTime, String deliveryDate, String comment, List<Color> color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    @Before
    public void setBaseURL() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
    }


    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Jozeph", "Jostar", "Address rec.123", 5, "+79217689120", 1, "2023-07-01", "SHIIIIZAAAAA!",
                        List.of(new Color("GREY"))},
                {"Jozeph", "Jostar", "Address rec.123", 5, "+79217689120", 1, "2023-07-01", "SHIIIIZAAAAA!",
                        List.of(new Color("GREY"), new Color("BLACK"))},
                {"Jozeph", "Jostar", "Address rec.123", 5, "+79217689120", 1, "2023-07-01", "SHIIIIZAAAAA!",
                        List.of("")},
                {"Jozeph", "Jostar", "Address rec.123", 5, "+79217689120", 1, "2023-07-01", "SHIIIIZAAAAA!",
                        List.of("", "")},
        };
    }

    public Response getResponseByPost(OrderData json, String url) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(json)
                .when()
                .post(url);
    }

    @Test
    public void getOrderWithCorrectDataReturn200() {
        OrderData orderDataForTest = new OrderData(firstName, lastName, address,
                metroStation, phone, rentTime, deliveryDate,
                comment, color);
        Response response = getResponseByPost(orderDataForTest, "/api/v1/orders");
        String[] trackArray = response.getBody().asString().split(":");
        track = trackArray[1].replace("}", "").trim();
        response.then().body("track", notNullValue());
    }

    @After
    public void deleteTestData() {
        String json = "{\"track\": " + track + "}";
        given()
                .header("Content-type", "application/json")
                .and()
                .body(json)
                .when()
                .put("/api/v1/orders/cancel");

    }
}
