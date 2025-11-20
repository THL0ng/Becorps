import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.bouncycastle.asn1.x509.Target.targetName;

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


    public void clickNextPage(int times) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By nextPageIcon = By.xpath(
                "//*[local-name()='path' and contains(@d, 'M10 6L8.59 7.41 13.17 12l-4.58')]"
        );

        for (int i = 0; i < times; i++) {
            WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(nextPageIcon));

            // Click button chứa SVG path
            WebElement btn = icon.findElement(By.xpath("./ancestor::button"));
            btn.click();

            // Wait data reload (Angular Material Table)
            wait.until(ExpectedConditions.stalenessOf(icon));  // đợi icon refresh DOM
        }
    }


}
