package Tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShareYourCoronavirusStoryTests extends BaseTest {

    private static final String FORM_EMPTY_FIELD = "";
    private static final String YOUR_STORY_FIELD_DATA = "Hi! How are you?...";
    private static final String NAME_FIELD_DATA = "Jenny";
    private static final String EMAIL_INVALID_DATA = "мамамилараму@#.net";

    public void generalSteps() {
        Actions actions = new Actions(getDriver());

        getHomePage().clickNewsTab();
        getBasePage().waitForElementVisibility(30, getNewsPage().getSignInPopUp());
        getNewsPage().clickSignInPopUpCloseButton();
        getBasePage().waitForElementIsClickable(30, getNewsPage().getCoronavirusNewsNavigationTab());
        getNewsPage().clickCoronavirusNewsNavigationTab();
        getBasePage().waitForElementIsClickable(30, getCoronavirusPage().getYourCoronavirusStoriesTab());
        getCoronavirusPage().clickYourCoronavirusStoriesTab();
        getBasePage().waitForElementVisibility(30, getCoronavirusPage().getHowToShareWithBBCLink());
        actions.moveToElement(getCoronavirusPage().getHowToShareWithBBCLink()).click().build().perform();
    }

    public void assertionGeneralSteps() {
        WebElement element = getShareWithBBCPage().getSubmitStoryButton();

        getShareWithBBCPage().clicksSubmitStoryButton();
        getBasePage().waitForElementVisibility(20, element);
        Assert.assertTrue(element.isEnabled());
    }

    @Test
    public void checkSubmitStoryFormWithEmptyStoryField() {

        generalSteps();
        getBasePage().waitForElementVisibility(30, getShareWithBBCPage().getYourStoryField());
        getShareWithBBCPage().clickYourStoryField();
        getShareWithBBCPage().enterYourStoryToField(FORM_EMPTY_FIELD);
        getShareWithBBCPage().clickYourNameContactInfoField();
        getShareWithBBCPage().enterYourNameContactInfoField(NAME_FIELD_DATA);
        getShareWithBBCPage().clickIAmOver16Checkbox();
        getShareWithBBCPage().clickIAcceptTermsCheckbox();
        assertionGeneralSteps();
    }

    @Test
    public void checkSubmitStoryFormWithEmptyNameField() {

        generalSteps();
        getBasePage().waitForElementVisibility(30, getShareWithBBCPage().getYourStoryField());
        getShareWithBBCPage().clickYourStoryField();
        getShareWithBBCPage().enterYourStoryToField(YOUR_STORY_FIELD_DATA);
        getShareWithBBCPage().clickYourNameContactInfoField();
        getShareWithBBCPage().enterYourNameContactInfoField(FORM_EMPTY_FIELD);
        getShareWithBBCPage().clickIAmOver16Checkbox();
        getShareWithBBCPage().clickIAcceptTermsCheckbox();
        assertionGeneralSteps();

    }

    @Test
    public void checkSubmitStoryFormWithInvalidEmailField() {

        generalSteps();
        getBasePage().waitForElementVisibility(30, getShareWithBBCPage().getYourStoryField());
        getShareWithBBCPage().clickYourStoryField();
        getShareWithBBCPage().enterYourStoryToField(YOUR_STORY_FIELD_DATA);
        getShareWithBBCPage().clickYourNameContactInfoField();
        getShareWithBBCPage().enterYourNameContactInfoField(NAME_FIELD_DATA);
        getShareWithBBCPage().clickYourEmailContactInfoField();
        getShareWithBBCPage().enterYourEmailContactInfoField(EMAIL_INVALID_DATA);
        getShareWithBBCPage().clickIAmOver16Checkbox();
        getShareWithBBCPage().clickIAcceptTermsCheckbox();
        assertionGeneralSteps();
    }

    @Test
    public void checkSubmitStoryFormWithUncheckedOver16Field() {

        generalSteps();
        getBasePage().waitForElementVisibility(30, getShareWithBBCPage().getYourStoryField());
        getShareWithBBCPage().clickYourStoryField();
        getShareWithBBCPage().enterYourStoryToField(YOUR_STORY_FIELD_DATA);
        getShareWithBBCPage().clickYourNameContactInfoField();
        getShareWithBBCPage().enterYourNameContactInfoField(NAME_FIELD_DATA);
        getShareWithBBCPage().clickYourEmailContactInfoField();
        getShareWithBBCPage().clickIAcceptTermsCheckbox();
        assertionGeneralSteps();

    }
}
