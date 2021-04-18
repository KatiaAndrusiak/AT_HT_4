package com.miamato;

import com.miamato.drivers.DriverManager;
import com.miamato.listeners.TestReporter;
import com.miamato.listeners.TestResultsListener;
import com.miamato.pageobject.ebaytest.RegisterPage;
import com.miamato.pageobject.ebaytest.SearchByDepartmentPage;
import com.miamato.pageobject.ebaytest.HomePage;
import com.miamato.pageobject.ebaytest.SelectCategoryPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

@Listeners({TestResultsListener.class, TestReporter.class})
public abstract class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static final Logger assertLogger = LogManager.getLogger("Assert");

    protected DriverManager driverManager;
    protected PropertyManager propertyManager;
    protected SoftAssert softAssert;
    protected HomePage homePage;
    protected SearchByDepartmentPage searchByDepartmentPage;
    protected SelectCategoryPage selectCategoryPage;
    protected RegisterPage registerPage;

    @Parameters({"browserName","testDataFileName"})
    @BeforeClass
    public void setup(@Optional("Chrome") String browserName
                , @Optional("rozetka.properties") String testDataFileName){
        driverManager = new DriverManager();
        driver.set(driverManager.getDriver(browserName, "Grid"));
        ITestContext context = Reporter.getCurrentTestResult().getTestContext();
        context.setAttribute("WebDriver", driver.get());


        homePage = new HomePage(driver.get(), propertyManager);
        searchByDepartmentPage = new SearchByDepartmentPage(driver.get(),propertyManager);
        selectCategoryPage = new SelectCategoryPage(driver.get(),propertyManager);
        registerPage = new RegisterPage(driver.get(),propertyManager);
    }

    @AfterMethod
    public void browserReset(){
        driver.get().manage().deleteAllCookies();

    }

    @AfterClass
    public void cleanUp(){
        driver.get().quit();
        driver.remove();
    }
}
