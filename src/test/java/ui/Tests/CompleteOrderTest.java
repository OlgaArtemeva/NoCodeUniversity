package ui.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.Pages.FooterMenu;
import ui.Pages.HeaderMenu;
import ui.Pages.HomePage;


public class CompleteOrderTest extends TestBase {


    @Test(testName = "1.2.1 Authorization with teacher role", groups = {"signInTeacher"})
    public void signIn() {

        new HeaderMenu()
                .checkHeaderMenuTeacherRole();
        new HomePage()
                .checkHomePageTeacherRole();
        new FooterMenu()
                .checkFooterMenu();
    }

    @Test(testName = "1.4.6 Change the password in the user profile with the student role", groups = {"signInStudent"})
    public void changePasswordStudent() {

        new HeaderMenu()
                .clickMyProfile()
                .changePassword("123456", "654321");
        new HeaderMenu()
                .clickSignOut()
                .setLogin("annab@example.com")
                .setPassword("654321")
                .login();
        new HeaderMenu()
                .clickMyProfile()
                .changePassword("654321", "123456");
        new HeaderMenu()
                .clickSignOut();
    }
}