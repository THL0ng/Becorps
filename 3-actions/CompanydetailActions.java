
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;

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

    public void submitButton() {
        driver.findElement(CompanyDetail_Locator.submitButton).click();
    }

    public void clickToDropDown(){
        driver.findElement(CompanyDetail_Locator.dropdownList).click();

    }

}