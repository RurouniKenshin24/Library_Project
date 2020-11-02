package com.libraryct.step_definitions;
//changes

import com.libraryct.pages.UsersPage;
import com.libraryct.utils.BrowserUtils;
import com.libraryct.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User_search_StepDefinitions {

    WebDriver driver = Driver.getDriver();
    UsersPage usersPage = new UsersPage();

    @Given("librarian is on the User Management page")
    public void librarian_is_on_the_user_management_page() {
        usersPage.navigateTo("Users");
    }

    @When("user enters {string} into the Search input")
    public void user_enters_into_the_search_input(String string) {
        usersPage.writeInSearchBox(string);
        BrowserUtils.wait(1);
    }

    @Then("user should see only results that contain {string} in Full Name, Email, or User ID")
    public void user_should_see_only_results_that_contain_in_full_name_email_or_user_id(String string) {
        List<String> userID = new ArrayList<>();
        List<String> fullName = new ArrayList<>();
        List<String> email = new ArrayList<>();

        for(int i=1; i<=10; i++){
            userID.add(driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]")).getText());
            fullName.add(driver.findElement(By.xpath("//tbody/tr["+i+"]/td[3]")).getText());
            email.add(driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]")).getText());
        }

        List<List<String>> usersInfo = new ArrayList<>();

        for(int i=0; i< 10; i++){
            usersInfo.add(Arrays.asList(userID.get(i),fullName.get(i),email.get(i)));
        }

        for (List<String> eachUser : usersInfo) {
            Assert.assertTrue(eachUser.get(0).toLowerCase().contains(string) || eachUser.get(1).toLowerCase().contains(string) || eachUser.get(2).toLowerCase().contains(string));
        }

        Driver.closeDriver();
    }
}
