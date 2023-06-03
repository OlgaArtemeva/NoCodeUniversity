package ui.Tests;

import api.tests.ApiCreateUserTest;
import org.testng.annotations.Test;
import ui.Pages.HeaderMenu;

//        bag-report: ID: [0.1.1.1] - erroneous success status when creating a user in API (200 - 201)
public class UiCheckingUserAfterAPICreation  extends TestBase{
    @Test(testName = "ID: 0.1.5 UI checking user creation after API user creation")
    public void checkingApiUi() throws InterruptedException {
        new ApiCreateUserTest().createUserApiTest();
        signInStudent();
        new HeaderMenu()
                .clickStudentDirectory()
                .insertFullNameInSearchField("John3 Richardson")
                .selectUserInList("johnr3@gmail.com");
    }
}
