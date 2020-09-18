package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShareYourCoronavirusStoryTests extends CommonConditions {

    @BeforeMethod
    public void goToShareYourStoryPage() {
        businessLogicLayer.goToShareYourStoryPage();
    }

    @Test
    public void checkSubmitStoryFormWithEmptyStoryField() {
        businessLogicLayer.fillFormWithEmptyStoryField();
        assertElementIsEnabled();
    }

    @Test
    public void checkSubmitStoryFormWithEmptyNameField() {
        businessLogicLayer.fillFormWithEmptyNameField();
        assertElementIsEnabled();
    }

    @Test
    public void checkSubmitStoryFormWithInvalidEmailField() {
        businessLogicLayer.fillFormWithInvalidEmail();
        assertElementIsEnabled();
    }

    @Test
    public void checkSubmitStoryFormWithUncheckedAcceptTerms() {
        businessLogicLayer.fillFormWithUncheckedAcceptTerms();
        assertElementIsEnabled();
    }

    @Test
    public void checkSubmitStoryFormWithUncheckedIAmOver16() {
        businessLogicLayer.fillFormWithUncheckedIAmOver16();
        assertElementIsEnabled();
    }

    public void assertElementIsEnabled() {
        Assert.assertTrue(businessLogicLayer.isShareWithBBCFormValid());
    }
}
