package com.lambda.test;

import java.net.MalformedURLException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Test(threadPoolSize = 5)
public class Tests extends BaseClass{
    @Parameters(value = {"Browser","Version","Platform"})
    @BeforeMethod
    void setup(String browser,String version,String platform){
        try {
            initialize(browser,version,platform);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    void tearDown(){
        shutDown();
    }

    @Test(timeOut = 20000)
    void scenario1() throws InterruptedException{
        LandingPage landingPage=new LandingPage(driver);
        landingPage.simpleFormDemo.click();
        //validate url contains simple-form-demo
        softAssert.assertTrue(driver.getCurrentUrl().contains("simple-form-demo"), "URL not contains simple-form-demo");
        
        SimpleFormDemo simpleFormDemo=new SimpleFormDemo(driver);
        //creating string variable to store and send to input
        String string="Welcome to LambdaTest";
        simpleFormDemo.inputBox.sendKeys(string);
        simpleFormDemo.getCheckedValue.click();

        //get text and compare it to original text
        softAssert.assertEquals(simpleFormDemo.msg.getText(), string ,"Same text not displayed");
        softAssert.assertAll();
    }
   
    @Test(timeOut = 20000)
    void scenario2(){
        LandingPage landingPage=new LandingPage(driver);
        landingPage.dragAndDropSliders.click();
        DragAndDropSliders dragAndDropSliders=new DragAndDropSliders(driver);
       action.clickAndHold(dragAndDropSliders.slider).perform();
       for(int i=51;i<=95;i++){
          action.sendKeys(Keys.ARROW_RIGHT).perform();
       }
       softAssert.assertEquals(dragAndDropSliders.value.getText(), "95", "Values are not same" );
       softAssert.assertAll();
    }

    @Test(timeOut = 20000)
    void scenario3(){
        LandingPage landingPage=new LandingPage(driver);
        landingPage.inputFormSubmit.click();

        InputFormSubmit inputFormSubmit=new InputFormSubmit(driver);
        inputFormSubmit.submitBtn.click();

        //Please fill in the fields error message validation
        softAssert.assertEquals(inputFormSubmit.name.getAttribute("validationMessage"), "Please fill in the fields");
        
        inputFormSubmit.name.sendKeys("Mahendra M");
        inputFormSubmit.email.sendKeys("mahendra.testingfy@gmail.com");
        inputFormSubmit.password.sendKeys("Password@123");
        inputFormSubmit.company.sendKeys("Lambda Test");
        inputFormSubmit.websiteName.sendKeys("LambdaTest");
        
        Select dropdown=new Select(inputFormSubmit.country);
        dropdown.selectByVisibleText("United States");

        inputFormSubmit.inputCity.sendKeys("Bangalore");
        inputFormSubmit.inputAddress1.sendKeys("Bhuvaneshwari nagar");
        inputFormSubmit.inputAddress2.sendKeys("Banashankari");
        inputFormSubmit.inputState.sendKeys("Karnataka");
        inputFormSubmit.inputZip.sendKeys("560085");

        inputFormSubmit.submitBtn.click();
        softAssert.assertEquals(inputFormSubmit.successMsg.getText(), "Thanks for contacting us, we will get back to you shortly.");

        softAssert.assertAll();
    }
}
