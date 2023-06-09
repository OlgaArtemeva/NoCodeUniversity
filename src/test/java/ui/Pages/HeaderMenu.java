package ui.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderMenu {
    private static final SelenideElement noCodeUniversityLink = $x("//a[@class='navbar-brand']");
    private static final SelenideElement aboutUsLink = $x("//span[normalize-space()='About Us']");
    private static final SelenideElement coursesLink = $x("//span[normalize-space()='Courses']");
    private static final SelenideElement coursesSelectMenu = $x("//*[@data-testid='ExpandMoreIcon']");
    private static final SelenideElement professors = $x("//span[normalize-space()='Professors']");
    private static final SelenideElement HeaderMenuSignInButton = $x("//span[.='Sign in']");
    private static final SelenideElement HeaderMenuSignUpButton = $x("//span[.='Sign up']");
    private static final SelenideElement studentDirectory = $x("//span[normalize-space()='Student Directory']");
    private static final SelenideElement addCourse = $x("//span[.='Add course']");
    private static final SelenideElement avatar = $x("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17qbyv7']");
    private static final SelenideElement myProfile = $x("//span[.='My Profile']");
    private static final SelenideElement signOut = $x("//span[.='Sign Out']");

    @Step("Checking the Header menu for NoRole")
    public void checkHeaderMenuNoRole() {
        noCodeUniversityLink.shouldBe(Condition.visible);
        aboutUsLink.shouldBe(Condition.visible);
        coursesLink.shouldBe(Condition.visible);
        professors.shouldBe(Condition.visible);
        HeaderMenuSignInButton.shouldBe(Condition.visible);
        HeaderMenuSignUpButton.shouldBe(Condition.visible);
//        контрпроверка
//        studentDirectory.shouldBe(Condition.visible);
    }

    @Step("Checking the Header menu for TeacherRole")
    public void checkHeaderMenuTeacherRole() {
        noCodeUniversityLink.shouldBe(Condition.visible);
        aboutUsLink.shouldBe(Condition.visible);
        coursesLink.shouldBe(Condition.visible);
        coursesSelectMenu.shouldBe(Condition.visible);
        professors.shouldBe(Condition.visible);
        studentDirectory.shouldBe(Condition.visible);
        addCourse.shouldBe(Condition.visible);
        avatar.shouldBe(Condition.visible);
    }

    @Step("Click Student Directory")
    public StudentDirectoryPage clickStudentDirectory() {
        studentDirectory.shouldBe(Condition.visible).click();
        return new StudentDirectoryPage();
    }

    @Step("Click MyProfile")
    public ProfilePage clickMyProfile() {
        avatar.shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        myProfile.shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        return new ProfilePage();
    }

    @Step("Click SignOut")
    public SignInPage clickSignOut() {
        avatar.shouldBe(Condition.visible).click();
        signOut.shouldBe(Condition.visible).click();
        return new SignInPage();
    }
}
