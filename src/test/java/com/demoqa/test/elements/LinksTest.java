package com.demoqa.test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.LinksPage;
import com.demoqa.test.base.BaseTest;

import static io.restassured.RestAssured.*;

public class LinksTest extends BaseTest {
        LinksPage linksPage;

        @BeforeMethod
        public void preconditions() {
                HomePage homePage = new HomePage();
                AdsFooter adsFooter = new AdsFooter();
                linksPage = new LinksPage();
                homePage.goToLinksPage();
                adsFooter.deleteAds();
        }

        @Test(description = "Following links will open new tab Home")
        public void followingLinksWillOpenNewTabHome() {
                linksPage.clickNewTabSimpleLink();
                Assert.assertTrue(linksPage.returnURL());
        }

        @Test(description = "Following links will open new tab Home dinamic link")
        public void followingLinksWillOpenNewTabHomeDinamic() {
                linksPage.clickNewTabDinamicLink();
                Assert.assertTrue(linksPage.returnURL());
        }

        @Test(description = "Following links will send an api call create")
        public void FollowingLinksWillSendAnApiCallCreate() {
                linksPage.clickCreatedLink();
                baseURI = "https://demoqa.com";
                given()
                                .when()
                                .get("/created")
                                .then()
                                .statusCode(201);
                Assert.assertEquals(linksPage.returnLinkResponseMsg(),
                                "Link has responded with staus 201 and status text Created");
        }

        @Test(description = "Following links will send an api call no-content")
        public void FollowingLinksWillSendAnApiCallNoContent() {
                linksPage.clickNoContentLink();
                baseURI = "https://demoqa.com";
                given()
                                .when()
                                .get("/no-content")
                                .then()
                                .statusCode(204);
                Assert.assertEquals(linksPage.returnLinkResponseMsg(),
                                "Link has responded with staus 204 and status text No Content");
        }

        @Test(description = "Following links will send an api call Moved")
        public void FollowingLinksWillSendAnApiCallMoved() {
                linksPage.clickMovedLink();
                baseURI = "https://demoqa.com";
                given()
                                .redirects().follow(false)
                                .when()
                                .get("/moved")
                                .then()
                                .statusCode(301);
                Assert.assertEquals(linksPage.returnLinkResponseMsg(),
                                "Link has responded with staus 301 and status text Moved Permanently");
        }

        @Test(description = "Following links will send an api call Bad Request")
        public void FollowingLinksWillSendAnApiCallBadRequest() {
                linksPage.clickBadRequestLink();
                baseURI = "https://demoqa.com";
                given()
                                .when()
                                .get("/bad-request")
                                .then()
                                .statusCode(400);
                Assert.assertEquals(linksPage.returnLinkResponseMsg(),
                                "Link has responded with staus 400 and status text Bad Request");
        }

        @Test(description = "Following links will send an api call Unauthorized")
        public void FollowingLinksWillSendAnApiCallUnauthorized() {
                linksPage.clickUnauthorizedLink();
                baseURI = "https://demoqa.com";
                given()
                                .when()
                                .get("/unauthorized")
                                .then()
                                .statusCode(401);
                Assert.assertEquals(linksPage.returnLinkResponseMsg(),
                                "Link has responded with staus 401 and status text Unauthorized");
        }

        @Test(description = "Following links will send an api call Forbidden")
        public void FollowingLinksWillSendAnApiCallForbidden() {
                linksPage.clickForbiddenLink();
                baseURI = "https://demoqa.com";
                given()
                                .when()
                                .get("/forbidden")
                                .then()
                                .statusCode(403);
                Assert.assertEquals(linksPage.returnLinkResponseMsg(),
                                "Link has responded with staus 403 and status text Forbidden");
        }

        @Test(description = "Following links will send an api call Not Found")
        public void FollowingLinksWillSendAnApiCallNotFound() {
                linksPage.clickInvalidURLLink();
                baseURI = "https://demoqa.com";
                given()
                                .when()
                                .get("/invalid-url")
                                .then()
                                .statusCode(404);
                Assert.assertEquals(linksPage.returnLinkResponseMsg(),
                                "Link has responded with staus 404 and status text Not Found");
        }
}
