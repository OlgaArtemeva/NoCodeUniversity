package ui.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class EditRecordPage {
    private SelenideElement valueDocumentName = $x("//input[@name='Document Name']");
    private SelenideElement checkBoxDelete = $x("//span[contains(text(),'Delete')]");
    private SelenideElement saveButton = $x("(//button[contains(text(),'Save')])[2]");

    public CourseDetailsPage clickDeleteAndSave() {
        checkBoxDelete.click();
        saveButton.click();
        saveButton.shouldBe(Condition.hidden, Duration.ofSeconds(20));
        return new CourseDetailsPage();
    }
}
