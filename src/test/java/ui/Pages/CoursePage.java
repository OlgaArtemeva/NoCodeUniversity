package ui.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CoursePage {
    private static final SelenideElement documentName = $x("//input[@id='upload-course-material-form-DocumentName--1971305433']");
    private static final SelenideElement uploadDocument = $x("//input[@id='upload-course-material-form-Document-1880928548']");
    private static final SelenideElement uploadButton = $x("//button[text()='Upload']");

}
