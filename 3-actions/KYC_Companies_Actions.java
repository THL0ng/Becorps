import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class KYC_Companies_Actions {

    WebDriver driver;
    KYC_commons dataKYC = new KYC_commons();
    WebDriverWait explicitWait;

    public KYC_Companies_Actions(WebDriver driver) {
        this.driver = driver;
        this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    public void clickKYC_UBO (){
        driver.findElement(KYC_Companies_Locator.KYC_UBO).click();
    }

    public void verifyStatus (){
        String actualText = driver.findElement(KYC_Companies_Locator.StatusIncomplete).getText();
        Assert.assertEquals(actualText.trim(),"Incomplete");
    }


    public void Corporate_Shareholder (){
        driver.findElement(KYC_Companies_Locator.itemsToComplete).click();
    }


    public void upload_Incorporation (){
        driver.findElement(KYC_Companies_Locator.COI).click();
    }

    public void upload_Association (){
        driver.findElement(KYC_Companies_Locator.AOA).click();
    }

    public void upload_Incumbency (){
        driver.findElement(KYC_Companies_Locator.COI2).click();
    }


    public void clickCapital_unallocated  (){
        driver.findElement(KYC_Companies_Locator.capital_unallocated).click();
    }

    public void clickAdd_button  (){
        driver.findElement(KYC_Companies_Locator.add_button).click();
    }

    public void inputFirstName(String firstName){
        driver.findElement(KYC_Companies_Locator.firstName).sendKeys(dataKYC.firstName);

    }

    public void inputLastName(String lastName){
        driver.findElement(KYC_Companies_Locator.lastName).sendKeys(dataKYC.lastName);
    }


    public void selectItemInDropdown(String parent, By itemLocator) {
        driver.findElement(By.xpath(parent)).click();
        explicitWait.until(ExpectedConditions.elementToBeClickable(itemLocator)).click();
    }

    public void inputIdenNumber (int indenNumber){
        driver.findElement(KYC_Companies_Locator.indenNumber).sendKeys(String.valueOf(dataKYC.indenNumber));
    }

    public void inputPercentage (String percentage ){
        driver.findElement(KYC_Companies_Locator.percentage).sendKeys(percentage);

    }


    public void inputPercentage_UBO (String precentage_UBO ){
        driver.findElement(KYC_Companies_Locator.percentage).clear();
        driver.findElement(KYC_Companies_Locator.percentage).sendKeys(precentage_UBO);

    }


    public void clickAddButton_Shareholder  (){
        driver.findElement(KYC_Companies_Locator.addButton_Shareholder).click();
    }

    public void clickConfirm_Button  (){
        driver.findElement(KYC_Companies_Locator.confirmButton).click();
    }


}
