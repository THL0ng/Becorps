import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assign_Expert_Actions {
    WebDriver driver;
    WebDriverWait explicitWait;
    WebDriverWait wait;


    public Assign_Expert_Actions(WebDriver driver) {
        this.driver = driver;
        this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));


    }


    public void Assign_Expert(String parentCss, By itemLocator) {
        driver.findElement(By.cssSelector(parentCss)).click();
        explicitWait.until(ExpectedConditions.elementToBeClickable(itemLocator)).click();
    }


    public void clickEditButton (){
        driver.findElement(Assign_Expert_Locator.clickEditButton).click();
    }


    public void clicksubmitButton (){
        driver.findElement(Assign_Expert_Locator.submitButton).click();
    }

    public void clickconfirmtButton (){
        driver.findElement(Assign_Expert_Locator.confirmButton).click();
    }






}
