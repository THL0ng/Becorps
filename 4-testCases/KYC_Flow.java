import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class KYC_Flow extends Browsers {
    commons data = new commons();
    KYC_commons dataKYC = new KYC_commons();




    @Test
    public void TC_01_Assign_Expert() {
        driver.get("https://www.staging.becorps.net/login");
        KYC_JobRequest_Actions job = new KYC_JobRequest_Actions(driver);
        LoginActions actions = new LoginActions(driver);

        actions.enterUsername2(data.userName);
        sleepInSeconds(2);
        
        actions.enterPassword2(data.password);
        sleepInSeconds(2);
        actions.clickLogin();
        sleepInSeconds(2);


        job.clickJobRequestButton();
        sleepInSeconds(2);
        

        job.clickProfile();
        sleepInSeconds(2);
        

        job.clickEditButton();
        sleepInSeconds(2);
        

        job.Assign_Expert("input[placeholder='Enter email of person']", By.xpath("//p[normalize-space()='Expert Long_01_Test']"));
        sleepInSeconds(2);
        

        job.clicksubmitButton();
        sleepInSeconds(2);
        

        job.clickconfirmtButton();
        sleepInSeconds(2);
        

    }

    @Test
    public void TC_02_Change_Role_Expert() {
        KYC_Team_Actions team = new KYC_Team_Actions(driver);
        team.clickCompanies();
        sleepInSeconds(2);
        
        team.clickImpersonate();
        sleepInSeconds(2);
        
        team.verifyChangeRole();
        sleepInSeconds(2);
        

    }


    @Test
    public void TC_03_KYC_selectProfile() {
        KYC_Dashboard_Actions dash = new KYC_Dashboard_Actions(driver);
        dash.clickKYC_Button();
        sleepInSeconds(2);
        
        dash.clickProfile();
        sleepInSeconds(2);
        

    }



    @Test
    public void TC_04_KYC_UploadFiles() {
        KYC_Companies_Actions ubo = new KYC_Companies_Actions(driver);
        CompanydetailActions companydetailActions = new CompanydetailActions(driver);

        ubo.clickKYC_UBO();
        sleepInSeconds(2);
        ubo.verifyStatus_Incomplete();
        sleepInSeconds(2);



        ubo.Corporate_Shareholder();
        sleepInSeconds(2);
        ubo.clickUploadButton("CERTIFICATE_OF_INCORPORATION");
        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(5);

        ubo.Corporate_Shareholder();
        sleepInSeconds(2);
        ubo.clickUploadButton("ARTICLES_OF_ASSOCIATION");
        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(5);

        ubo.Corporate_Shareholder();
        sleepInSeconds(2);
        ubo.clickUploadButton("CERTIFICATE_OF_INCUMBENCY");
        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(5);

        ubo.clickCapital_unallocated();
        sleepInSeconds(2);

        ubo.clickAdd_button();
        sleepInSeconds(2);


        ubo.inputFirstName(dataKYC.firstName);
        sleepInSeconds(2);


        ubo.inputLastName(dataKYC.lastName);
        sleepInSeconds(2);

        ubo.selectItemInDropdown("//mat-label[normalize-space()='Nationality']/ancestor::mat-form-field", By.xpath("//mat-option//span[contains(text(),'France')]"));
        sleepInSeconds(2);


        ubo.selectItemInDropdown("//mat-label[normalize-space()='Residence']/ancestor::mat-form-field", By.xpath("//mat-option//span[contains(text(),'Canada')]"));
        sleepInSeconds(2);


        ubo.selectItemInDropdown("//mat-label[normalize-space()='Identification Document']/ancestor::mat-form-field", By.xpath("//span[normalize-space()='FIN']"));
        sleepInSeconds(2);

        ubo.inputIdenNumber(dataKYC.indenNumber);
        sleepInSeconds(2);

        ubo.inputPercentage(dataKYC.percentage);
        sleepInSeconds(2);

        ubo.clickAddButton_Shareholder();
        sleepInSeconds(2);

        ubo.clickConfirm_Button();
        sleepInSeconds(5);

        /// /////////////////////////////////


        ubo.clickCapital_unallocated();
        sleepInSeconds(2);

        ubo.clickAdd_button();
        sleepInSeconds(2);


        ubo.inputFirstName(dataKYC.firstName);
        sleepInSeconds(2);


        ubo.inputLastName(dataKYC.lastName);
        sleepInSeconds(2);

        ubo.selectItemInDropdown("//mat-label[normalize-space()='Nationality']/ancestor::mat-form-field", By.xpath("//mat-option//span[contains(text(),'Monaco')]"));
        sleepInSeconds(2);


        ubo.selectItemInDropdown("//mat-label[normalize-space()='Residence']/ancestor::mat-form-field", By.xpath("//mat-option//span[contains(text(),'Qatar')]"));
        sleepInSeconds(2);


        ubo.selectItemInDropdown("//mat-label[normalize-space()='Identification Document']/ancestor::mat-form-field", By.xpath("//span[normalize-space()='ID']"));
        sleepInSeconds(2);

        ubo.inputIdenNumber(dataKYC.indenNumber);
        sleepInSeconds(2);

        ubo.inputPercentage_UBO(dataKYC.percentage_UBO);
        sleepInSeconds(2);

        ubo.clickAddButton_Shareholder();
        sleepInSeconds(2);

        ubo.clickConfirm_Button();
        sleepInSeconds(5);

    }


    @Test
    public void TC_05_KYC_UploadFiles_2() {
        KYC_Companies_Actions ubo = new KYC_Companies_Actions(driver);
        CompanydetailActions companydetailActions = new CompanydetailActions(driver);

        ubo.clickIndividual_LongLayer1();
        sleepInSeconds(5);
        ubo.clickUploadButton_ForLongLayer("PASSPORT");
        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(5);


        ubo.clickIndividual_LongLayer1();
        sleepInSeconds(5);
        ubo.clickUploadProofOfAddressForLongLayer1();
        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(5);


        ubo.clickIndividual_DrakeLayer1();
        sleepInSeconds(5);
        ubo.clickUploadPassport_ForDrakeLayer1();
        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(5);

        ubo.clickIndividual_DrakeLayer1();
        sleepInSeconds(5);
        ubo.clickUploadProofOfAddress_ForDrakeLayer1();
        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(5);

        ubo.clickDirector_Long();
        sleepInSeconds(5);
        ubo.clickUploadPassport_ForDirector();
        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(5);

        ubo.clickDirector_Long();
        sleepInSeconds(5);
        ubo.clickUploadProofOfAddress_ForDirector();
        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(5);

        ubo.clickLongAuto_KYCFlow();
        sleepInSeconds(5);
        ubo.clickUploadPassport_ForLongKYC_Flow();
        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(5);


        ubo.clickLongAuto_KYCFlow();
        sleepInSeconds(5);
        ubo.clickUploadProofOfAddress_ForLongKYC_Flow();
        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(5);


        ubo.verifyStatus_Verifying();
        sleepInSeconds(1);

        ubo.clickConfirmKYC_Button();
        sleepInSeconds(1);

        ubo.clickToSure_ConfirmKYC_Button();
        sleepInSeconds(1);

        ubo.verifyStatus_Confirmed();
        sleepInSeconds(1);

    }


    @Test
    public void TC_06_Create_Company_Profile(){
        KYC_CreateCompanyProfile_Actions ccp = new KYC_CreateCompanyProfile_Actions(driver);

        ccp.click_createCompanyProfile_Button();
        sleepInSeconds(1);


        ccp.input_registrationNo();
        sleepInSeconds(1);

        ccp.setRandomExpiryDate_ofKYC(driver);
        sleepInSeconds(1);

        ccp.clicktoConfirm_CreateCompanyProfile();
        sleepInSeconds(1);

        ccp.Click_TobackCompanies();
        sleepInSeconds(1);

        Map<String, String> status = ccp.KYC_Status(driver, "Long");
        Assert.assertEquals(status.get("companyStatus"), "Active");
        Assert.assertEquals(status.get("kycStatus"), "Confirmed");

    }





}