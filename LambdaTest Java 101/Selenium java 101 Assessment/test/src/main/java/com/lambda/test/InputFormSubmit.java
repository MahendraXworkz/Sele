package com.lambda.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputFormSubmit {
    WebDriver driver;
        
        public InputFormSubmit(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }

        @FindBy(id="name")
        WebElement name;

        @FindBy(id="inputEmail4")
        WebElement email;

        @FindBy(id="inputPassword4")
        WebElement password;

        @FindBy(css="input[placeholder='Company']")
        WebElement company;

        @FindBy(id="websitename")
        WebElement websiteName;

        @FindBy(css="select[name='country']")
        WebElement country;

        @FindBy(id="inputCity")
        WebElement inputCity;

        @FindBy(id="inputAddress1")
        WebElement inputAddress1;

        @FindBy(id="inputAddress2")
        WebElement inputAddress2;

        @FindBy(id="inputState")
        WebElement inputState;

        @FindBy(id="inputZip")
        WebElement inputZip;

        @FindBy(xpath = "//button[text()='Submit']")
        WebElement submitBtn;

        @FindBy(css = ".success-msg.hidden")
        WebElement successMsg;



}
