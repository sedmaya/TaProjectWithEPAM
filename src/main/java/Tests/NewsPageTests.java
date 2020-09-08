
package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsPageTests extends BaseTest {

    private final static String EXPECTED_MAIN_NEWS_TITLE = "Biden calls for police to be charged in shootings";
    private final static List<String> EXPECTED_SECONDARY_ARTICLES_TITLES_LIST = Arrays.asList(
            "Russian opposition leader 'poisoned with Novichok'",
            "US sanctions staff at top war crimes court",
            "Dwayne 'the Rock' Johnson and family had Covid-19",
            "Who is moderating the presidential debates?",
            "Pelosi calls rule-flouting salon visit a 'setup'");

    private static final String EXPECTED_SEARCHED_MAIN_NEWS_TITLE = "Americans, go home: Tension at Canada-US border";

    public void generalSteps() {
        getHomePage().clickNewsTab();
    }

    @Test
    public void checkMainNewsTitle() {
        generalSteps();
        getBasePage().waitForElementVisibility(30, getNewsPage().getHeadlineNewsTitle());
        Assert.assertEquals(getNewsPage().getHeadlineNewsTitleText(), EXPECTED_MAIN_NEWS_TITLE);
    }

    @Test
    public void checkSecondaryNewsTitles() {
        generalSteps();
        getBasePage().waitForElementVisibility(30, getNewsPage().getHeadlineNewsTitle());
        List<String> actualSecondaryArticlesTitlesList = new ArrayList<>();
        List<WebElement> elementList = getNewsPage().getSecondaryNewsTitlesList();
        for (WebElement element : elementList) {
            actualSecondaryArticlesTitlesList.add(element.getText());
        }
        Assert.assertEquals(actualSecondaryArticlesTitlesList, EXPECTED_SECONDARY_ARTICLES_TITLES_LIST);
    }

    @Test
    public void chekFirstArticleTitle() {
        generalSteps();
        getBasePage().waitForElementIsClickable(30, getNewsPage().getHeadlineNewsCategoryLink());
        String searchKeys = getNewsPage().getHeadlineNewsCategoryLinkText();
        getNewsPage().searchByHeadlineNewsCategory(getNewsPage().getHeadlineNewsCategoryLinkText());
        Assert.assertEquals(getCategorySearchResultPage().getSearchedMainNewsTittle(), EXPECTED_SEARCHED_MAIN_NEWS_TITLE);
    }


    @AfterTest
    public void tearDown() {
        getDriver().close();
    }
}
