package api.tests;

import api.enums.EndPoint;
import api.model.CreateUserDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApiCreateUserTest extends ApiBase {
    static CreateUserDto createUserDto;
    Response response;

    @Test(testName = "0.1.1 API: successful user creation")
    public void createUserApiTest() {
        createUserDto = new CreateUserDto();
        createUserDto.setFull_name("John3 Richardson");
        createUserDto.setEmail("johnr3@gmail.com");
        createUserDto.setPassword("12345678");
        createUserDto.setGenerate_magic_link(false);

//TODO        bag-report: ID: [0.1.1.1] - erroneous success status when creating a user in API (200 - 201)
//        response = doPostRequest(EndPoint.CREATE_USER, 200, createUserDto);
        response = doPostRequest(EndPoint.CREATE_USER, 201, createUserDto);

//        LocalDateTime currentTime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String formattedCurrentTime = currentTime.format(formatter);

        Assert.assertEquals(response.jsonPath().getString("full_name"), createUserDto.getFull_name());
        Assert.assertEquals(response.jsonPath().getString("email"), createUserDto.getEmail());
//        Assert.assertEquals(response.jsonPath().getString("created"), formattedCurrentTime);
//        Assert.assertEquals(response.jsonPath().getString("updated"), formattedCurrentTime);
    }
}
