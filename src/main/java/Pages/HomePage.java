package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[.='News']")
    private WebElement newsTab;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickNewsTab() {
        newsTab.click();
    }

}
