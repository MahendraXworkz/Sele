package com.lambda.test;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass 
{
    WebDriver driver;
    SoftAssert softAssert=new SoftAssert();
    Actions action;
    
    void initialize(String browser,String version,String platform) throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("browserName", browser);
capabilities.setCapability("browserVersion", version);
HashMap<String, Object> ltOptions = new HashMap<String, Object>();
ltOptions.put("username", "mahendra.testingfy");
ltOptions.put("accessKey", "JWKbEhuXGskBfAxrOsmLH8LK6qnrdqtMdpTht0HuM3akQL3PUO");
ltOptions.put("platformName", platform);
ltOptions.put("visual", true);
ltOptions.put("video", true);
ltOptions.put("console", true);
ltOptions.put("network", true);
ltOptions.put("project", "Selenium Java 101");
capabilities.setCapability("LT:Options", ltOptions);

        driver=new RemoteWebDriver(new URL("https://mahendra.testingfy:JWKbEhuXGskBfAxrOsmLH8LK6qnrdqtMdpTht0HuM3akQL3PUO@hub.lambdatest.com/wd/hub"),capabilities);
        action = new Actions(driver);
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    void shutDown(){
        driver.quit();
    }
    
     //Test data

}
