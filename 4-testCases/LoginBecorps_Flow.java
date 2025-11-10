import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

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
        sleepInSeconds(1);
        companydetailActions.enterSecondNameForm(data.secondName);
        sleepInSeconds(1);
        companydetailActions.enterThirdNameForm(data.thirdName);
        sleepInSeconds(1);
        companydetailActions.enterWebsiteForm(data.website);
        sleepInSeconds(1);
        companydetailActions.enterCompanyActivityForm(data.companyActivity);
        sleepInSeconds(1);
        companydetailActions.verifyYourOwnAddress(true);
        sleepInSeconds(1);
        companydetailActions.enterAddressCompanyForm(data.addresscompany);
        sleepInSeconds(1);
        companydetailActions.enterApartmentForm(data.apartment);
        sleepInSeconds(1);
        companydetailActions.enterCityForm(data.city);
        sleepInSeconds(1);
        companydetailActions.enterStateForm(data.state);
        sleepInSeconds(1);
        companydetailActions.enterZipcodeForm(data.zipcode);
        sleepInSeconds(1);
        companydetailActions.verifyCountryForm(false);
        sleepInSeconds(1);
        companydetailActions.clickRentalForm(data.rental);
        sleepInSeconds(1);

        companydetailActions.uploadFile("01.png");

        companydetailActions.submitButton();

    }









}
