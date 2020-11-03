package com.libraryct.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUserInformationPage extends BasePage {

    @FindBy(name = "full_name")
    public WebElement fullname;

    @FindBy(name = "password")
    public WebElement Password;

    @FindBy(name = "email")
    public WebElement email;

    @FindBy(id = "address")
    public WebElement address;

    @FindBy(css ="button[type='submit']" )
    public WebElement submitButton;

}
