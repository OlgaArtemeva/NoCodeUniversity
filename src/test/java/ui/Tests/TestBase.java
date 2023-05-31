package ui.Tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import ui.Pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    private static final String url = "https://jere237.softr.app/";
    private static final String teacherFullName = "roxanne@example.com";
    private static final String password = "123456";

    @BeforeMethod
//            (onlyForGroups = {"all_tests"})
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        open(url);
    }

    @BeforeMethod(onlyForGroups = {"signInTeacher"})
    public HomePage signInTeacher() {
        new HomePage()
                .clickSignIn()
                .setLogin(teacherFullName)
                .setPassword(password)
                .login();
        return new HomePage();
    }
    @BeforeMethod(onlyForGroups = {"signInStudent"})
    public HomePage signInStudent() {
        new HomePage()
                .clickSignIn()
                .setLogin("malik@example.com")
                .setPassword("123456")
                .login();
        return new HomePage();
    }
}
