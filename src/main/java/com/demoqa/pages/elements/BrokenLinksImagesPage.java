package com.demoqa.pages.elements;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;
import com.demoqa.util.AnsiColorUtils;

public class BrokenLinksImagesPage extends BaseClass {
    private final String imagesImg = "//img[contains(@src,'images')]";
    private final String linksA = "//a[@href]";

    private static Logger logger= LogManager.getLogger(BrokenLinksImagesPage.class);

    public Boolean returnImages() {
        int count = 0;
        if (BaseClass.returnElements(imagesImg).size() == 0) {
            logger.info("There are no images on the page");
            return true;
        }
        for (WebElement image : BaseClass.returnElements(imagesImg)) {
            if (BaseClass.getAttributeElementNaturalH(image).equals("0")) {
                count++;
                logger.error(AnsiColorUtils.applyRed("image broken: " + BaseClass.getAttributeElementSrcText(image)));
            }
        }
        if (count != 0) {
            return false;
        } else {
            return true;
        }
    }

    public List<WebElement> returnLinks() {
        return BaseClass.returnElements(linksA);
    }

    public String returnHref(WebElement element) {
        return BaseClass.getAttributeElementHref(element);
    }

    public void goToBrokenLinksImages(HomePage homePage){
        homePage = new HomePage();
        homePage.goToHome();
        homePage.goToBrokenLinksImagesPage();
    }
}
