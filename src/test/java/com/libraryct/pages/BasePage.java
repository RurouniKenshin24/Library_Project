package com.libraryct.pages;

import com.libraryct.utils.BrowserUtils;
import com.libraryct.utils.ConfigurationReader;
import com.libraryct.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    @FindBy(xpath = "//a[@class='navbar-brand']")
    private static WebElement navigationBarName;

    @FindBy(id = "navbarDropdown")
    private static WebElement navigationBarDropDown;

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void navigateTo(String tab){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        String tabXpath = "//span[contains(text(),'" + tab + "')and@class='title']";

/*
        //wait until loader mask disappears!!!
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
*/

        WebElement tabElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tabXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();

        BrowserUtils.wait(3);
    }

    public void navigateToModule(String module){
        String moduleXPath = "//span[.='"+module+"']";
        WebElement moduleElement = Driver.getDriver().findElement(By.xpath(moduleXPath));
        moduleElement.click();
    }

    public void navigateToLoginScreen(){
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
    }

}
