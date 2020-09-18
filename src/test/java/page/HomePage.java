package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage() {
    }

    @FindBy(id = "sign_in")
    private List<WebElement> signInPopUpList;

    @FindBy(xpath = "//div[@id='sign_in']//button[@aria-label='close']")
    private WebElement signInPopUpCloseButton;

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[.='News']")
    private WebElement newsTab;

    public void signInPopUpHandle() {

        if (signInPopUpList == null || signInPopUpList.isEmpty()) {
            return;
        }

        if (signInPopUpList.get(0).isDisplayed() && signInPopUpList.get(0).isEnabled()) {
            signInPopUpCloseButton.click();
        }
    }

    public void goToNewsPage() {
        waitForElementIsClickable(WAIT_TIMEOUT_SECONDS, newsTab);
        newsTab.click();
    }
}
