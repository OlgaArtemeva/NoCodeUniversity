package api.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

//        final String SOFTR_API_KEY = "YGskr7MqMeRYrjQjsB8uEQ8n";
//        final String BASE_URI = "'https://studio-api.softr.io/v1/api/users";

//        RequestSpecification spec =  new RequestSpecBuilder()
//                .setBaseUri(BASE_URI)
//                .setContentType(ContentType.JSON)
//                .addHeader("Access-Token", SOFTR_API_KEY)
//                .build();
//
//        public Response doPostRequest(EndPoint endPoint, int statusCode, Object body) {
//            Response response = RestAssured.given()
//                    .spec(spec)
//                    .body(body)
//                    .when()
//                    .log().all()
//                    .post(endPoint.getValue())
//                    .then()
//                    .log().all()
//                    .extract().response();
//            response.then().assertThat().statusCode(statusCode);
//            return response;
//        }

}
