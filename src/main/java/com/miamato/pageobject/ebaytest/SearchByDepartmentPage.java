package com.miamato.pageobject.ebaytest;

import com.miamato.PropertyManager;
import com.miamato.pageobject.BasePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchByDepartmentPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(SearchByDepartmentPage.class.getSimpleName());

    @FindBy(xpath = "//*[@class='hl-cat-nav__js-tab']//a[contains(text(), 'Electronics')]")
    public WebElement DEPARTMENT_ELECTRONICS;

    @FindBy(xpath = "//button[@class=\"b-list__footer-resetbutton b-list__footer--viewall\"]")
    public WebElement DEPARTMENT_ELECTRONICS_SHOW_MORE;


    @FindAll(@FindBy(xpath = "//*[@class=\"b-textlink b-textlink--parent\"]"))
    public List<WebElement> ITEMS_IN_DEPARTMENT;

    public SearchByDepartmentPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    @Step("Open department")
    public SearchByDepartmentPage clickOnDepartment() {
        logger.info("CLick on department" + DEPARTMENT_ELECTRONICS);
        clickOnElement(DEPARTMENT_ELECTRONICS, logger);
        //DEPARTMENT_ELECTRONICS_SHOW_MORE.click();
        return this;
    }

    @Step("Open department")
    public boolean searchItemInPage(String searchedItem) {
        logger.info("Search item in department " + searchedItem);
        for (WebElement item : ITEMS_IN_DEPARTMENT) {
            if (item.getText().equals(searchedItem)) {
                logger.info(item.getText());
                return true;
            }
        }
        return false;
    }

}

