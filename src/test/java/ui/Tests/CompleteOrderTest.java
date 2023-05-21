package ui.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.Pages.HeaderMenu;
import ui.Pages.HomePage;

public class CompleteOrderTest extends TestBase{
    @BeforeMethod /* параметр */
    public HomePage signInTeacher() {
        new HomePage()
                .clickSignIn()
                .setLogin("roxanne@example.com")
                .setPassword("123456")
                .login();
        return new HomePage();
    }

    @Test(testName = "1.2.1 Авторизация с ролью преподавателя")
    public void signIn() {
        new HeaderMenu()
                .checkHeaderMenuTeacherRole();
        new HomePage()
                .checkHomePageTeacherRole();
    }
}
