package com.demoqa.pages.elements;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.util.AnsiColorUtils;

public class BrokenLinksImagesPage extends BaseClass {
    private final String imagesImg = "//img[contains(@src,'images')]";
    private final String linksA = "//a[@href]";

    private static Logger logger= LogManager.getLogger(BrokenLinksImagesPage.class);

    public Boolean returnImages() {
        int count = 0;
        if (returnElements(imagesImg).size() == 0) {
            logger.info("There are no images on the page");
            return true;
        }
        for (WebElement image : returnElements(imagesImg)) {
            if (getAttributeElementNaturalH(image).equals("0")) {
                count++;
                logger.error(AnsiColorUtils.applyRed("image broken: " + getAttributeElementSrcText(image)));
            }
        }
        if (count != 0) {
            return false;
        } else {
            return true;
        }
    }

    public List<WebElement> returnLinks() {
        return returnElements(linksA);
    }

    public String returnHref(WebElement element) {
        return getAttributeElementHref(element);
    }

    public void goToBrokenLinksImages(HomePage homePage){
        homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToBrokenLinksImagesPage();
        adsFooter.deleteAds();
    }
}
