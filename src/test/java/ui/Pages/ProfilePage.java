package ui.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    private static final SelenideElement inputOldPassword = $x("//input[@id='sw-form-password-input']");
    private static final SelenideElement inputNewPassword = $x("//input[@id='sw-new-password-input']");
    private static final SelenideElement changePasswordButton = $x("//a[@id='sw-change-password-btn']");
    @Step("Change password: '{newPassword)}'")
    public ProfilePage changePassword(String oldPassword, String newPassword){
        inputOldPassword.shouldBe(Condition.visible).setValue(oldPassword);
        inputNewPassword.shouldBe(Condition.visible).setValue(newPassword);
        changePasswordButton.shouldBe(Condition.visible).click();
        return this;
    }
}
