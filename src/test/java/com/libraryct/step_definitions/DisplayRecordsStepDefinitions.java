package com.libraryct.step_definitions;

import com.libraryct.pages.DashboardPage;
import com.libraryct.pages.LoginPage;
import com.libraryct.pages.UserManagementPage;
import com.libraryct.utils.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DisplayRecordsStepDefinitions {

    UserManagementPage userManagementPage = new UserManagementPage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user is on the User Management page")
    public void user_is_on_the_user_management_page() {
        loginPage.navigateToLoginScreen();
        loginPage.login("librarian");
        dashboardPage.navigateToModule(ConfigurationReader.getProperty("module"));
        /*
        THIS CAN BE ONE METHOD, BUT MY BRAIN ISN'T WORKING RIGHT NOW.
        I WILL COMBINE THIS INTO ONE METHOD WHEN
        I AM FULLY AWAKE...
         */


    }

    @When("enters clicks {string} records")
    public void enters_clicks_records(String string) {
        userManagementPage.selectRecords(string);
    }

    @Then("the user will see {string} records in the table")
    public void the_user_will_see_records_in_the_table(String string) {
        try {
            Assert.assertTrue(userManagementPage.getStringOfStudents().size() <= Integer.valueOf(string));
        } catch(org.openqa.selenium.StaleElementReferenceException e) {
            Assert.assertTrue(userManagementPage.getStringOfStudents().size() <= Integer.valueOf(string));
        }
        /*
        FLUENT WAIT WOULD BE BETTER,
        BUT THIS WORKS FOR NOW...
         */

    }




}
