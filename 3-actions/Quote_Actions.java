import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


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
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(Quote_Locator.requestButton, "disabled", "true")));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(Quote_Locator.requestButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", button);
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        Actions actions = new Actions(driver);
        actions.moveToElement(button).pause(Duration.ofMillis(500)).click().perform();


    }


    public void clickRequestButton2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // 1️⃣ Đợi không còn lỗi snackbar (nếu có)
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector(".mat-snack-bar-container.alert-error")));
        } catch (Exception ignored) {}

        // 2️⃣ Đợi DOM và Network ổn định
        waitForNetworkIdle(driver, 5);
        waitForDomStable(driver, 5);

        // 3️⃣ Đợi nút có thể click (refetch để tránh stale)
        WebElement button = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(Quote_Locator.requestButton)));

        // 4️⃣ Scroll vào giữa màn hình
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", button);

        // 5️⃣ Thêm đợi nhỏ để tránh animation overlay (Material/Angular hay bị)
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}

        // 6️⃣ Click thật bằng Actions để React nhận đúng event
        try {
            new Actions(driver)
                    .moveToElement(button)
                    .pause(Duration.ofMillis(300))
                    .click()
                    .perform();
        } catch (Exception e) {
            // Fallback: click bằng JS nếu Actions fail (do overlay/opacity)
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
    }

    /**
     * Đợi DOM ổn định (React/Angular render xong)
     */
    private void waitForDomStable(WebDriver driver, int timeoutSeconds) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastLength = (Long) js.executeScript("return document.body.innerHTML.length;");
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < timeoutSeconds * 1000) {
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            long currentLength = (Long) js.executeScript("return document.body.innerHTML.length;");
            if (currentLength == lastLength) {
                return; // DOM ổn định
            }
            lastLength = currentLength;
        }
    }

    /**
     * Đợi không còn request fetch/XHR đang pending
     */
    private void waitForNetworkIdle(WebDriver driver, int timeoutSeconds) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long endTime = System.currentTimeMillis() + timeoutSeconds * 1000;

        while (System.currentTimeMillis() < endTime) {
            try {
                Long activeRequests = (Long) js.executeScript(
                        "return (window.performance.getEntriesByType('resource') || [])"
                                + ".filter(r => r.initiatorType === 'fetch' || r.initiatorType === 'xmlhttprequest').length;"
                );
                if (activeRequests == 0) {
                    return; // Không còn request nào → ổn định
                }
            } catch (Exception ignored) {}
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }
    }

}


