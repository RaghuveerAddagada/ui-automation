package com.praveenkh.pages;

import driverEngine.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageFooter {

    private final BrowserActions browserActions;
    final By copyRightInFooter = By.xpath("//*[@id=\"84018e6c-a859-4f30-b691-b5ffe8050167\"]/div/section/div[1]/div/div/div[1]/div/p/span");
    final By badmintonInFooter = By.xpath("//*[@id=\"84018e6c-a859-4f30-b691-b5ffe8050167\"]/div/section/div[2]/ul/li[1]/a");
    final By privacyPolicyInFooter = By.xpath("//a[normalize-space()='Privacy Policy']");
    final By privacyPolicyPageHeader = By.xpath("//*[@id=\"563e12cf-1420-4b37-991c-e03e67767a88\"]/div/section/div/div/div/div/div/span");
    final By termsAndConditionsInFooter = By.xpath("//a[normalize-space()='Terms and Conditions']");
    final By termsAndConditionsPageHeader = By.xpath("//*[@id=\"92a074a7-313e-4fcc-ac20-f9fb2271a0cc\"]/div/section/div/h1/span");

    public HomePageFooter(WebDriver driver) {
        browserActions = new BrowserActions(driver);

        //TODO Check that we're on the right page by asserting page title or URL
    }

    public void validateCopyright() {
        final String COPYRIGHT_TEXT_FOOTER = "Copyright © 2022 Praveen K H - All Rights Reserved.";
        Assert.assertEquals(COPYRIGHT_TEXT_FOOTER, browserActions.getTextFromElement(copyRightInFooter), "Copyright text mismatch at footer");
    }

    public void validateBadminton() {
        final String YOUTUBE_CHANNEL_LINK = "https://www.youtube.com/channel/UCOmpwPOwUWrWejxsI-gRlbg";
        Assert.assertEquals("BADMINTON", browserActions.getTextFromElement(badmintonInFooter), "Copyright text mismatch at footer");
        Assert.assertEquals(YOUTUBE_CHANNEL_LINK, browserActions.getAttributeFromElement(badmintonInFooter, "href"), "Copyright link mismatch at footer");
        // TODO Check if the YouTube Href is 200 or not
    }

    public HomePageFooter validatePrivacyPolicy() {
        final String PRIVACY_POLICY_LINK = "https://praveenkh.com/privacy-policy";
        Assert.assertEquals("PRIVACY POLICY", browserActions.getTextFromElement(privacyPolicyInFooter), "PrivacyPolicy text mismatch at footer");
        Assert.assertEquals(PRIVACY_POLICY_LINK, browserActions.getAttributeFromElement(privacyPolicyInFooter,"href"), "Privacy policy link mismatch at footer");
        return this;
    }

    public HomePageFooter clickOnPrivacyPolicy() {
        browserActions.clickOnElement(privacyPolicyInFooter);
        final String PRIVACY_PAGE_URL = "https://praveenkh.com/privacy-policy";
        Assert.assertEquals(PRIVACY_PAGE_URL, browserActions.getCurrentUrl(), "Page Url mismatch privacy-policy");
        return this;
    }

    public void validatePrivacyPolicyPageContent() {
        Assert.assertEquals("Privacy Policy coming soon", browserActions.getTextFromElement(privacyPolicyPageHeader), "Privacy Policy page content mismatch");
    }

    public HomePageFooter validateTermsAndConditions() {
        final String TERMS_AND_CONDITIONS_LINK = "https://praveenkh.com/terms-and-conditions";
        Assert.assertEquals("TERMS AND CONDITIONS", browserActions.getTextFromElement(termsAndConditionsInFooter), "Terms and Conditions text mismatch at footer");
        Assert.assertEquals(TERMS_AND_CONDITIONS_LINK, browserActions.getAttributeFromElement(termsAndConditionsInFooter,"href"), "Terms and Conditions link mismatch at footer");
        return this;
    }

    public HomePageFooter clickOnTermsAndConditions() {
        browserActions.clickOnElement(termsAndConditionsInFooter);
        final String TERMS_AND_CONDITIONS_PAGE_URL = "https://praveenkh.com/terms-and-conditions";
        Assert.assertEquals(TERMS_AND_CONDITIONS_PAGE_URL, browserActions.getCurrentUrl(), "Page Url mismatch at terms-and-conditions");
        return this;
    }

    public void validateTermsAndConditionsPageContent() {
        Assert.assertEquals("TERMS AND CONDITIONS", browserActions.getTextFromElement(termsAndConditionsPageHeader), "Terms and Conditions page content mismatch");
    }
}
