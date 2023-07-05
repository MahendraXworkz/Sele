package com.lambda.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormDemo {
        WebDriver driver;
        
        public SimpleFormDemo(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }
    
        @FindBy(id="user-message")
        WebElement inputBox;

        @FindBy(id = "showInput")
        WebElement getCheckedValue ;

        @FindBy(id="message")
        WebElement msg;

        
    }
    

