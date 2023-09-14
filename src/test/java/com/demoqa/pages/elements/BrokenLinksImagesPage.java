package com.demoqa.pages.elements;

import java.util.List;

import org.openqa.selenium.WebElement;
import com.demoqa.base.BaseClass;

public class BrokenLinksImagesPage extends BaseClass {
    private final String imagesImg = "//img[contains(@src,'images')]";
    private final String linksA = "//a[@href]";

    public Boolean returnImages() {
        int count = 0;
        if (returnElements(imagesImg).size() == 0) {
            System.out.println("There are no images on the page");
            return true;
        }
        for (WebElement image : returnElements(imagesImg)) {
            if (getAttributeElementNaturalH(image).equals("0")) {
                count++;
                System.out.println("image broken: " + getAttributeElementSrcText(image));
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
}
