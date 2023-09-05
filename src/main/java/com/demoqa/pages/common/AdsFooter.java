package com.demoqa.pages.common;

import com.demoqa.base.BaseClass;

public class AdsFooter extends BaseClass {

    private final String ads = "//div[@id='fixedban']";
    private final String footer ="//footer";
    private final String sidebar ="//div[contains(@class,'sidebar')]";
    private final String header ="(//div[contains(@id,'Ad.Plus-728x90')])[1]";


    public void deleteAds(){
        AdsCSSDisplayNone(ads);
        AdsCSSDisplayNone(footer);
        AdsCSSDisplayNone(sidebar);
        AdsCSSDisplayNone(header);
    }
}
