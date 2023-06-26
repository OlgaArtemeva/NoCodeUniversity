package ui.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class CourseDetailsPage {
    //    private static final SelenideElement inputDocumentName = $x("//div[@field='Document Name']");
    private static final SelenideElement inputDocumentName = $x("//input[@class='MuiInputBase-input MuiOutlinedInput-input css-q1sikp']");
    private static final SelenideElement uploadDocument = $x("//input[@id='upload-course-material-form-Document-1880928548']");
    //    private static final SelenideElement uploadDocument = $x("//span[.='Browse']");
    private static final SelenideElement uploadButton = $x("//button[@label='Upload']");

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
}
