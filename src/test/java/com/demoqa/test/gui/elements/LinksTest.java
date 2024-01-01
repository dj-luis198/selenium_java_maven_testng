package com.demoqa.test.gui.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.LinksPage;
import com.demoqa.util.AnsiColorUtils;

import static io.restassured.RestAssured.*;

@Test(groups = "LinksTest", timeOut = 30000)
public class LinksTest extends BaseTest {
        HomePage homePage;
        LinksPage linksPage;

        private static Logger logger = LogManager.getLogger(LinksTest.class);

        @BeforeMethod
        public void preconditions() {
                try {
                        linksPage = new LinksPage();
                        linksPage.goToLinks(homePage);
                } catch (TimeoutException | NoSuchElementException e) {
                        logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas, iniciando setUp \n"+e));
                        String browser = getBrowser();
                        setUp(browser);
                        linksPage = new LinksPage();
                        linksPage.goToLinks(homePage);
                }
        }

        /*
         * @Test(description = "Following links will open new tab Home")
         * public void followingLinksWillOpenNewTabHome() {
         * linksPage.clickNewTabSimpleLink();
         * Assert.assertTrue(linksPage.returnURL());
         * }
         * 
         * @Test(description = "Following links will open new tab Home dinamic link")
         * public void followingLinksWillOpenNewTabHomeDinamic() {
         * linksPage.clickNewTabDinamicLink();
         * Assert.assertTrue(linksPage.returnURL());
         * }
         */

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
