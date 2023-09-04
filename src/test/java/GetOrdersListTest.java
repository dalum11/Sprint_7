import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;


public class GetOrdersListTest {

    @Before
    public void setBaseURL() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
    }

    @Test
    @DisplayName("Get orders list")
    @Description("Basic test for getting list of orders")
    public void getOrdersListReturnList() {
        String json = given()
                .accept(ContentType.JSON)
                .contentType("application/json")
                .get("/api/v1/orders")
                .body().asString();
        Gson gson = new Gson();
        OrdersList ordersList = gson.fromJson(json, OrdersList.class);
        Assert.assertTrue(ordersList.orders().size() >= 1);

    }
}
