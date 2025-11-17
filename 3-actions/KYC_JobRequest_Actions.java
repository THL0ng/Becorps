import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KYC_JobRequest_Actions {

    WebDriver driver;
    WebDriverWait explicitWait;


    public KYC_JobRequest_Actions(WebDriver driver) {
        this.driver = driver;
        this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    public void clickJobRequestButton (){
        driver.findElement(KYC_JobRequest_Locator.JobRequest).click();
    }


    public void clickProfile (){
        driver.findElement(KYC_JobRequest_Locator.selectProfile).click();
    }

    public void clickEditButton (){
        driver.findElement(KYC_JobRequest_Locator.editButton).click();
    }

    public void Assign_Expert(String parentCss, By itemLocator) {
        driver.findElement(By.cssSelector(parentCss)).click();
        explicitWait.until(ExpectedConditions.elementToBeClickable(itemLocator)).click();
    }

    public void clicksubmitButton (){
        driver.findElement(KYC_JobRequest_Locator.submitButton).click();
    }

    public void clickconfirmtButton (){
        driver.findElement(KYC_JobRequest_Locator.confirmButton).click();
    }



}
