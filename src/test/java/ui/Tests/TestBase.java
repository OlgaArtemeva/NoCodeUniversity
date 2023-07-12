package ui.Tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.Pages.CourseDetailsPage;
import ui.Pages.HomePage;
import ui.Pages.StudentDirectoryPage;

import static com.codeborne.selenide.Selenide.open;
import static enums.TestData.document;

public class TestBase {
    //    Version 1.4.1 - https://jere237.softr.app/
//    private static final String url = "https://jere237.softr.app/";
    //    Version 1.4.2 - https://erich416.softr.app/
    private static final String url = "https://erich416.softr.app/";
    private static final String teacherEmail = "roxanne@example.com";
    private static final String studentEmail = "annab@example.com";
    private static final String password = "123456";

    @Step("setUp")
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

    @Step("signInTeacher")
    @BeforeMethod(onlyForGroups = {"signInTeacher"})
    public HomePage signInTeacher() {
        new HomePage().signIn(teacherEmail, password);
        return new HomePage();
    }

    @Step("signInStudent")
    @BeforeMethod(onlyForGroups = {"signInStudent"})
    public HomePage signInStudent() {
        new HomePage().signIn(studentEmail, password);
        return new HomePage();
    }

    @Step("deleteCourseMaterial")
    @AfterMethod(onlyForGroups = {"deleteCourseMaterial"})
    public void deleteCourseMaterial() {
        new CourseDetailsPage()
                .checkUploadCourseMaterial(document.getDocumentName())
                .deleteUploadedCourseMaterial(document.getDocumentName());
    }
}
