package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoronavirusPage extends BasePage {

    private final String PAGE_URL = "https://www.bbc.com/news/coronavirus";

    public CoronavirusPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(xpath = "//ul[contains(@class,'secondary')]//a[@class='nw-o-link']")
    private WebElement yourCoronavirusStoriesTab;

    @FindBy(xpath = "//div[@aria-labelledby='nw-c-Getintouchwithus__title']//h3[. = 'How to share with BBC News']")
    private WebElement howToShareWithBBCLink;

    public WebElement getYourCoronavirusStoriesTab() {
        return yourCoronavirusStoriesTab;
    }

    public void clickYourCoronavirusStoriesTab() {
        yourCoronavirusStoriesTab.click();
    }

    public WebElement getHowToShareWithBBCLink() {
        return howToShareWithBBCLink;
    }

    @Override
    public CoronavirusPage openPage()
    {
        driver.navigate().to(PAGE_URL);
        return this;
    }

}
