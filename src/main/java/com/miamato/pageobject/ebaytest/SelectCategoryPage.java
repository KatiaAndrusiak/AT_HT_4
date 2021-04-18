package com.miamato.pageobject.ebaytest;

import com.miamato.PropertyManager;
import com.miamato.pageobject.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectCategoryPage extends BasePage  {
    private static final Logger logger = LogManager.getLogger(SelectCategoryPage.class.getSimpleName());

    @FindBy(xpath = "//select[@class=\"gh-sb \"]")
    protected static WebElement DROP_DOWN_MENU;

    @FindBy(xpath = "//input[@class=\"btn btn-prim gh-spr\"]")
    public static WebElement SEARCH_BUTTON;

    @FindAll(@FindBy(xpath = " //a[@class=\"b-textlink b-textlink--parent\"]"))
    public List<WebElement> ITEMS_IN_DEPARTMENT;


    private static final String CATEGORY_TO_CHANGE = "550";

    public SelectCategoryPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public SelectCategoryPage selectCurrency(){
        logger.info("Select currency from drop-down menu: " + DROP_DOWN_MENU+ " by value: "+ CATEGORY_TO_CHANGE);
        this.selectFromDropdownByValue(DROP_DOWN_MENU,CATEGORY_TO_CHANGE,logger);
        return this;
    }

    public  SelectCategoryPage clickOnSearchButton(){
        logger.info("Clicking on search button");
        SEARCH_BUTTON.click();
        return this;
    }

    public boolean searchItemInCategory(String searchedItem){
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
