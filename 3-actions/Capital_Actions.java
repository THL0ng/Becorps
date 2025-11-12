import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Capital_Actions {
    WebDriver driver;
    WebDriverWait explicitWait;
    WebDriverWait wait;

    public Capital_Actions(WebDriver driver) {
        this.driver = driver;
        this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));


    }


    public void enterCapitalAmountForm(int capitalAmount) {
        driver.findElement(Capital_Locator.capitalAmountForm).clear();
        driver.findElement(Capital_Locator.capitalAmountForm).sendKeys(String.valueOf(capitalAmount));
    }


    public void enternumberOfSharesForm(int numberOfShares) {
        driver.findElement(Capital_Locator.numberOfsharesForm).clear();
        driver.findElement(Capital_Locator.numberOfsharesForm).sendKeys(String.valueOf(numberOfShares));
    }


    public void selectItemInDropdown(String parentCss, String childItemCss, String expectedText) {
        driver.findElement(By.cssSelector(parentCss)).click();
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss))));
        for (WebElement item : allItems) {
            System.out.println(item.getText());
            if (item.getText().equals(expectedText)) {
                item.click();
                break;
            }
        }
    }


    public void selectItemInDropdown_2(String parentCss, By itemLocator) {
        driver.findElement(By.cssSelector(parentCss)).click();
        explicitWait.until(ExpectedConditions.elementToBeClickable(itemLocator)).click();
    }


    public void clickShareholderButton(String addShareHolderButton) {
        driver.findElement(Capital_Locator.addShareholderButton).click();
    }

    public void enterfirstNameShareholder(String firstNameShareholder) {
        driver.findElement(Capital_Locator.firstNameShareholder).sendKeys(firstNameShareholder);

    }

    public void enterlastNameShareholder(String lastNameShareholder) {
        driver.findElement(Capital_Locator.lastNameShareholder).sendKeys(lastNameShareholder);

    }

    public void enteridentificationForm(int identification) {
        driver.findElement(Capital_Locator.identificationForm).sendKeys(String.valueOf(identification));

    }

    public void setRandomExpiryDate(WebDriver driver) {

        // Locator của input expiryDate
        WebElement dateInput = driver.findElement(By.cssSelector("input[formcontrolname='expiryDate']"));

        // Random date range (2023 → 2030)
        long start = new Date(123, 0, 1).getTime(); // 01/01/2023
        long end = new Date(130, 11, 31).getTime(); // 31/12/2030
        long randomMillis = ThreadLocalRandom.current().nextLong(start, end);

        Date randomDate = new Date(randomMillis);

        // Định dạng dd/MM/yyyy
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(randomDate);

        // Nhập date vào input
        dateInput.clear();
        dateInput.sendKeys(formattedDate);

        // Trigger blur để Angular nhận value
        dateInput.sendKeys("\t");

        System.out.println("✅ Expiry Date set to: " + formattedDate);
    }


    public void enterEmailForm(String email) {
        driver.findElement(Capital_Locator.emailForm).sendKeys(email);
    }


    public void enterNumberPhone(String fullNumber) {
        // 1️⃣ Chờ input type="tel" xuất hiện
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[type='tel']")));

        // 2️⃣ Clear và nhập số bằng sendKeys
        phoneInput.clear();
        phoneInput.sendKeys(fullNumber);

        // 3️⃣ Fallback: dùng JS set value để chắc chắn
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", phoneInput, fullNumber);
    }


    public void enterAddressLineForm (String addressline){
        driver.findElement(Capital_Locator.addressForm).sendKeys(addressline);
    }


    public void clickAddshareDistributionButton (String addShareDistribution){
        driver.findElement(Capital_Locator.addShareDistributionButton).click();
    }

    public void inputvalue_numberOfshares_shareholder (String numberShare_shareholder ){
        driver.findElement(Capital_Locator.numberForm_Shareholder).clear();
        driver.findElement(Capital_Locator.numberForm_Shareholder).click();
        driver.findElement(Capital_Locator.numberForm_Shareholder).sendKeys(numberShare_shareholder);
    }

    public void clickSaveButton (String saveButton){
        driver.findElement(Capital_Locator.saveButtonShareholder).click();
    }

    public void clickAddNomineeDirector(String addNom_Button){
        driver.findElement(Capital_Locator.addNomineeDirector).click();
    }


    public void clickSaveButtonNextStep (String saveButtonNextStep){
        driver.findElement(Capital_Locator.nextbutton).click();
    }

}



