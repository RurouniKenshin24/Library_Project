package com.libraryct.step_definitions;

import com.libraryct.pages.EditUserInformationPage;
import com.libraryct.pages.UserManagementPage;
import com.libraryct.pages.UsersPage;
import com.libraryct.utils.BrowserUtils;
import com.libraryct.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class User_Edit_StepDefinitions {

    WebDriver driver = Driver.getDriver();
    UsersPage usersPage = new UsersPage();
    UserManagementPage userManagementPage = new UserManagementPage();
    EditUserInformationPage editUserInformationPage = new EditUserInformationPage();

    @When("user click to  Edit User button")
    public void user_click_to_edit_user_button() {
        userManagementPage.clickEditUserButton1();
    }

    @When("user change all user information")
    public void user_change_all_user_information() {
        editUserInformationPage.fullname.clear();
        editUserInformationPage.fullname.sendKeys("Borat Sagadiev");
        editUserInformationPage.Password.sendKeys("VeryNice");
        editUserInformationPage.email.clear();
        editUserInformationPage.email.sendKeys("Trump2020@gmail.com");
        editUserInformationPage.address.clear();
        editUserInformationPage.address.sendKeys("Red Square, Moscow, Russia");

    }

    @When("user click Save change Button")
    public void user_click_save_change_button() {
        editUserInformationPage.submitButton.click();
    }

    @Then("user should be able to see saved user information on the list")
    public void user_should_be_able_to_see_saved_user_information_on_the_list() {
        BrowserUtils.wait(3);
        usersPage.writeInSearchBox("Borat Sagadiev");
        BrowserUtils.wait(2);
        String actual = userManagementPage.getFullNameCellText();
        Assert.assertEquals("Borat Sagadiev", actual);

    }



}
