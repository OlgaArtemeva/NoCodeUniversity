package ui.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderMenu {
    private static final SelenideElement noCodeUniversityLink = $x("//a[@class='navbar-brand']");
    private static final SelenideElement aboutUsLink = $x("//span[normalize-space()='About Us']");
    private static final SelenideElement coursesLink = $x("//span[normalize-space()='Courses']");
//    private static final SelenideElement coursesSelectMenu = $x("//*[@data-testid='ExpandLessIcon']");
    private static final SelenideElement coursesSelectMenu = $x("//*[@data-testid='ExpandMoreIcon']");
    private static final SelenideElement professors = $x("//span[normalize-space()='Professors']");
    private static final SelenideElement HeaderMenuSignInButton = $x("//span[normalize-space()='Professors']");
    private static final SelenideElement HeaderMenuSignUpButton = $x("//span[normalize-space()='Professors']");
    private static final SelenideElement studentDirectory = $x("//span[normalize-space()='Student Directory']");
    private static final SelenideElement addCourse = $x("//span[.='Add course']");
    private static final SelenideElement avatar = $x("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17qbyv7']");

    //    @Step - для  отчетов Allure
    @Step("Проверяем наличие всех пунктов меню для NoRole")
    public void checkHeaderMenuNoRole(){
        noCodeUniversityLink.shouldBe(Condition.visible);
        aboutUsLink.shouldBe(Condition.visible);
        coursesLink.shouldBe(Condition.visible);
        professors.shouldBe(Condition.visible);
        HeaderMenuSignInButton.shouldBe(Condition.visible);
        HeaderMenuSignUpButton.shouldBe(Condition.visible);
//        контрпроверка
//        studentDirectory.shouldBe(Condition.visible);
    }
    @Step("Проверяем наличие всех пунктов меню для TeacherRole")
    public void checkHeaderMenuTeacherRole(){
        noCodeUniversityLink.shouldBe(Condition.visible);
        aboutUsLink.shouldBe(Condition.visible);
        coursesLink.shouldBe(Condition.visible);
        coursesSelectMenu.shouldBe(Condition.visible);
        professors.shouldBe(Condition.visible);
        studentDirectory.shouldBe(Condition.visible);
        addCourse.shouldBe(Condition.visible);
        avatar.shouldBe(Condition.visible);
    }
}
