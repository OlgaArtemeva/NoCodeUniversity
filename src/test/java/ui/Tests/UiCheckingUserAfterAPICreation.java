package ui.Tests;

import api.tests.ApiBase;
import api.tests.ApiCreateUserTest;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import ui.Pages.HeaderMenu;

//        bag-report: ID: [0.1.1.1] - erroneous success status when creating a user in API (200 - 201)
public class UiCheckingUserAfterAPICreation extends TestBase {
    private ApiBase apiEmail = new ApiBase();
    private ApiBase apiFullName = new ApiBase();

    @Issue("ID: 0.1.5 UI checking user creation after API user creation")
    @Test(testName = "ID: 0.1.5 UI checking user creation after API user creation")
    public void checkingApiUi() {
        new ApiBase().createUserApi();
        signInStudent();
        new HeaderMenu()
                .clickStudentDirectory()
                .insertFullNameInSearchField(apiFullName.accessFullName())
                .selectUserInList(apiEmail.accessEmail());
        new ApiBase().deleteUserApi();
    }
}
