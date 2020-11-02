package com.libraryct.step_definitions;

import com.github.javafaker.Faker;
import com.libraryct.pages.UserManagementPage;

import com.libraryct.pages.UsersPage;
import com.libraryct.utils.BrowserUtils;
import com.libraryct.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddUserStepDefinitions {

    UserManagementPage userManagementPage = new UserManagementPage();
    UsersPage usersPage = new UsersPage();
    Faker faker = new Faker();
    static String fullName;


    @When("user clicks on Add User button")
    public void user_clicks_on_add_user_button() {
        userManagementPage.clickAddUser();
    }


    @When("user adds new user information")
    public void user_adds_new_user_information() {
        fullName = faker.name().fullName();
        userManagementPage.getFullNameField().sendKeys(fullName);
        userManagementPage.getPasswordField().sendKeys(fullName.replace(" ",""));
        userManagementPage.getEmailField().sendKeys(fullName.replace(" ","") +"@gmail.com");
        userManagementPage.getAddressField().sendKeys(faker.address().fullAddress());
    }

    @When("clicks Save Changes button")
    public void clicks_save_changes_button() {
        userManagementPage.clickSaveChangesButton();

    }

    @Then("user should be able to see saved user on the list")
    public void user_should_be_able_to_see_saved_user_on_the_list() {
        BrowserUtils.wait(1);
       usersPage.writeInSearchBox(fullName);
        BrowserUtils.wait(1);
        String actual = userManagementPage.getFullNameCellText();
        Assert.assertEquals(fullName, actual);
    }

}
