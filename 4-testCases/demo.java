import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class demo extends BaseTest {
    commons data = new commons();
    KYC_commons dataKYC = new KYC_commons();



    @Test
    public void TC_01_Assign_Expert() {
        driver.get("https://www.staging.becorps.net/login");
        KYC_JobRequest_Actions job = new KYC_JobRequest_Actions(driver);
        LoginActions actions = new LoginActions(driver);
        KYC_Companies_Actions ubo = new KYC_Companies_Actions(driver);
        KYC_CreateCompanyProfile_Actions ccp = new KYC_CreateCompanyProfile_Actions(driver);



        actions.enterUsername2(data.userName);
        waitInSeconds(2);
        actions.enterPassword2(data.password);
        waitInSeconds(2);
        actions.clickLogin();
        waitInSeconds(2);


       driver.findElement(By.xpath("//a[contains(normalize-space(.), 'Companies')]")).click();
       waitInSeconds(2);
        driver.findElement(By.xpath("//span[contains(normalize-space(),'Long539gmail.com')]")).click();

        ubo.clickKYC_UBO();
        waitInSeconds(2);
        ubo.verifyStatus_Verifying();
        waitInSeconds(2);

        ubo.clickConfirmKYC_Button();
        waitInSeconds(2);

        ubo.clickToSure_ConfirmKYC_Button();
        waitInSeconds(2);

        ubo.verifyStatus_Confirmed();
        waitInSeconds(2);

        ccp.click_createCompanyProfile_Button();
        waitInSeconds(2);


        ccp.input_registrationNo();
        waitInSeconds(2);

        ccp.setRandomExpiryDate_ofKYC(driver);
        waitInSeconds(2);

        ccp.clicktoConfirm_CreateCompanyProfile();
        waitInSeconds(2);

        ccp.Click_TobackCompanies();
        waitInSeconds(2);

        Map<String, String> status = ccp.KYC_Status(driver, "demo-test");
        Assert.assertEquals(status.get("companyStatus"), "Active");
        Assert.assertEquals(status.get("kycStatus"), "Confirmed");


    }
}
