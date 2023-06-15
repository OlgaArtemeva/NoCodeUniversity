package api.tests;

import api.enums.EndPoint;
import api.model.CreateUserDto;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class ApiBase {
    final String SOFTR_API_KEY = "khIbAyJIU5CIuh1oDuBRx1s49";
    final String BASE_URL = "https://studio-api.softr.io";
    //    Version 1.4.1
//    final String SOFTR_DOMAIN = "jere237.softr.app";
    //    Version 1.4.2
    final String SOFTR_DOMAIN = "erich416.softr.app";
    protected CreateUserDto createUserDto;
    protected Response response;
    //    переменная spec
    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .addHeader("Softr-Api-Key", SOFTR_API_KEY)
            .addHeader("Softr-Domain", SOFTR_DOMAIN)
            .build();

    public ApiBase() {
        createUserDto = CreateUserDto.builder()
                .full_name("John3 Richardson")
                .email("johnr3@gmail.com")
                .password("12345678")
                .generate_magic_link(false)
                .build();
    }

    public String accessEmail() {
        String emailValue = createUserDto.getEmail();
        return emailValue;
    }

    public String accessFullName() {
        String fullNameValue = createUserDto.getFull_name();
        return fullNameValue;
    }

//    public ApiBase() {
//        createUserDto = new CreateUserDto();
//        createUserDto.setFull_name("John3 Richardson");
//        createUserDto.setEmail("johnr3@gmail.com");
//        createUserDto.setPassword("12345678");
//        createUserDto.setGenerate_magic_link(false);
//    }

    @BeforeMethod
    public void beforeApi() {
        RestAssured.filters(new AllureRestAssured());
    }

    public Response doPostRequest(EndPoint endPoint, CreateUserDto body) {
        Response response = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .post(endPoint.getValue())
                .then()
                .log().all()
                .extract().response();
        return response;
    }

    public Response doDeleteRequest(EndPoint endPoint, String email) {
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .pathParams("email", email)
                .log().all()
                .delete(endPoint.getValue())
                .then()
                .log().all()
                .extract().response();
        return response;
    }

    @Step("createUserApi")
    public void createUserApi() {
        response = doPostRequest(EndPoint.CREATE_USER, createUserDto);
    }

    @Step("deleteUserApi")
    public void deleteUserApi() {
        response = doDeleteRequest(EndPoint.DELETE_USER, createUserDto.getEmail());
    }
}
