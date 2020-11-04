package com.libraryct.step_definitions;

import com.libraryct.pages.UserManagementPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

public class UserFilterDropdown_StepDefinitions {

    UserManagementPage userManagementPage = new UserManagementPage();

    @When("librarian selects the {string} from User Groups dropdown menu")
    public void librarian_selects_the_from_user_groups_dropdown_menu(String string) {
        string = "Librarian";
        Select select = new Select(userManagementPage.getUserDropDown());
        select.selectByVisibleText(string);
        System.out.println("SELECTED USER IS = " + select.getFirstSelectedOption().getText());
    }




    @Then("librarian should be able to see all users on the table are Librarians")
    public void librarian_should_be_able_to_see_all_users_on_the_table_are_librarians() {

    }
}
