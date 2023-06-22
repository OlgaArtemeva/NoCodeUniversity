package ui.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class SignInPage {
    private static final SelenideElement inputEmail = $x("//input[@placeholder='Email']");
    private static final SelenideElement inputPassword = $x("//input[@placeholder='Password']");
    private static final SelenideElement signInPageSignInButton = $x("//div[contains(@class, 'text-center ')]/a[@href='javascript:void(0);']");
    private static final SelenideElement forgotPasswordLink = $x("//a[.='         Forgot password        ']");
    private static final SelenideElement signInPageSignUnButton = $x("//div[contains(@class, 'text-center ')]/a[@href='/sign-up']");

    @Step("Insert Email: '{email}'")
    public SignInPage setLogin(String email) {
        inputEmail.shouldBe(Condition.visible).setValue(email);
        return this;
    }

    @Step("Insert password: '{password}'")
    public SignInPage setPassword(String password) {
        inputPassword.shouldBe(Condition.visible).setValue(password);
        return this;
    }

    @Step("Click the button 'Sign In'")
    public HomePage login() {
        signInPageSignInButton.shouldBe(Condition.visible).click();
        signInPageSignInButton.shouldBe(Condition.hidden, Duration.ofSeconds(20));
        return new HomePage();
    }
}
