package com.libraryct.step_definitions;

import com.libraryct.pages.DashboardPage;
import com.libraryct.pages.UserManagementPage;
import com.libraryct.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChooseUsersPage {

    DashboardPage dashboardPage = new DashboardPage();
    UserManagementPage userManagementPage = new UserManagementPage();

    @When("user clicks {string} button")
    public void user_clicks_button(String string) {
        dashboardPage.navigateTo("Users");
    }


    @Then("user should see {string} page")
    public void user_should_see_page(String string) {
        String actualPageHeading = userManagementPage.getUserManagementHeading().getText();
        System.out.println(actualPageHeading);
        String expectedPageHeading = "User Management";

        Assert.assertEquals(expectedPageHeading,actualPageHeading);
    }

}
