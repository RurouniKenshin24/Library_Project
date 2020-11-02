package com.libraryct.step_definitions;

import com.libraryct.pages.LoginPage;
import com.libraryct.utils.BrowserUtils;
import com.libraryct.utils.ConfigurationReader;
import com.libraryct.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDefinitions {

    WebDriver driver;
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String url = ConfigurationReader.getProperty("URL");
        Driver.getDriver().get(url);
    }

    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {
        loginPage.login(string);
        BrowserUtils.wait(3);
    }

    @Then("user should be able to see dashboard page")
    public void user_should_be_able_to_see_dashboard_page() {
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Library";

        Assert.assertEquals(expectedTitle,actualTitle);
        Driver.closeDriver();
    }

    @When("user logs in with {string} email and {string} password")
    public void user_logs_in_with_email_and_password(String string, String string2) {
        loginPage.login(string,string2);
        BrowserUtils.wait(3);
    }

    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String string) {
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Sorry, Wrong Email or Password";

        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
        Driver.closeDriver();
    }

    @When("user logs in as a librarian")
    public void user_logs_in_as_a_librarian() {
        loginPage.loginLibrarian();
    }
}
