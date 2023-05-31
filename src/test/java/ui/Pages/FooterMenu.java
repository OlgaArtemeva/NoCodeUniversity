package ui.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class FooterMenu {
    private static final SelenideElement rightText = $x("//small[contains(text(), 'All rights reserved')]");
    private static final SelenideElement kovalItLink = $x("//a[contains(text(), 'Koval IT.')]");
    private static final SelenideElement facebookLink = $x("//i[@class='fab fa-facebook-f']");
    private static final SelenideElement twitterLink = $x("//i[@class='fab fa-twitter']");
    private static final SelenideElement instagramLink = $x("//i[@class='fab fa-instagram']");

    @Step("Проверяем наличие всех элементов в Futter")
    public void checkFooterMenu(){
        rightText.shouldBe(Condition.visible);
        kovalItLink.shouldBe(Condition.visible);
        facebookLink.shouldBe(Condition.visible);
        twitterLink.shouldBe(Condition.visible);
        instagramLink.shouldBe(Condition.visible);
    }
}
