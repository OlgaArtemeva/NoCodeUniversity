package ui.Pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static enums.TestData.teacher;


import java.util.Random;

public class CourseListPage {
    private static final SelenideElement searchByCourse = $x("//input[@placeholder='Search by course name or professor']");
    private static final SelenideElement courseDescription = $x("//div[@class='additional-elements-wrapper css-7spnfl']");
    private static final ElementsCollection courseNames = $$x("//div[@class='list-item-wrapper vertical MuiBox-root css-89nl51']");

    public CourseListPage setTeacherFullNameInSearch(String teacherFullName) {
        searchByCourse.shouldBe(Condition.visible).setValue(teacherFullName);
        return this;
    }

    @Step("select course from list")
    public SelenideElement selectCourse() {

        try {
            courseNames.shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(10));
        } catch (AssertionError e) {
            System.out.println(e.getMessage() + "Courses from \"" + teacher.getFullName() + "\" are not found!");
        }
        Random random = new Random();
        return courseNames.get(random.nextInt(courseNames.size()));
    }
}
