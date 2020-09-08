package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'gs-u-display-inline-block@m')]//h3")
    private WebElement headlineNewsTitle;

    @FindBy(id = "sign_in")
    private WebElement signInPopUp;

    @FindBy(xpath = " //div[@class='sign_in-container']/button[@aria-label='close']")
    private WebElement signInPopUpCloseButton;

    @FindBy(xpath = "//div[contains(@class,'secondary-item')]//h3")
    private List<WebElement> secondaryNewsTitles;

    @FindBy(xpath = "//div[contains(@class,'gs-u-display-inline-block@m')]//a[contains(@class, 'nw-c-section-link')]//span[text()]")
    private WebElement headlineNewsCategoryLink;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchBar;

    @FindBy(xpath = "//nav[@class='nw-c-nav__wide']//span[.='Coronavirus']")
    private WebElement coronavirusNewsNavigationTab;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeadlineNewsTitle() {
        return headlineNewsTitle;
    }

    public String getHeadlineNewsTitleText() {
        return headlineNewsTitle.getText();
    }

    public List<WebElement> getSecondaryNewsTitlesList() {
        return secondaryNewsTitles;
    }

    public WebElement getHeadlineNewsCategoryLink() {
        return headlineNewsCategoryLink;
    }

    public String getHeadlineNewsCategoryLinkText() {
        return headlineNewsCategoryLink.getText();
    }

    public void searchByHeadlineNewsCategory(String keyword) {
        searchBar.sendKeys(keyword, Keys.ENTER);
    }

    public WebElement getSignInPopUp() {
        return signInPopUp;
    }

    public void clickSignInPopUpCloseButton() {
        signInPopUpCloseButton.click();
    }

    public WebElement getCoronavirusNewsNavigationTab() {
        return coronavirusNewsNavigationTab;
    }

    public void clickCoronavirusNewsNavigationTab() {
        coronavirusNewsNavigationTab.click();
    }


}
