package ui.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private static final SelenideElement welcome = $x("//h1[contains(text(), 'Welcome to')]");
    private static final SelenideElement teacherText = $x("//p[contains(text(), 'As a teacher')]");
    private static final SelenideElement classImg = $x("//img[@alt='Image alt']");
    private static final SelenideElement HomePageSignUpButton = $x("//a[contains(text(), 'Sign up')]");
    private static final SelenideElement HomePageSignInButton = $x("//a[contains(text(), 'Sign in')]");
    private static final SelenideElement buttonViewCourses = $x("//a[contains(text(), 'View Courses')]");
    private static final SelenideElement buttonStudentDirectory = $x("//a[contains(text(), 'Student Directory')]");

@Step("Регистрируемся с TeacherRole")
public SignInPage clickSignIn(){
    HomePageSignInButton.shouldBe(Condition.visible).click();
    return new SignInPage();
}
    @Step("Проверяем NoRole")
    public void checkHomePageNoRole(){
        welcome.shouldBe(Condition.visible);
        teacherText.shouldBe(Condition.visible);
        classImg.shouldBe(Condition.visible);
        HomePageSignUpButton.shouldBe(Condition.visible);
        HomePageSignInButton.shouldBe(Condition.visible);
    }

    @Step("Проверяем TeacherRole")
    public void checkHomePageTeacherRole(){
        welcome.shouldBe(Condition.visible);
        teacherText.shouldBe(Condition.visible);
        classImg.shouldBe(Condition.visible);
        buttonViewCourses.shouldBe(Condition.visible);
        buttonStudentDirectory.shouldBe(Condition.visible);
    }
}
