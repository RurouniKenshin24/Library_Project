package com.libraryct.step_definitions;

import com.libraryct.pages.BasePage;
import com.libraryct.pages.LoginPage;
import com.libraryct.pages.UsersPage;
import com.libraryct.utils.ConfigurationReader;
import com.libraryct.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserStepDefinitions {

    WebDriver driver;
    BasePage userPage = new UsersPage();
    LoginPage loginPage = new LoginPage();

    @Given("user is on the users page")
    public void user_is_on_the_users_page() {
        userPage.navigateTo("Users");
    }

    @When("user select {string} numbers {string} from records dropdown")
    public void user_select_numbers_from_records_dropdown(String string, String string2) {
        WebElement element = userPage.getRecordsDropDown(string2);
        System.out.println(string2);
        userPage.selectItemDropDown(element,string);
    }
}
