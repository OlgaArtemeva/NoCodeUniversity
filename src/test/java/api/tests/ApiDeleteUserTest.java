package api.tests;

import io.qameta.allure.Issue;
import org.testng.annotations.Test;

public class ApiDeleteUserTest extends ApiBase {
    @Issue("0.1.3 API: successful user deleting")
    @Test(testName = "0.1.3 API: successful user deleting")
    public void successfulDeleteUserApiTest() {
        createUserApi();
        deleteUserApi();
        response.then().assertThat().statusCode(200);
    }
}
