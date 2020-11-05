package com.libraryct.pages;

import com.libraryct.utils.BrowserUtils;
import com.libraryct.utils.ConfigurationReader;
import com.libraryct.utils.Driver;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {
    Select select;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

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

    public void selectItemDropDown(WebElement element, String optionText){
        select = new Select(element);
        select.selectByVisibleText(optionText);
    }

    public WebElement getRecordsDropDown(String tabName){
        String xpath = "//select[@name='tbl_" + tabName +"_length']";
        WebElement element  = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element;
    }

    public int getCountOfRecords(String recordType){
        String xpath = "//table[@id='tbl_"+ recordType +"']//tr";
        List<WebElement> recordList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    //  Driver.getDriver().findElements(By.xpath(xpath));

        BrowserUtils.wait(3);
        for (int i = 1;i < recordList.size();i++){
            System.out.println(i + ".Record: " + recordList.get(i).getText());
        }

        int recordNumbers = recordList.size()-1;
        return recordNumbers;
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
