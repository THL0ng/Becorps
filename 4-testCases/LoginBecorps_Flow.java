
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class LoginBecorps_Flow extends Browsers {
    commons data = new commons();


    @Test
    public void TC_01_Login_Success() {
        driver.get("https://www.staging.becorps.net/login");
        LoginActions actions = new LoginActions(driver);
        actions.enterUsername(data.userName);
        actions.enterPassword(data.password);
        sleepInSeconds(1);
        actions.clickLogin();
    }

    @Test
    public void TC_02_Click_Register_Company_Button() {
        RegisterCompanyActions registerAction = new RegisterCompanyActions(driver);
        sleepInSeconds(2);
        registerAction.Click_RegisterCompany_Button();
    }


    @Test
    public void TC_03_CompanyDetail_Form() {
        CompanydetailActions companydetailActions = new CompanydetailActions(driver);

        companydetailActions.enterFirstNameForm(data.firstName);

        companydetailActions.enterSecondNameForm(data.secondName);

        companydetailActions.enterThirdNameForm(data.thirdName);

        companydetailActions.enterWebsiteForm(data.website);

        companydetailActions.enterCompanyActivityForm(data.companyActivity);

        companydetailActions.verifyYourOwnAddress(true);

        companydetailActions.enterAddressCompanyForm(data.addresscompany);

        companydetailActions.enterApartmentForm(data.apartment);

        companydetailActions.enterCityForm(data.city);

        companydetailActions.enterStateForm(data.state);

        companydetailActions.enterZipcodeForm(data.zipcode);

        companydetailActions.verifyCountryForm(false);

        companydetailActions.clickRentalForm(data.rental);

        companydetailActions.uploadFile("01.png");

        companydetailActions.submitButton();


    }

    @Test
    public void TC_04_Capital_Form() {
        Capital_Actions capitalActions = new Capital_Actions(driver);

        capitalActions.enterCapitalAmountForm(data.capitalAmount);
        capitalActions.enternumberOfSharesForm(data.numberOfShares);

        capitalActions.selectItemInDropdown("mat-select[formcontrolname='currency']", "div.mat-primary mat-option", "EUR");
        capitalActions.selectItemInDropdown_2("mat-select[formcontrolname='shareTypeId']", By.xpath("//span[normalize-space()='ordinary']"));

        capitalActions.clickShareholderButton(data.addShareHolderButton);

        capitalActions.selectItemInDropdown_2("mat-select[formcontrolname='salutation']", By.xpath("//span[normalize-space()='Miss.']"));

        capitalActions.enterfirstNameShareholder(data.firstNameShareholder);
        capitalActions.enterlastNameShareholder(data.lastNameShareholder);

        capitalActions.selectItemInDropdown_2("mat-select[formcontrolname='officerIdentificationTypeId']", By.xpath("//span[normalize-space()='ID']"));

        capitalActions.enteridentificationForm(data.identification);

        capitalActions.selectItemInDropdown_2("app-country-select-input[formcontrolname='nationalityId']", By.xpath("//mat-option//span[contains(text(),'Germany')]"));

        capitalActions.setRandomExpiryDate(driver);

        capitalActions.enterEmailForm(data.email);

        //capitalActions.enterNumberPhone(data.numberPhone);

        capitalActions.enterNumberPhone("+49123456789");




    }


}
