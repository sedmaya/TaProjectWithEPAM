package tests;

import BLL.BusinessLogicLayer;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import util.PropertiesExtractor;

import java.util.concurrent.TimeUnit;

public class CommonConditions {

    private static final String BASE_URL = "https://www.bbc.com";
    protected WebDriver driver;
    protected BusinessLogicLayer businessLogicLayer;


    @BeforeMethod
    public void profileSetUp() {
        PropertiesExtractor.readProperties();
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver.get(BASE_URL);
        businessLogicLayer = new BusinessLogicLayer();
    }

    @AfterMethod
    public void cleanupAfterMethod() {
        DriverManager.closeDriver();
        businessLogicLayer = null;
    }

    @AfterClass
    public void cleanDriver() {
        DriverManager.quitDriver();
        driver = null;
    }
}
