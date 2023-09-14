package com.demoqa.test;

import org.testng.annotations.Test;

import com.demoqa.pages.common.HomePage;
import com.demoqa.test.base.BaseTest;

public class TitlePagesTests extends BaseTest{
 HomePage homePage;

    @Test
    public void homePageTitle() throws InterruptedException{
        homePage= new HomePage();
        
        System.out.println(homePage.getTitleHomePage());
        homePage.SelectElements();
    }
}
