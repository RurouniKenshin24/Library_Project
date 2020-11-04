package com.libraryct.step_definitions;
import com.libraryct.pages.DashboardPage;
import com.libraryct.pages.UserManagementPage;
import com.libraryct.pages.UsersPage;
import com.libraryct.utils.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserEditStepDefinitions {

    UserManagementPage userManagementPage = new UserManagementPage();
    UsersPage usersPage = new UsersPage();
    DashboardPage dashboardPage = new DashboardPage();

    @When("i should able to click user button")
    public void i_should_able_to_click_user_button() {
        dashboardPage.navigateTo("Users");
        BrowserUtils.wait(2);
    }

    @And("i should able to click to edit user button")
    public void i_should_able_to_click_to_edit_user_button() {
        userManagementPage.clickEditUserButton1();
        BrowserUtils.wait(2);
    }

    @And("i should edit user name")
    public void i_should_edit_user_name() {
        userManagementPage.getFullNameField().clear();
        userManagementPage.getFullNameField().sendKeys("Anton Perozhkov");
        BrowserUtils.wait(2);
    }

    @Then("i should click to save changes")
    public void i_should_click_to_save_changes() {

        userManagementPage.clickSaveChangesButton();


    }
}
