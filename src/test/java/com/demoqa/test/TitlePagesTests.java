package com.demoqa.test;

import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.HomePage;

public class TitlePagesTests extends BaseTest{
 HomePage homePage;

    @Test
    public void homePageTitle() throws InterruptedException{
        homePage= new HomePage();
        homePage.SelectElements();
    }
}
