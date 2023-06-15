package api.tests;

import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;

public class ApiCreateUserTest extends ApiBase {

    @Issue("0.1.1 API: successful user creation")
    @Test(testName = "0.1.1 API: successful user creation")
    public void successfulCreateUserApiTest() {
        createUserApi();
//TODO        bag-report: ID: [0.1.1.1] - erroneous success status when creating a user in API (200 - 201)
        assertEquals(response.getStatusCode(), 200);
//        assertEquals(response.getStatusCode(), 201);
//        String formattedCurrentTime = currentTime.format(formatter);
        assertEquals(response.jsonPath().getString("full_name"), createUserDto.getFull_name());
        assertEquals(response.jsonPath().getString("email"), createUserDto.getEmail());
//        Assert.assertEquals(response.jsonPath().getString("created"), formattedCurrentTime);
//        Assert.assertEquals(response.jsonPath().getString("updated"), formattedCurrentTime);

        deleteUserApi();
    }
}
