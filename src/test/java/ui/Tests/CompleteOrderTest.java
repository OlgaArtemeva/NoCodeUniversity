package ui.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.Pages.FooterMenu;
import ui.Pages.HeaderMenu;
import ui.Pages.HomePage;

public class CompleteOrderTest extends TestBase{


    @Test(testName = "1.2.1 Authorization with teacher role", groups = {"signInTeacher"})
    public void signIn() {

        new HeaderMenu()
                .checkHeaderMenuTeacherRole();
        new HomePage()
                .checkHomePageTeacherRole();
        new FooterMenu()
                .checkFooterMenu();
    }
}
