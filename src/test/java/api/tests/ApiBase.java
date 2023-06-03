package api.tests;

import api.enums.EndPoint;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBase {
    final String SOFTR_API_KEY = "khIbAyJIU5CIuh1oDuBRx1s49";
    final String BASE_URL = "https://studio-api.softr.io";
    final String SOFTR_DOMAIN = "jere237.softr.app";
    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .addHeader("Softr-Api-Key", SOFTR_API_KEY)
            .addHeader("Softr-Domain", SOFTR_DOMAIN)
            .build();

    public Response doPostRequest(EndPoint endPoint, int statusCode, Object body) {
        Response response = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .post(endPoint.getValue())
                .then()
                .log().all()
                .extract().response();
        response.then().assertThat().statusCode(statusCode);
        return response;
    }
}
