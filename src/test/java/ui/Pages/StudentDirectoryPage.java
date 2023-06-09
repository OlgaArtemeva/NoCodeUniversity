package ui.Pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class StudentDirectoryPage {
    private static final SelenideElement searchFieldStudentDirectory = $x("//input[@placeholder='Start typing to search']");
    private ElementsCollection listNames = $$x("//div[@class='horizontal-list-item']");
    private static final SelenideElement userEmailFromSearchlist = $x("(//div[@class='label-wrapper vertical'])[5]");

    @Step("Insert full name into the search field: '{fullName}'")
    public StudentDirectoryPage insertFullNameInSearchField(String fullName) {
        searchFieldStudentDirectory.scrollTo();
        searchFieldStudentDirectory.shouldBe(Condition.visible).setValue(fullName);
        return this;
    }

    @Step("Select user in list")
    public void selectUserInList(String email) {

        boolean flag = false;

        try {
            listNames.shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(10));
        } catch (AssertionError e) {
            System.out.println(e.getMessage() + "API-created user is not found!");
        }

        for (int i = 0; i < listNames.size(); i++) {
            SelenideElement listName = listNames.get(i);
            listName.shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
            if (userEmailFromSearchlist.shouldBe(Condition.visible, Duration.ofSeconds(30)).getText().equals(email)) {
                flag = true;
                System.out.println("API-created user is found! (email: " + userEmailFromSearchlist.getText() + ", number in the list: " + i + ")");
                break;
            }
        }

        if (flag == false) {
            throw new RuntimeException("API-created user is not found!");
        }
    }
}
