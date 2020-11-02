package com.libraryct.step_definitions;

import com.libraryct.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setup(Scenario scenario){
        System.out.println(":::Starting Automation:::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Before("@db")
    public void dbSetup(){
        System.out.println(":::Connecting to the database:::");
    }

    @After("@db")
    public void dbTearDown(){
        System.out.println(":::Disconnecting to the database:::");
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
        System.out.println(":::(^_^) End of test execution (*_*):::");
    }
}
