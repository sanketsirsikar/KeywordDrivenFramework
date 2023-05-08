package com.bridgelabz.KeyWord.Base;


import com.bridgelabz.KeyWord.Util.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    Properties properties;
    EventFiringWebDriver eventFiringWebDriver;
    WebEventListener eventListener;

    public Properties initializeProperties() {
        properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("S:\\Selenium\\KeywordDrivenFramework\\src\\main\\resources\\Application.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public WebDriver launchBrowser(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            driver = new ChromeDriver(chromeOptions);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();

        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        eventFiringWebDriver=new EventFiringWebDriver(driver);
        eventListener=new WebEventListener();
        driver=eventFiringWebDriver.register(eventListener);

        driver.manage().window().maximize();
        return driver;
    }
}

