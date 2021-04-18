package com.miamato.pageobject.ebaytest;

import com.miamato.PropertyManager;
import com.miamato.pageobject.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(SelectCategoryPage.class.getSimpleName());

    public RegisterPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }
    @FindBy(xpath = "//a[@href=\"https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F\"]")
    public static WebElement REGISTER_BUTTON;


    @FindBy(xpath = "//input[@id=\"firstname\"]")
    public static WebElement FIRSTNAME_FIELD;

    @FindBy(xpath = "//input[@id=\"lastname\"]")
    public static WebElement LASTNAME_FIELD;

    @FindBy(xpath = "//input[@id=\"Email\"]")
    public static WebElement EMAIL_FIELD;

    @FindBy(xpath = "//input[@id=\"password\"]")
    public static WebElement PASSWORD_FIELD;

    @FindBy(xpath = "//button[@id=\"EMAIL_REG_FORM_SUBMIT\"]")
    public static WebElement CREATE_ACCOUNT_BUTTON;

    @FindBy(xpath = "//button[@id=\"gh-ug\"]")
    public static WebElement CHECK_IF_REGISTERED;


    public RegisterPage clickOnRegisterButton(){
        logger.info("Clicking on register button");
        clickOnElement(REGISTER_BUTTON,logger);
        return this;
    }

    public RegisterPage fillRegisterInfo(String firstName, String lastName, String email, String password){
        logger.info("Fill firstname field with " + firstName);
        enterTextIntoField(FIRSTNAME_FIELD, firstName, logger);
        logger.info("Fill lastname field with " + lastName);
        enterTextIntoField(LASTNAME_FIELD,lastName,logger);
        logger.info("Fill email field with " + email);
        enterTextIntoField(EMAIL_FIELD,email, logger);
        logger.info("Fill password field with " + password);
        enterTextIntoField(PASSWORD_FIELD,password,logger);
        return this;
    }

    public RegisterPage clickOnCreateAccountButton(){
        logger.info("Clicking on 'Create Account' button");
        CREATE_ACCOUNT_BUTTON.click();
        return this;
    }


    public boolean checkIfRegistered(String name){
        logger.info("Checking if registered");
        return CHECK_IF_REGISTERED.getText().contains(name);
    }

}
