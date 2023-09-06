import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourierApi {

    private final String path;

    public CourierApi(String path) {
        this.path = path;
    }

    public Response getResponseByPost(CreateCourier testCourier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(testCourier)
                .when()
                .post(path);
    }

    public Response getResponseByPost(LoginCourier testCourier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(testCourier)
                .when()
                .post(path);
    }

    public Response getResponseByDelete(DeleteCourier testCourier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(testCourier)
                .when()
                .delete(path);
    }
}
