package com.miamato.ebaytest;

import com.miamato.BaseTest;
import com.miamato.PropertyManager;
import org.testng.Assert;
import org.testng.annotations.Test;



public class EbayTest extends BaseTest {

    private static final String SEARCH_ITEM_CAMERAS = PropertyManager.getProperty("search.item.cameras");
    private static final String SEARCH_ITEM_ART_POSTERS =  PropertyManager.getProperty("search.item.in.category.art");
    private static final String FIRST_NAME =  PropertyManager.getProperty("register.first.name");
    private static final String LAST_NAME =  PropertyManager.getProperty("register.last.name");
    private static final String EMAIL =  PropertyManager.getProperty("register.email");
    private static final String PASSWORD =  PropertyManager.getProperty("register.password");

//    private static final String SEARCH_ITEM_COMPUTERS =PropertyManager.getProperty("search.item.computers");
//    private static final String SEARCH_ITEM_PHONES =   PropertyManager.getProperty("search.item.phones");


    @Test
    public void searchItemInDepartment(){
        homePage.open();
        searchByDepartmentPage.clickOnDepartment();
        Assert.assertTrue(searchByDepartmentPage.searchItemInPage(SEARCH_ITEM_CAMERAS));
    }

    @Test
    public void searchBySelectedCategory(){
        homePage.open();
        selectCategoryPage.selectCurrency().clickOnSearchButton();
        Assert.assertTrue(selectCategoryPage.searchItemInCategory(SEARCH_ITEM_ART_POSTERS));
    }

    @Test
    public void register(){
        homePage.open();
        registerPage.clickOnRegisterButton()
                .fillRegisterInfo(FIRST_NAME,LAST_NAME,EMAIL,PASSWORD)
                .clickOnCreateAccountButton();
        Assert.assertTrue(registerPage.checkIfRegistered(FIRST_NAME));
    }
}
