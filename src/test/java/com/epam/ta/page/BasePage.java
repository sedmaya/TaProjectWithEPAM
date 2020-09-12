package com.epam.ta.page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    protected abstract BasePage openPage();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


}
