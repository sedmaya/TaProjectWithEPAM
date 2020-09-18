package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class YourCoronavirusStoryPage extends BasePage {

    public YourCoronavirusStoryPage() {

    }

    @FindBy(xpath = "//div[@aria-labelledby='nw-c-Getintouchwithus__title']//h3[. = 'How to share with BBC News']")
    private WebElement howToShareWithBBCLink;


    public ShareWithBBCPage goToShareWithBBCPage() {
        Actions actions = new Actions(driver);
        waitForElementIsClickable(WAIT_TIMEOUT_SECONDS, howToShareWithBBCLink);
        actions.moveToElement(howToShareWithBBCLink).click().build().perform();
        return new ShareWithBBCPage();
    }
}
