package com.epam.ta.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShareWithBBCPage extends BasePage {

    private final String BASE_URL = "https://www.bbc.com/news/10725415";

    public ShareWithBBCPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//textarea[@placeholder='Tell us your story. ']")
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

    @Override
    public ShareWithBBCPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
