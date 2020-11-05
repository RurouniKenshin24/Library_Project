package com.libraryct.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends BasePage{

    @FindBy(partialLinkText = "Add User")
    private WebElement addUserButton;

    @FindBy(id = "user_groups")
    private WebElement userGroupDropDown;

    @FindBy(id = "user_status")
    private WebElement statusDropDown;

    @FindBy(xpath = "//select[@name='tbl_users_length']")
    private WebElement recordsDropDown;

    @FindBy(id = "tbl_users")
    private WebElement usersTable;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInputBox;

    public void writeInSearchBox(String searchFor){
        searchInputBox.sendKeys(searchFor);
    }
}
