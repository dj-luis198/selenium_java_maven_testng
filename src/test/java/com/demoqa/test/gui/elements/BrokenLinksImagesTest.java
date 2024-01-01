package com.demoqa.test.gui.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.BrokenLinksImagesPage;
import com.demoqa.util.AnsiColorUtils;

import static io.restassured.RestAssured.*;
import java.util.List;

@Test(groups = "BrokenLinksImagesTest", timeOut = 30000)
public class BrokenLinksImagesTest extends BaseTest {
    HomePage homePage;
    BrokenLinksImagesPage brokenLinksImagesPage;

    private static Logger logger= LogManager.getLogger(BrokenLinksImagesTest.class);


    @BeforeMethod
    public void preconditions() {
        try {
            brokenLinksImagesPage = new BrokenLinksImagesPage();
            brokenLinksImagesPage.goToBrokenLinksImages(homePage);
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas, iniciando setUp \n"+e));
            String browser = getBrowser();
            setUp(browser);
            brokenLinksImagesPage = new BrokenLinksImagesPage();
            brokenLinksImagesPage.goToBrokenLinksImages(homePage);
        }
    }

    @Test(description = "validate images page", enabled = false)
    public void validateImagesPage() {
        Assert.assertTrue(brokenLinksImagesPage.returnImages());
    }

    @Test(description = "validate links page")
    public void validateLinksPage() {
        int count = 0;
        List<WebElement> links = brokenLinksImagesPage.returnLinks();

        if (links.isEmpty()) {
            logger.info("There are no links on the page");
            return;
        }

        for (WebElement link : links) {
            String href = getAttributeElementHref(link);
            int code = given()
                    .when()
                    .get(href)
                    .then()
                    .extract()
                    .statusCode();

            if (code >= 400) {
                count++;
                logger.error(AnsiColorUtils.applyRed("link broken: " + href));
            } else {
                logger.info("link not broken: " + href);
            }
        }

        Assert.assertEquals(count, 0, "Some links are broken");
    }

}
