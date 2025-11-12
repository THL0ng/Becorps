import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Quote_Actions {

    WebDriver driver;


    public Quote_Actions(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCheckbox01 (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(Quote_Locator.checkbox01));
        checkbox.click();
    }


    public void selectCheckbox02 (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(Quote_Locator.checkbox02));
        checkbox.click();
    }

    public void selectCheckbox03 (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(Quote_Locator.checkbox03));
        checkbox.click();
    }

    public void selectCheckbox04 (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(Quote_Locator.checkbox04));
        checkbox.click();
    }

    public void selectCheckbox05 (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(Quote_Locator.checkbox05));
        checkbox.click();
    }


    public void clickRequestButton(){
        driver.findElement(Quote_Locator.requestButton).click();
    }

}
