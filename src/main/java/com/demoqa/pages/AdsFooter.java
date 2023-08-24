package com.demoqa.pages;

import com.demoqa.base.BaseClass;

public class AdsFooter extends BaseClass {

    private final String ads = "//div[@id='fixedban']";
    private final String footer ="//div[@id='app']//footer";

    public void deleteAds(){
        AdsCSSDisplayNone(ads);
        AdsCSSDisplayNone(footer);

    }
}
