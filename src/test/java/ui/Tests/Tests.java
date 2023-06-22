package ui.Tests;

import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import ui.Pages.*;

import static enums.TestData.document;
import static enums.TestData.teacher;

public class Tests extends TestBase {
    @Issue("1.2.1 Authorization with teacher role")
    @Test(testName = "1.2.1 Authorization with teacher role", groups = {"signInTeacher"})
    public void checkSignInTeacherRole() {
        new HeaderMenu()
                .checkHeaderMenuTeacherRole();
        new HomePage()
                .checkHomePageTeacherRole();
        new FooterMenu()
                .checkFooterMenu();
    }

    //    аннотация для Allure
    @Issue("1.4.6 Change the password in the user profile with the student role")
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

    @Issue("1.5.1 Upload course material")
    @Test(testName = "1.5.1 Upload course material", groups = {"signInTeacher", "deleteCourseMaterial"})

    public void uploadCourseMaterial() {
        new HeaderMenu()
                .clickCourseList()
                .setTeacherFullNameInSearch(teacher.getFullName())
                .selectCourse()
                .click();
//        sleep(2000);
        new CourseDetailsPage()
                .setDocumentName(document.getDocumentName());
//                .uploadDocument()
//                .clickUpload();
    }
}