package com.demoqa.test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.demoqa.pages.CheckBoxPage;
import com.demoqa.pages.HomePage;
import com.demoqa.test.BaseTest;

public class CheckBoxTest extends BaseTest{
    HomePage homePage;
    CheckBoxPage checkBoxPage;

    @BeforeClass
    public void initPage(){
        homePage= new HomePage(driver);
        checkBoxPage= new CheckBoxPage(driver);
        homePage.goToCheckBoxPage();
    }

    @Test(description="Validate button expand All")
    public void expandAllButtonTest(){
        checkBoxPage.expandAll();
        Assert.assertTrue(checkBoxPage.allTogle());
    }

    @Test(description="Validate button collapse All")
    public void collapseAllButtonTest(){
        checkBoxPage.collapseAll();
        Assert.assertTrue(checkBoxPage.allTogleCollapse());
    }

    @Test(description="Validate select option Desktop")
    public void selectDesktopTest(){
        checkBoxPage.expandAll();
        
    }

    


    
}
