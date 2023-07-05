package com.lambda.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage 
{
    WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Simple Form Demo']")
    WebElement simpleFormDemo;

    @FindBy(xpath = "//a[text()='Drag & Drop Sliders']")
    WebElement dragAndDropSliders;

    @FindBy(xpath = "//a[text()='Input Form Submit']")
    WebElement inputFormSubmit;
}
