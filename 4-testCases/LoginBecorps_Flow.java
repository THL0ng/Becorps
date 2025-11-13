
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.time.Duration;



public class LoginBecorps_Flow extends Browsers {
    commons data = new commons();


    @Test
    public void TC_01_Login_Success() {
        driver.get("https://www.staging.becorps.net/login");
        LoginActions actions = new LoginActions(driver);

        actions.enterUsername2(data.userName);
        sleepInSeconds(3);

        actions.enterPassword2(data.password);
        sleepInSeconds(3);
        actions.clickLogin();

    }

    @Test
    public void TC_02_Click_Register_Company_Button() {
        RegisterCompanyActions registerAction = new RegisterCompanyActions(driver);
        sleepInSeconds(3);
        registerAction.Click_RegisterCompany_Button();
    }


    @Test
    public void TC_03_CompanyDetail_Step() throws InterruptedException {
        CompanydetailActions companydetailActions = new CompanydetailActions(driver);

        companydetailActions.enterFirstNameForm2(data.firstName);
        sleepInSeconds(3);

        companydetailActions.enterSecondNameForm2(data.secondName);
        sleepInSeconds(3);

        companydetailActions.enterThirdNameForm2(data.thirdName);
        sleepInSeconds(3);

        companydetailActions.enterWebsiteForm2(data.website);
        sleepInSeconds(3);

        companydetailActions.enterCompanyActivityForm2(data.companyActivity);
        sleepInSeconds(3);

        companydetailActions.verifyYourOwnAddress(true);
        sleepInSeconds(3);

        companydetailActions.enterAddressCompanyForm2(data.addresscompany);
        sleepInSeconds(3);

        companydetailActions.enterApartmentForm2(data.apartment);
        sleepInSeconds(3);

        companydetailActions.enterCityForm2(data.city);
        sleepInSeconds(3);

        companydetailActions.enterStateForm2(data.state);
        sleepInSeconds(3);

        companydetailActions.enterZipcodeForm2(data.zipcode);
        sleepInSeconds(3);

        companydetailActions.verifyCountryForm(false);
        sleepInSeconds(3);

        companydetailActions.clickRentalForm(data.rental);
        sleepInSeconds(3);

        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(3);

        companydetailActions.submitButton();


    }

    @Test
    public void TC_04_Capital_Step() {
        Capital_Actions capitalActions = new Capital_Actions(driver);
        capitalActions.enterCapitalAmountForm2(data.capitalAmount);
        sleepInSeconds(3);
        capitalActions.enternumberOfSharesForm2(data.numberOfShares);
        sleepInSeconds(3);

        capitalActions.selectItemInDropdown("mat-select[formcontrolname='currency']", "div.mat-primary mat-option", "EUR");
        sleepInSeconds(3);
        capitalActions.selectItemInDropdown_2("mat-select[formcontrolname='shareTypeId']", By.xpath("//span[normalize-space()='ordinary']"));
        sleepInSeconds(3);

        capitalActions.clickShareholderButton(data.addShareHolderButton);
        sleepInSeconds(3);

        capitalActions.selectItemInDropdown_2("mat-select[formcontrolname='salutation']", By.xpath("//span[normalize-space()='Miss.']"));
        sleepInSeconds(3);

        capitalActions.enterfirstNameShareholder2(data.firstNameShareholder);
        sleepInSeconds(3);
        capitalActions.enterlastNameShareholder2(data.lastNameShareholder);
        sleepInSeconds(3);

        capitalActions.selectItemInDropdown_2("mat-select[formcontrolname='officerIdentificationTypeId']", By.xpath("//span[normalize-space()='ID']"));
        sleepInSeconds(3);

        capitalActions.enteridentificationForm2(data.identification);
        sleepInSeconds(3);

        capitalActions.selectItemInDropdown_2("app-country-select-input[formcontrolname='nationalityId']", By.xpath("//mat-option//span[contains(text(),'Germany')]"));
        sleepInSeconds(3);
        capitalActions.setRandomExpiryDate(driver);
        sleepInSeconds(3);
        capitalActions.enterEmailForm2(data.email);
        sleepInSeconds(3);
        capitalActions.enterNumberPhone2("+49123456789");
        sleepInSeconds(3);
        capitalActions.enterAddressLineForm2(data.addressline);
        sleepInSeconds(3);
        capitalActions.selectItemInDropdown_2("app-country-select-input#country-select-input-2", By.xpath("//mat-option//span[contains(text(),'Spain')]"));
        sleepInSeconds(3);
        capitalActions.clickAddshareDistributionButton(data.addShareDistribution);
        sleepInSeconds(3);
        driver.findElement(By.cssSelector("mat-select[formcontrolname='shareTypeId'][id=mat-select-12]")).click();
        sleepInSeconds(3);
        driver.findElement(By.className("mat-option-text")).click();
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("mat-select[formcontrolname='currency'][id=mat-select-14]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement eurOption = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//mat-option//span[normalize-space()='EUR']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eurOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eurOption);

        capitalActions.inputvalue_numberOfshares_shareholder2(data.numberShare_shareholder);
        sleepInSeconds(3);

        capitalActions.clickSaveButton(data.saveButton);
        sleepInSeconds(3);

        capitalActions.clickAddNomineeDirector(data.addNom_Button);
        sleepInSeconds(3);

        capitalActions.clickSaveButtonNextStep(data.saveButtonNextStep);
        sleepInSeconds(3);
    }

    @Test
    public void TC_05_Review_Step() {
        Review_Actions reviewActions = new Review_Actions(driver);
        reviewActions.clickToNextButtonReview();
    }

    @Test
    public void TC_06_Quote_Step() {
        Quote_Actions quote = new Quote_Actions(driver);


        quote.selectCheckbox01();
        sleepInSeconds(3);
        quote.selectCheckbox02();
        sleepInSeconds(3);
        quote.selectCheckbox03();
        sleepInSeconds(3);
        quote.selectCheckbox04();
        sleepInSeconds(3);
        quote.selectCheckbox05();

        quote.clickRequestButton();
    }

    @Test
    public void TC_07_Verify_SuperAdmin() {
        String verifyText = driver.findElement(By.xpath("//div[normalize-space(.)='Super Admin']")).getText();
        Assert.assertEquals(verifyText, "Super Admin");

    }


    @Test
    public void TC_08_Assign_Expert() {
       Assign_Expert_Actions ae = new Assign_Expert_Actions(driver);

        ae.clickEditButton();
        sleepInSeconds(3);
        ae.Assign_Expert("input[placeholder='Enter email of person']", By.xpath("//p[normalize-space()='Expert Long_01_Test']"));
        sleepInSeconds(3);

        ae.clicksubmitButton();
    }





    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

}