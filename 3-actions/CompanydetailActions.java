
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;

public class CompanydetailActions {
    WebDriver driver;


    public CompanydetailActions(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstNameForm(String firstName) {
        driver.findElement(CompanyDetail_Locator.firstNameForm).sendKeys(firstName);
    }

    public void enterSecondNameForm(String secondName) {
        driver.findElement(CompanyDetail_Locator.secondNameForm).sendKeys(secondName);
    }

    public void enterThirdNameForm(String thirdName) {
        driver.findElement(CompanyDetail_Locator.thirdNameForm).sendKeys(thirdName);
    }

    public void enterWebsiteForm(String website) {
        driver.findElement(CompanyDetail_Locator.websiteForm).sendKeys(website);
    }

    public void enterCompanyActivityForm(String companyActivity) {
        driver.findElement(CompanyDetail_Locator.companyActivityForm).sendKeys(companyActivity);
    }

    public void verifyYourOwnAddress(boolean yourOwnAddress) {
        Assert.assertTrue(driver.findElement(CompanyDetail_Locator.yourOwnAddress).isDisplayed(),
                "Use your own address in Hong Kong");
    }


    public void enterAddressCompanyForm(String addresscompany) {
        driver.findElement(CompanyDetail_Locator.addressCompanyForm).sendKeys(addresscompany);
    }

    public void enterApartmentForm(String apartment) {
        driver.findElement(CompanyDetail_Locator.apartmentForm).sendKeys(apartment);
    }

    public void enterCityForm(String city) {
        driver.findElement(CompanyDetail_Locator.cityForm).sendKeys(city);
    }

    public void enterStateForm(String state) {
        driver.findElement(CompanyDetail_Locator.stateForm).sendKeys(state);
    }

    public void enterZipcodeForm(String zipcode) {
        driver.findElement(CompanyDetail_Locator.zipCodeForm).sendKeys(zipcode);
    }

    public void verifyCountryForm(boolean country_region) {
        Assert.assertFalse(driver.findElement(CompanyDetail_Locator.countryForm).isEnabled(), "Can not click on this form");
    }

    public void clickRentalForm(String rental) {
        driver.findElement(CompanyDetail_Locator.rentalForm).click();
    }

    public String getFilePath(String fileName) {
        String projectPath = System.getProperty("user.dir");
        return projectPath + File.separator + "6-uploadFiles" + File.separator + fileName;
    }

    public void uploadFile(String fileName) {
        String filePath = getFilePath(fileName);
        driver.findElement(CompanyDetail_Locator.uploadFile).sendKeys(filePath);
    }


    public void uploadFileDirectly(String fileName) {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + File.separator + "6-uploadFiles" + File.separator + fileName;

        // Verify file tồn tại
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("File không tồn tại: " + filePath);
        }

        System.out.println("Uploading file: " + filePath);

        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Remove tất cả event listeners có thể trigger popup
        js.executeScript(
                "var input = arguments[0];" +
                        "var parent = input.parentNode;" +
                        "var newInput = input.cloneNode(true);" +
                        "parent.replaceChild(newInput, input);" +
                        "newInput.style.cssText = 'display:block!important; visibility:visible!important; opacity:1!important; position:relative!important;';" +
                        "return newInput;",
                fileInput
        );

        // Tìm lại element mới
        fileInput = driver.findElement(By.cssSelector("input[type='file']"));

        sleepInSecond(1);

        // SendKeys - TUYỆT ĐỐI KHÔNG click() trước đó
        fileInput.sendKeys(filePath);

        sleepInSecond(2);

        System.out.println("File uploaded successfully!");
    }

    /**
     * Backup method: Xử lý popup nếu nó vẫn xuất hiện
     */
    public void uploadFileWithRobotBackup(String fileName) {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + File.separator + "6-uploadFiles" + File.separator + fileName;

        try {
            // Nếu popup đã mở, xử lý bằng Robot
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            Robot robot = new Robot();
            robot.delay(1000);

            // Ctrl + V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.delay(500);

            // Enter
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.delay(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sleepInSecond(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }










    public void submitButton() {
        driver.findElement(CompanyDetail_Locator.submitButton).click();
    }

    public void clickToDropDown(){
        driver.findElement(CompanyDetail_Locator.dropdownList).click();

    }

}