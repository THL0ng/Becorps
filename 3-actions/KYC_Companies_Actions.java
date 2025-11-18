import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void verifyStatus_Incomplete (){
        String actualText = driver.findElement(KYC_Companies_Locator.StatusIncomplete).getText();
        Assert.assertEquals(actualText.trim(),"Incomplete");
    }


    public void Corporate_Shareholder (){
        driver.findElement(KYC_Companies_Locator.itemsToComplete).click();
    }



    public void clickUploadButton(String docText) {
        String xpath = "//p[normalize-space()='" + docText + "']" +
                "/ancestor::div[contains(@class,'w-[85%]')]" +
                "/following-sibling::div[contains(@class,'w-[15%]')]//button";

        driver.findElement(By.xpath(xpath)).click();
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


    public void clickUploadButton_ForLongLayer(String docText) {
        String xpath = "//p[normalize-space()='" + docText + "']" +
                "/ancestor::div[contains(@class,'w-[85%]')]" +
                "/following-sibling::div[contains(@class,'w-[15%]')]//button";

        driver.findElement(By.xpath(xpath)).click();
    }


    public void clickUploadProofOfAddressForLongLayer1() {
        String xpath = "//mat-expansion-panel[.//*[contains(normalize-space(),'Long Individual_ Layer1')]]"
                + "//p[normalize-space()='PROOF_OF_ADDRESS']"
                + "/ancestor::section[contains(@class,'officers-container')]"
                + "//div[contains(@class,'w-[15%]')]//button";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        btn.click();
    }


    public void clickUploadPassport_ForDrakeLayer1() {
        String xpath = "//mat-expansion-panel[.//*[contains(normalize-space(),'Drake Individual_ Layer1')]]"
                + "//p[normalize-space()='PASSPORT']"
                + "/ancestor::section[contains(@class,'officers-container')]"
                + "//div[contains(@class,'w-[15%]')]//button";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        btn.click();
    }


    public void clickUploadProofOfAddress_ForDrakeLayer1() {
        String xpath = "//mat-expansion-panel[.//*[contains(normalize-space(),'Drake Individual_ Layer1')]]"
                + "//p[normalize-space()='PROOF_OF_ADDRESS']"
                + "/ancestor::section[contains(@class,'officers-container')]"
                + "//div[contains(@class,'w-[15%]')]//button";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        btn.click();
    }



    public void clickUploadPassport_ForDirector() {
        String xpath = "//mat-expansion-panel[.//*[contains(normalize-space(),'Nominee _ Long')]]"
                + "//p[normalize-space()='PASSPORT']"
                + "/ancestor::section[contains(@class,'officers-container')]"
                + "//div[contains(@class,'w-[15%]')]//button";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        btn.click();
    }

    public void clickUploadProofOfAddress_ForDirector() {
        String xpath = "//mat-expansion-panel[.//*[contains(normalize-space(),'Nominee _ Long')]]"
                + "//p[normalize-space()='PROOF_OF_ADDRESS']"
                + "/ancestor::section[contains(@class,'officers-container')]"
                + "//div[contains(@class,'w-[15%]')]//button";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        btn.click();
    }



    public void clickUploadPassport_ForLongKYC_Flow() {
        String xpath = "//mat-expansion-panel[.//*[contains(normalize-space(),'Nominee _ Long')]]"
                + "//p[normalize-space()='PASSPORT']"
                + "/ancestor::section[contains(@class,'officers-container')]"
                + "//div[contains(@class,'w-[15%]')]//button";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        btn.click();
    }

    public void clickUploadProofOfAddress_ForLongKYC_Flow() {
        String xpath = "//mat-expansion-panel[.//*[contains(normalize-space(),'Nominee _ Long')]]"
                + "//p[normalize-space()='PROOF_OF_ADDRESS']"
                + "/ancestor::section[contains(@class,'officers-container')]"
                + "//div[contains(@class,'w-[15%]')]//button";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        btn.click();
    }

    public void clickIndividual_LongLayer1(){
        driver.findElement(KYC_Companies_Locator.LongIndividual_Layer1).click();
    }

    public void clickIndividual_DrakeLayer1(){
        driver.findElement(KYC_Companies_Locator.DrakeIndividual_Layer1).click();
    }


    public void clickDirector_Long(){
        driver.findElement(KYC_Companies_Locator.Nominee_Long).click();
    }

    public void clickLongAuto_KYCFlow(){
        driver.findElement(KYC_Companies_Locator.LongKYC_Flow).click();
    }


    public void verifyStatus_Verifying (){
        String actualText = driver.findElement(KYC_Companies_Locator.statusVerifying).getText();
        Assert.assertEquals(actualText.trim(),"Verifying");
    }

    public void clickConfirmKYC_Button(){
        driver.findElement(KYC_Companies_Locator.confirmKYC).click();
    }

    public void clickToSure_ConfirmKYC_Button(){
        driver.findElement(KYC_Companies_Locator.Sure_confirmKYC).click();
    }


    public void verifyStatus_Confirmed (){
        String actualText = driver.findElement(KYC_Companies_Locator.done_uploadfiles_KYC).getText();
        Assert.assertEquals(actualText.trim(),"Confirmed");
    }



}
