package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class User_01_Regisgter_Login {

    WebDriver driver;

    @BeforeClass
    public void beforceClass(){
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void TC_01_Register(){

    }

    @Test
    public void TC_02_Login(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();



    }

}
