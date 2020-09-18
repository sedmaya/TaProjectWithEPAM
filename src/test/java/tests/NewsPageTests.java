package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class NewsPageTests extends CommonConditions {

    @BeforeMethod
    public void init() {
        businessLogicLayer.goToNewsPage();
    }

    @Test
    public void checkMainNewsTitle() {
        Assert.assertEquals(businessLogicLayer.actualHeadlineNewsTitle(), "US to ban TikTok and WeChat downloads in 48 hours");
    }

    @Test
    public void checkSecondaryNewsTitles() {
        List<String> actualSecondaryArticlesTitlesList = businessLogicLayer.getSecondaryNewsTitlesList();

        Assert.assertEquals(actualSecondaryArticlesTitlesList, Arrays.asList(
                "England could face tighter rules to combat Covid",
                "Are older Trump voters sticking with him?",
                "Siberia’s bizarre bumps",
                "Alligator on gas snaps up Ig Nobel prize",
                "Bolivia's interim leader quits presidential race"));
    }

    @Test
    public void checkFirstArticleTitle() {
        String actualFirstArticleTitle = businessLogicLayer
                .goToCategorySearchResultsPage()
                .actualFieldArticleName();
        Assert.assertEquals(actualFirstArticleTitle, "Tudur's TV Flashback: Series 1: Technology");
    }
}
