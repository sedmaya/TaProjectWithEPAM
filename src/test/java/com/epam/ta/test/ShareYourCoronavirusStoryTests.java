package com.epam.ta.test;

import com.epam.ta.page.CoronavirusPage;
import com.epam.ta.page.HomePage;
import com.epam.ta.page.NewsPage;
import com.epam.ta.page.ShareWithBBCPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.ta.util.StringUtils;

public class ShareYourCoronavirusStoryTests extends CommonConditions {

    private static final int FORM_EMPTY_FIELD = 0;
    protected static final int FORM_FIELD_TEXT_LENGTH = 7;

    //private static final String YOUR_STORY_FIELD_DATA = "Hi! How are you?...";
    //private static final String NAME_FIELD_DATA = "Jenny";

    HomePage getHomePage = new HomePage(driver);
    NewsPage getNewsPage = new NewsPage(driver);
    CoronavirusPage getCoronavirusPage = new CoronavirusPage(driver);
    ShareWithBBCPage getShareWithBBCPage = new ShareWithBBCPage(driver);


    @BeforeMethod
    public void goToShareWithBBCForm() {
        Actions actions = new Actions(driver);

        getHomePage.clickNewsTab();
        waitForElementVisibility(WAIT_TIMEOUT_SECONDS, getNewsPage.getSignInPopUp());
        getNewsPage.clickSignInPopUpCloseButton();
        waitForElementIsClickable(WAIT_TIMEOUT_SECONDS, getNewsPage.getCoronavirusNewsNavigationTab());
        getNewsPage.clickCoronavirusNewsNavigationTab();
        waitForElementIsClickable(WAIT_TIMEOUT_SECONDS, getCoronavirusPage.getYourCoronavirusStoriesTab());
        getCoronavirusPage.clickYourCoronavirusStoriesTab();
        waitForElementVisibility(WAIT_TIMEOUT_SECONDS, getCoronavirusPage.getHowToShareWithBBCLink());
        actions.moveToElement(getCoronavirusPage.getHowToShareWithBBCLink()).click().build().perform();
    }


    @Test
    public void checkSubmitStoryFormWithEmptyStoryField() {

        waitForElementVisibility(WAIT_TIMEOUT_SECONDS, getShareWithBBCPage.getYourStoryField());
        getShareWithBBCPage.clickYourStoryField();
        getShareWithBBCPage.enterYourStoryToField(StringUtils.generateRandomStringWithSetLength(FORM_EMPTY_FIELD));
        getShareWithBBCPage.clickYourNameContactInfoField();
        getShareWithBBCPage.enterYourNameContactInfoField(StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        getShareWithBBCPage.clickIAmOver16Checkbox();
        getShareWithBBCPage.clickIAcceptTermsCheckbox();
        assertElementIsEnabled();
    }

    @Test
    public void checkSubmitStoryFormWithEmptyNameField() {

        waitForElementVisibility(WAIT_TIMEOUT_SECONDS, getShareWithBBCPage.getYourStoryField());
        getShareWithBBCPage.clickYourStoryField();
        getShareWithBBCPage.enterYourStoryToField(StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        getShareWithBBCPage.clickYourNameContactInfoField();
        getShareWithBBCPage.enterYourNameContactInfoField(StringUtils.generateRandomStringWithSetLength(FORM_EMPTY_FIELD));
        getShareWithBBCPage.clickIAmOver16Checkbox();
        getShareWithBBCPage.clickIAcceptTermsCheckbox();
        assertElementIsEnabled();
    }

    @Test
    public void checkSubmitStoryFormWithInvalidEmailField() {

        waitForElementVisibility(WAIT_TIMEOUT_SECONDS, getShareWithBBCPage.getYourStoryField());
        getShareWithBBCPage.clickYourStoryField();
        getShareWithBBCPage.enterYourStoryToField(StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        getShareWithBBCPage.clickYourNameContactInfoField();
        getShareWithBBCPage.enterYourNameContactInfoField(StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        getShareWithBBCPage.clickYourEmailContactInfoField();
        getShareWithBBCPage.enterYourEmailContactInfoField("мамамилараму@#.net");
        getShareWithBBCPage.clickIAmOver16Checkbox();
        getShareWithBBCPage.clickIAcceptTermsCheckbox();
        assertElementIsEnabled();
    }

    @Test
    public void checkSubmitStoryFormWithUncheckedOver16Field() {

        String yourStoryFieldContent = StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH);
        String yourNameFieldContent = StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH);
        waitForElementVisibility(WAIT_TIMEOUT_SECONDS, getShareWithBBCPage.getYourStoryField());

        getShareWithBBCPage.openPage();
        getShareWithBBCPage.clickYourStoryField();
        getShareWithBBCPage.enterYourStoryToField(yourStoryFieldContent);
        getShareWithBBCPage.clickYourNameContactInfoField();
        getShareWithBBCPage.enterYourNameContactInfoField(yourNameFieldContent);
        getShareWithBBCPage.clickIAcceptTermsCheckbox();
        assertElementIsEnabled();

    }

    public void assertElementIsEnabled() {
        WebElement element = getShareWithBBCPage.getSubmitStoryButton();

        getShareWithBBCPage.clicksSubmitStoryButton();
        waitForElementVisibility(WAIT_TIMEOUT_SECONDS, element);
        Assert.assertTrue(element.isEnabled());
    }
}
