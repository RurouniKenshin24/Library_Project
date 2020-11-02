package com.libraryct.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends BasePage{

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInputBox;

    public void writeInSearchBox(String searchFor){
        searchInputBox.sendKeys(searchFor);
    }
}
