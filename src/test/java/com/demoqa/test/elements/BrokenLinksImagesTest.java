package com.demoqa.test.elements;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.BrokenLinksImagesPage;
import com.demoqa.test.base.BaseTest;

import static io.restassured.RestAssured.*;

public class BrokenLinksImagesTest extends BaseTest {
    HomePage homepage;
    BrokenLinksImagesPage brokenLinksImagesPage;

    @BeforeMethod
    public void preconditions() {
        homepage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        brokenLinksImagesPage = new BrokenLinksImagesPage();
        homepage.goToBrokenLinksImagesPage();
        adsFooter.deleteAds();
    }

    @Test
    public void validate() {
        //
    }

    @Test(description = "validate images page", enabled = false)
    public void validateImagesPage() {
        Assert.assertTrue(brokenLinksImagesPage.returnImages());
    }

    @Test(description = "validate links page", enabled = false)
    public void validateLinksPage() {

        int count = 0;
        if (brokenLinksImagesPage.returnLinks().size() == 0) {
            System.out.println("There are no links on the page");
        }
        for (WebElement link : brokenLinksImagesPage.returnLinks()) {
            String href = getAttributeElementHref(link);

            int code = given()
                    .when()
                    .get(href)
                    .then()
                    .extract()
                    .statusCode();
            if (code >= 400) {
                count++;
                System.out.println("link broken: " + href);
            } else {
                System.out.println("link no broken: " + href);
            }
        }
        if (count != 0) {
            Assert.assertTrue(false);
        } else {
            Assert.assertTrue(true);
        }
    }

}
