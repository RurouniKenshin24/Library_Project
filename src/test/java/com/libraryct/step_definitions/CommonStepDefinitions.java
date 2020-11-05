package com.libraryct.step_definitions;

import com.libraryct.pages.BasePage;
import com.libraryct.pages.HomePage;
import com.libraryct.pages.UsersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class CommonStepDefinitions {

    BasePage basePage = new HomePage();

    @Given("user is on the {string} page")
    public void user_is_on_the_page(String string) {
        basePage.navigateTo(string);
    }

    @When("user selects {string} record as a {string} from dropdown")
    public void user_selects_record_as_a_from_dropdown(String string, String string2) {
        WebElement element = basePage.getRecordsDropDown(string);
        basePage.selectItemDropDown(element,string2);
    }

    @Then("user should be able to see the {string} numbers of {string} records on the table")
    public void user_should_be_able_to_see_the_numbers_of_records_on_the_table(String string, String string2) {
        String actualRecordNumbers = "" + basePage.getCountOfRecords(string2);
        String expectedRecordNumbers = string;

        Assert.assertEquals(expectedRecordNumbers,actualRecordNumbers);
    }
}
