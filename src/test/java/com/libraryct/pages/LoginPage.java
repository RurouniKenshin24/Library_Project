package com.libraryct.pages;

import com.libraryct.utils.BrowserUtils;
import com.libraryct.utils.ConfigurationReader;
import com.libraryct.utils.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);

    @FindBy(id = "inputEmail")
    private WebElement emailInputBox;

    @FindBy(id = "inputPassword")
    private WebElement passwordInputBox;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block']")
    private WebElement signInButton;

    @FindBy(className = "alert alert-danger")
    private WebElement errorMessage;

    public void loginLibrarian(){
        String email = ConfigurationReader.getProperty("librarianEmail");
        String password = ConfigurationReader.getProperty("librarian_password");

        BrowserUtils.enterText(emailInputBox,email);
        BrowserUtils.enterText(passwordInputBox,password);
        signInButton.click();
    }

    public void login(String email, String password){
        wait.until(ExpectedConditions.visibilityOf(emailInputBox)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox)).sendKeys(password);
/*
        BrowserUtils.enterText(emailInputBox,email);
        BrowserUtils.enterText(passwordInputBox,password);
*/
        signInButton.click();
    }

    public void login(String role){

        String librarianEmail = ConfigurationReader.getProperty("librarianEmail");
        System.out.println(librarianEmail);
        String librarianPassword = ConfigurationReader.getProperty("librarian_password");
        String studentEmail = ConfigurationReader.getProperty("studentEmail");
        System.out.println(studentEmail);
        String studentPassword = ConfigurationReader.getProperty("student_password");

        if (role.equalsIgnoreCase("librarian")){
            wait.until(ExpectedConditions.visibilityOf(emailInputBox)).sendKeys(librarianEmail);
            wait.until(ExpectedConditions.visibilityOf(passwordInputBox)).sendKeys(librarianPassword);
/*          BrowserUtils.enterText(emailInputBox,librarianEmail);
            BrowserUtils.enterText(passwordInputBox,librarianPassword);
            */
        }else if(role.equalsIgnoreCase("student")){
            wait.until(ExpectedConditions.visibilityOf(emailInputBox)).sendKeys(studentEmail);
            wait.until(ExpectedConditions.visibilityOf(passwordInputBox)).sendKeys(studentPassword);
/*
            BrowserUtils.enterText(emailInputBox,studentEmail);
            BrowserUtils.enterText(passwordInputBox,studentPassword);
*/
        }
        signInButton.click();
    }

    public String getErrorMessage(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return errorMessage.getText();
    }
}
