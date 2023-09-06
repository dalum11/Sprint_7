import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OrderApi {

    private String path;

    public OrderApi(String path){
        this.path = path;
    }

    public Response getResponseByPost(OrderData order) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(order)
                .when()
                .post(path);
    }
}
