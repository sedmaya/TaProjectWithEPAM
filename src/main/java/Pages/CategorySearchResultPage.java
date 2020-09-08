package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategorySearchResultPage extends BasePage {

    @FindBy(xpath = "(//a[@class='css-vh7bxp-PromoLink ett16tt7'])[1]/span")
    private WebElement searchedFirstMainNewsTittle;


    public String getSearchedMainNewsTittle() {
        return searchedFirstMainNewsTittle.getText();
    }

    public CategorySearchResultPage(WebDriver driver) {
        super(driver);
    }

}
