package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShareWithBBCPage extends BasePage {

    @FindBy(xpath = "//div[@class='long-text-input-container']/textarea")
    private WebElement tellYourStoryField;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement yourNameContactInfoField;

    @FindBy(xpath = "//input[@placeholder='Email address']")
    private WebElement yourEmailContactInfoField;

    @FindBy(xpath = "//span/div/p[text() = 'I am over 16 years old']//preceding::input[1]")
    private WebElement iAmOver16Checkbox;

    @FindBy(xpath = "//span/div/p[text() = 'I accept the ']//preceding::input[1]")
    private WebElement iAcceptTermsCheckbox;

    @FindBy(xpath = "//div/button[@class='button']")
    private WebElement submitStoryButton;


    public ShareWithBBCPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getYourStoryField() {
        return tellYourStoryField;
    }

    public void clickYourStoryField() {
        tellYourStoryField.click();
    }

    public void enterYourStoryToField(String keyword) {
        tellYourStoryField.sendKeys(keyword, Keys.ENTER);
    }

    public void clickYourNameContactInfoField() {
        yourNameContactInfoField.click();
    }

    public void enterYourNameContactInfoField(String keyword) {
        yourNameContactInfoField.sendKeys(keyword, Keys.ENTER);
    }

    public void clickYourEmailContactInfoField() {
        yourEmailContactInfoField.click();
    }

    public void enterYourEmailContactInfoField(String keyword) {
        yourEmailContactInfoField.sendKeys(keyword, Keys.ENTER);
    }

    public void clickIAmOver16Checkbox() {
        iAmOver16Checkbox.click();
    }

    public void clickIAcceptTermsCheckbox() {
        iAcceptTermsCheckbox.click();
    }

    public WebElement getSubmitStoryButton() {
        return submitStoryButton;
    }

    public void clicksSubmitStoryButton() {
        submitStoryButton.click();
    }

}
