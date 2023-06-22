package ui.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CourseDetailsPage {
    private static final SelenideElement inputDocumentName = $x("//div[@field='Document Name']");
    private static final SelenideElement uploadDocument = $x("//span[normalize-space()='Drag files here to upload or']");

    public CourseDetailsPage setDocumentName(String document) {
        inputDocumentName.shouldBe(Condition.visible).setValue(document);
        return this;
    }
}
