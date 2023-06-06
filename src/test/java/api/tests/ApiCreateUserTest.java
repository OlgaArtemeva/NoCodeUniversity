package api.tests;

import api.enums.EndPoint;
import api.model.CreateUserDto;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;

public class ApiCreateUserTest extends ApiBase {
    static CreateUserDto createUserDto;
    Response response;

    @Issue("0.1.1 API: successful user creation")
    @Test(testName = "0.1.1 API: successful user creation")
    public void createUserApiTest() {
        createUserDto = new CreateUserDto();
        createUserDto.setFull_name("John3 Richardson");
        createUserDto.setEmail("johnr3@gmail.com");
        createUserDto.setPassword("12345678");
        createUserDto.setGenerate_magic_link(false);

        response = doPostRequest(EndPoint.CREATE_USER, createUserDto);
//TODO        bag-report: ID: [0.1.1.1] - erroneous success status when creating a user in API (200 - 201)
//        assertEquals(200, response.getStatusCode());

        assertEquals(201, response.getStatusCode());
//        LocalDateTime currentTime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String formattedCurrentTime = currentTime.format(formatter);

        assertEquals(response.jsonPath().getString("full_name"), createUserDto.getFull_name());
        assertEquals(response.jsonPath().getString("email"), createUserDto.getEmail());
//        Assert.assertEquals(response.jsonPath().getString("created"), formattedCurrentTime);
//        Assert.assertEquals(response.jsonPath().getString("updated"), formattedCurrentTime);
    }
}
