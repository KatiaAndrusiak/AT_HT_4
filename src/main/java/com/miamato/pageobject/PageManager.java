package com.miamato.pageobject;

import com.miamato.PropertyManager;
import com.miamato.pageobject.ebaytest.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public class PageManager {

    public WebDriver driver;
    public PropertyManager propertyManager;

    public HomePage homePage;


    public PageManager(ITestContext context, PropertyManager propertyManager){
        this.driver = (WebDriver) context.getAttribute("WebDriver");
        this.propertyManager = propertyManager;
    }

    public HomePage homePage(){
        if(this.homePage == null)
            homePage = new HomePage(driver, propertyManager);
        return homePage;
    }



}
