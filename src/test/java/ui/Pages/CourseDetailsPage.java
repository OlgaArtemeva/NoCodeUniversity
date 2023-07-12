package ui.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static enums.TestData.document;

public class CourseDetailsPage {
    private static final SelenideElement inputDocumentName = $x("//input[@class='MuiInputBase-input MuiOutlinedInput-input css-q1sikp']");
    private static final SelenideElement uploadDocument = $x("//input[@id='upload-course-material-form-Document-1880928548']");
    private static final SelenideElement uploadButton = $x("//button[@label='Upload']");
    private SelenideElement CourseMaterialName;
    private static final SelenideElement CourseMaterialNameField = $x("//h3[contains(@class,'sw-font-size-xl sw-text-color-0A0A0A')]");

    private static final SelenideElement editButton = $x("(//div[contains(@class,'modal-trigger sw-js-details-edit-button-')])[2]");

    public CourseDetailsPage setDocumentName(String text) {
        inputDocumentName.shouldBe(Condition.enabled, Duration.ofSeconds(10)).setValue(text);
        return this;
    }

    public CourseDetailsPage uploadDocument() {
        uploadDocument.uploadFromClasspath("1.txt");
        return this;
    }

    public CourseDetailsPage clickUpload() {
        uploadButton.shouldBe(Condition.visible).click();
        return this;
    }

    public CourseDetailsPage checkUploadCourseMaterial(String text) {
        CourseMaterialName = $x("//h3[contains(@class,'sw-font-size-xl sw-text-color-0A0A0A')]").shouldHave(Condition.exactText(document.getDocumentName()));
        CourseMaterialName.shouldBe(Condition.visible);
        return this;
    }

    public void deleteUploadedCourseMaterial(String text) {
        CourseMaterialNameField.shouldBe(Condition.visible).click();
        editButton.click();
        new EditRecordPage()
                .clickDeleteAndSave();
    }
}
