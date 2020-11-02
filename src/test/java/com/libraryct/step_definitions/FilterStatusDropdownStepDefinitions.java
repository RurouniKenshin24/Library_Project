package com.libraryct.step_definitions;

import com.libraryct.pages.UserManagementPage;
import com.libraryct.utils.BrowserUtils;
import com.libraryct.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class FilterStatusDropdownStepDefinitions {
     UserManagementPage userManagementPage = new UserManagementPage();

     @When("user selects {string} from Status dropdown")
    public void user_selects_from_status_dropdown(String string) {
        Select select = new Select(userManagementPage.getStatusDropDown());
        select.selectByVisibleText(string);
         BrowserUtils.wait(2);
    }

    @When("user selects {string} from Records dropdown")
    public void user_selects_from_records_dropdown(String string) {
        Select recordsDropdown = new Select(userManagementPage.getShowRecordsDropDown());
        recordsDropdown.selectByValue(string);
    }

    @Then("user should see all user's status are {string}")
    public void user_should_see_all_user_s_status_are(String string) {
        List<String> statusList = new ArrayList<>();
        for (int i=1; i<42; i++){
            statusList.add(Driver.getDriver().findElement(By.xpath("//tbody/tr["+i+"]/td[6]")).getText());
        }

        for (String each: statusList){
            Assert.assertTrue(each.equals(string));
        }

    }

}
