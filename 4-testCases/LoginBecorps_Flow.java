
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.time.Duration;



public class LoginBecorps_Flow extends BaseTest {
    commons data = new commons();


    @Test
    public void TC_01_Login_Success() {
        driver.get("https://www.staging.becorps.net/login");
        LoginActions actions = new LoginActions(driver);

        actions.enterUsername2(data.userName);

        actions.enterPassword2(data.password);
        
        actions.clickLogin();

    }

    @Test
    public void TC_02_Click_Register_Company_Button() {
        RegisterCompanyActions registerAction = new RegisterCompanyActions(driver);
   
        registerAction.Click_RegisterCompany_Button();
    }


    @Test
    public void TC_03_CompanyDetail_Step() throws InterruptedException {
        CompanydetailActions companydetailActions = new CompanydetailActions(driver);

        companydetailActions.enterFirstNameForm2(data.firstName);
       

        companydetailActions.enterSecondNameForm2(data.secondName);
        

        companydetailActions.enterThirdNameForm2(data.thirdName);
        

        companydetailActions.enterWebsiteForm2(data.website);
        

        companydetailActions.enterCompanyActivityForm2(data.companyActivity);
        

        companydetailActions.verifyYourOwnAddress(true);
        

        companydetailActions.enterAddressCompanyForm2(data.addresscompany);
        

        companydetailActions.enterApartmentForm2(data.apartment);
        

        companydetailActions.enterCityForm2(data.city);
        

        companydetailActions.enterStateForm2(data.state);
        

        companydetailActions.enterZipcodeForm2(data.zipcode);
        

        companydetailActions.verifyCountryForm(false);
        

        companydetailActions.clickRentalForm(data.rental);
        

        companydetailActions.uploadFileWithRobotBackup ("01.png");
        

        companydetailActions.submitButton();


    }

    @Test
    public void TC_04_Capital_Step() {
        Capital_Actions capitalActions = new Capital_Actions(driver);
        capitalActions.enterCapitalAmountForm2(data.capitalAmount);
        
        capitalActions.enternumberOfSharesForm2(data.numberOfShares);
        

        capitalActions.selectItemInDropdown("mat-select[formcontrolname='currency']", "div.mat-primary mat-option", "EUR");
        
        capitalActions.selectItemInDropdown_2("mat-select[formcontrolname='shareTypeId']", By.xpath("//span[normalize-space()='ordinary']"));
        

        capitalActions.clickShareholderButton(data.addShareHolderButton);
        

        capitalActions.selectItemInDropdown_2("mat-select[formcontrolname='salutation']", By.xpath("//span[normalize-space()='Miss.']"));
        

        capitalActions.enterfirstNameShareholder2(data.firstNameShareholder);
        
        capitalActions.enterlastNameShareholder2(data.lastNameShareholder);
        

        capitalActions.selectItemInDropdown_2("mat-select[formcontrolname='officerIdentificationTypeId']", By.xpath("//span[normalize-space()='ID']"));
        

        capitalActions.enteridentificationForm2(data.identification);
        

        capitalActions.selectItemInDropdown_2("app-country-select-input[formcontrolname='nationalityId']", By.xpath("//mat-option//span[contains(text(),'Germany')]"));
        
        capitalActions.setRandomExpiryDate(driver);
        
        capitalActions.enterEmailForm2(data.email);
        
        capitalActions.enterNumberPhone2("+49123456789");
        
        capitalActions.enterAddressLineForm2(data.addressline);
        
        capitalActions.selectItemInDropdown_2("app-country-select-input#country-select-input-2", By.xpath("//mat-option//span[contains(text(),'Spain')]"));
        
        capitalActions.clickAddshareDistributionButton(data.addShareDistribution);
        
        driver.findElement(By.cssSelector("mat-select[formcontrolname='shareTypeId'][id=mat-select-12]")).click();
        
        driver.findElement(By.className("mat-option-text")).click();
        

        driver.findElement(By.cssSelector("mat-select[formcontrolname='currency'][id=mat-select-14]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement eurOption = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//mat-option//span[normalize-space()='EUR']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eurOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eurOption);

        capitalActions.inputvalue_numberOfshares_shareholder2(data.numberShare_shareholder);
        

        capitalActions.clickSaveButton(data.saveButton);
        

        capitalActions.clickAddNomineeDirector(data.addNom_Button);
        

        capitalActions.clickSaveButtonNextStep(data.saveButtonNextStep);
        
    }

    @Test
    public void TC_05_Review_Step() {
        Review_Actions reviewActions = new Review_Actions(driver);
        reviewActions.clickToNextButtonReview();
    }

    @Test
    public void TC_06_Quote_Step() {
        Quote_Actions quote = new Quote_Actions(driver);


        /*quote.selectCheckbox01();
        
        quote.selectCheckbox02();
        
        quote.selectCheckbox03();
        
        quote.selectCheckbox04();
        
        quote.selectCheckbox05();*/

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
        

        ae.Assign_Expert("input[placeholder='Enter email of person']", By.xpath("//p[normalize-space()='Expert Long_01_Test']"));
        

        ae.clicksubmitButton();


        ae.clickconfirmtButton();

    }





    @AfterClass
    public void endFlow() {
        //driver.quit();
    }

}