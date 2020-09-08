package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusPage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class,'secondary')]//a[@class='nw-o-link']")
    private WebElement yourCoronavirusStoriesTab;

    @FindBy(xpath = "//div[@aria-labelledby='nw-c-Getintouchwithus__title']//h3[. = 'How to share with BBC News']")
    private WebElement howToShareWithBBCLink;


    public CoronavirusPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getYourCoronavirusStoriesTab() {
        return yourCoronavirusStoriesTab;
    }

    public void clickYourCoronavirusStoriesTab() {
        yourCoronavirusStoriesTab.click();
    }

    public WebElement getHowToShareWithBBCLink() {
        return howToShareWithBBCLink;
    }

    public void clickHowToShareWithBBCLink() {
        howToShareWithBBCLink.click();
    }

}
