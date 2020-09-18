package tests;

import BLL.BusinessLogicLayer;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import util.PropertiesExtractor;

import java.util.concurrent.TimeUnit;

public class CommonConditions {

    private static final String BASE_URL = "https://www.bbc.com";
    protected WebDriver driver;
    protected BusinessLogicLayer businessLogicLayer;


    @BeforeTest
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
    public void cleanBLL() {
        businessLogicLayer = null;
    }

    @AfterTest
    public void cleanDriver() {
        DriverManager.quitDriver();
        driver = null;
    }
}
