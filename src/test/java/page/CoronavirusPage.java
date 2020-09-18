package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusPage extends BasePage {

    public CoronavirusPage() {

    }

    @FindBy(xpath = "//ul[contains(@class,'secondary')]//a[@class='nw-o-link']")
    private WebElement yourCoronavirusStoryTab;

    public YourCoronavirusStoryPage goToYourCoronavirusStoryPage() {
        waitForElementIsClickable(WAIT_TIMEOUT_SECONDS, yourCoronavirusStoryTab);
        yourCoronavirusStoryTab.click();
        return new YourCoronavirusStoryPage();
    }
}
