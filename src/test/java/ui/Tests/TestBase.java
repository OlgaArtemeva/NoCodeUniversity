package ui.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.Pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    private static final String url = "https://jere237.softr.app/";
    private static final String teacherEmail = "roxanne@example.com";
    //    private static final String studentEmail = "malik@example.com";
    private static final String studentEmail = "annab@example.com";
    private static final String password = "123456";

    @BeforeMethod
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//        отключаем параметр PageSource (не сохраняем)
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().savePageSource(false));
        ChromeOptions chromeOptions = new ChromeOptions();
//        можно открывать любые ссылки - *, для безопасности м. прописать конкретный сайт
        chromeOptions.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        open(url);
//        Configuration.holdBrowserOpen = true;
    }

    @BeforeMethod(onlyForGroups = {"signInTeacher"})
    public HomePage signInTeacher() {
        new HomePage().signIn(teacherEmail, password);
        return new HomePage();
    }

    @BeforeMethod(onlyForGroups = {"signInStudent"})
    public HomePage signInStudent() {
        new HomePage().signIn(studentEmail, password);
        return new HomePage();
    }
}
