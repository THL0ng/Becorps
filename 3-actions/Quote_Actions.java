import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Quote_Actions {

    WebDriver driver;


    public Quote_Actions(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCheckbox01() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(Quote_Locator.checkbox01));
        checkbox.click();
    }


    public void selectCheckbox02() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(Quote_Locator.checkbox02));
        checkbox.click();
    }

    public void selectCheckbox03() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(Quote_Locator.checkbox03));
        checkbox.click();
    }

    public void selectCheckbox04() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(Quote_Locator.checkbox04));
        checkbox.click();
    }

    public void selectCheckbox05() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(Quote_Locator.checkbox05));
        checkbox.click();

    }


    public void clickRequestButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(Quote_Locator.requestButton));

        /*((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);*/
    }




}
