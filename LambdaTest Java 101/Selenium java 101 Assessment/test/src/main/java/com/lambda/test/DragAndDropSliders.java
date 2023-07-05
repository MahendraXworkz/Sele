package com.lambda.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropSliders 
{
    WebDriver driver;
    public DragAndDropSliders(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(css = "[value='15']")
    WebElement slider;
    
    @FindBy(css = ".sp__range-success [id='rangeSuccess']")
    WebElement value;
}