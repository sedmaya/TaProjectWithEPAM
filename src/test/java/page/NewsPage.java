package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class NewsPage extends BasePage {

    public NewsPage() {
    }

    @FindBy(xpath = "//div[contains(@class, 'gs-u-display-inline-block@m')]//h3")
    private WebElement headlineNewsTitle;

    @FindBy(id = "sign_in")
    private WebElement signInPopUp;

    @FindBy(xpath = " //div[@id='sign_in']//button[@aria-label='close']")
    private WebElement signInPopUpCloseButton;

    @FindBy(xpath = "//div[contains(@class,'secondary-item')]//h3")
    private List<WebElement> secondaryNewsTitles;

    @FindBy(xpath = "//div[contains(@class,'gs-u-display-inline-block@m')]//a[contains(@class, 'nw-c-section-link')]//span[text()]")
    private WebElement headlineNewsCategoryLink;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchBar;

    @FindBy(xpath = "//nav[@class='nw-c-nav__wide']//span[.='Coronavirus']")
    private WebElement coronavirusNewsNavigationTab;


    public String actualHeadlineNewsTitle() {
        waitForElementVisibility(WAIT_TIMEOUT_SECONDS, headlineNewsTitle);
        return headlineNewsTitle.getText();
    }

    public List<String> getSecondaryNewsTitlesList() {
        waitForElementVisibility(WAIT_TIMEOUT_SECONDS, headlineNewsTitle);
        List<String> actualSecondaryArticlesTitlesList = new ArrayList<>();
        List<WebElement> elementList = secondaryNewsTitles;
        for (WebElement element : elementList) {
            actualSecondaryArticlesTitlesList.add(element.getText());
        }
        return actualSecondaryArticlesTitlesList;
    }

    public CategorySearchResultPage goToCategorySearchResultsPage() {
        waitForElementIsClickable(WAIT_TIMEOUT_SECONDS, headlineNewsCategoryLink);
        searchBar.sendKeys(headlineNewsCategoryLink.getText(), Keys.ENTER);
        return new CategorySearchResultPage();
    }

    public NewsPage signInPopUpHandle() {
        waitForElementVisibility(WAIT_TIMEOUT_SECONDS, signInPopUp);
        signInPopUpCloseButton.click();
        return new NewsPage();
    }

    public CoronavirusPage goToCoronavirusTab() {
        waitForElementIsClickable(WAIT_TIMEOUT_SECONDS, coronavirusNewsNavigationTab);
        coronavirusNewsNavigationTab.click();
        return new CoronavirusPage();
    }
}
