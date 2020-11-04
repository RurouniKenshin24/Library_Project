package com.libraryct.step_definitions;

import com.libraryct.pages.UserManagementPage;
import com.libraryct.utils.BrowserUtils;
import com.libraryct.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.HashSet;

public class UserFilterDropdown_StepDefinitions {

    UserManagementPage userManagementPage = new UserManagementPage();

    @When("librarian selects the {string} from User Groups dropdown menu")
    public void librarian_selects_the_from_user_groups_dropdown_menu(String string) {
        Select select = new Select(userManagementPage.getUserDropDown());
        select.selectByVisibleText(string);
    }




    @Then("librarian should be able to see all users on the table are {string}")
    public void librarian_should_be_able_to_see_all_users_on_the_table_are_librarians(String string) {
        userManagementPage.selectRecords("500");
        BrowserUtils.wait(1); // wait until all elements are loaded

        HashSet<String> userGroups = new HashSet<>(userManagementPage.getStringOfStudents()); // Set will helps us to eliminate all duplicates of "Librarian"

        Driver.getDriver().findElement(By.xpath("//a[.='2']")).click(); // clicking to next page to get all users
        BrowserUtils.wait(1); // wait until all elements are loaded

        userGroups.addAll(userManagementPage.getStringOfStudents()); // if all objects are the same size of HashSet is still 1

        if (userGroups.size() == 1){ // if size =! 1, it means all object are not the same
            Assert.assertTrue(userGroups.contains(string));
        }else {
            Assert.fail();
        }

    }
}
