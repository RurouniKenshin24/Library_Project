package com.libraryct.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(id = "user_count")
    private WebElement usersDashboard;

    @FindBy(id = "book_count")
    private WebElement booksDashboard;

    @FindBy(id = "borrowed_books")
    private WebElement borrowBooksDashboard;

    public String getUserNumbers(){
        String users = usersDashboard.getText();
        return users;
    }

    public String getBookNumbers(){
        String books = booksDashboard.getText();
        return books;
    }

    public String getBorrowedBookNumbers(){
        String borrowedBooks = borrowBooksDashboard.getText();
        return borrowedBooks;
    }
}
