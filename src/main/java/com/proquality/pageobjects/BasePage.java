package com.proquality.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected static WebDriver driver;
    private static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public BasePage() {
        if (driver == null) {
            // WebDriverManager.chromedriver().avoidBrowserDetection().setup();
            // WebDriverManager.chromedriver().setup();
            WebDriverManager.firefoxdriver().avoidBrowserDetection().setup();
            // driver = new ChromeDriver();
            driver = new FirefoxDriver();
        }
        PageFactory.initElements(driver, this);
    }

    protected <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getBaseUrl() {
        return BASE_URL;
    }
}