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
        waitInSeconds(2);
        actions.enterPassword2(data.password);
        waitInSeconds(2);
        actions.clickLogin();
        waitInSeconds(2);

        job.clickJobRequestButton();
        waitInSeconds(2);        

        job.clickProfile();
        waitInSeconds(2);        

        job.clickEditButton();
        waitInSeconds(2);        

        job.Assign_Expert("input[placeholder='Enter email of person']", By.xpath("//p[normalize-space()='Expert Long_01_Test']"));
        waitInSeconds(2);        

        job.clicksubmitButton();
        waitInSeconds(2);        

        job.clickconfirmtButton();
        waitInSeconds(2);

    }

    @Test
    public void TC_02_Change_Role_Expert() {
        KYC_Team_Actions team = new KYC_Team_Actions(driver);
        team.clickCompanies();
        waitInSeconds(2);
        team.clickImpersonate();
        waitInSeconds(2);
        team.verifyChangeRole();
        waitInSeconds(2);

    }


    @Test
    public void TC_03_KYC_selectProfile() {
        KYC_Dashboard_Actions dash = new KYC_Dashboard_Actions(driver);
        dash.clickKYC_Button();
        waitInSeconds(2);
        dash.clickProfile();
        waitInSeconds(2);

    }


    @Test
    public void TC_04_KYC_UploadFiles() {
        KYC_Companies_Actions ubo = new KYC_Companies_Actions(driver);
        CompanydetailActions companydetailActions = new CompanydetailActions(driver);

        ubo.clickKYC_UBO();
        waitInSeconds(2);
        ubo.verifyStatus_Incomplete();
        waitInSeconds(2);


        ubo.Corporate_Shareholder();
        waitInSeconds(5);
        ubo.clickUploadButton("CERTIFICATE_OF_INCORPORATION");

        companydetailActions.uploadFileWithRobotBackup("01.png");
        waitInSeconds(5);

        ubo.Corporate_Shareholder();
        waitInSeconds(5);
        ubo.clickUploadButton("ARTICLES_OF_ASSOCIATION");
        companydetailActions.uploadFileWithRobotBackup("01.png");
        waitInSeconds(5);

        ubo.Corporate_Shareholder();
        waitInSeconds(5);
        ubo.clickUploadButton("CERTIFICATE_OF_INCUMBENCY");
        companydetailActions.uploadFileWithRobotBackup("01.png");
        waitInSeconds(5);

        ubo.clickCapital_unallocated();
        waitInSeconds(5);
        ubo.clickAdd_button();
        waitInSeconds(5);

        ubo.inputFirstName(dataKYC.firstName);
        waitInSeconds(5);

        ubo.inputLastName(dataKYC.lastName);
        waitInSeconds(5);
        ubo.selectItemInDropdown("//mat-label[normalize-space()='Nationality']/ancestor::mat-form-field", By.xpath("//mat-option//span[contains(text(),'France')]"));
        waitInSeconds(5);

        ubo.selectItemInDropdown("//mat-label[normalize-space()='Residence']/ancestor::mat-form-field", By.xpath("//mat-option//span[contains(text(),'Canada')]"));
        waitInSeconds(5);

        ubo.selectItemInDropdown("//mat-label[normalize-space()='Identification Document']/ancestor::mat-form-field", By.xpath("//span[normalize-space()='FIN']"));
        waitInSeconds(5);
        ubo.inputIdenNumber(dataKYC.indenNumber);
        waitInSeconds(5);
        ubo.inputPercentage(dataKYC.percentage);
        waitInSeconds(5);
        ubo.clickAddButton_Shareholder();
        waitInSeconds(5);
        ubo.clickConfirm_Button();
        waitInSeconds(5);

        /// /////////////////////////////////


        ubo.clickCapital_unallocated();
        waitInSeconds(5);
        ubo.clickAdd_button();
        waitInSeconds(5);

        ubo.inputFirstName(dataKYC.firstName);
        waitInSeconds(5);

        ubo.inputLastName(dataKYC.lastName);
        waitInSeconds(5);
        ubo.selectItemInDropdown("//mat-label[normalize-space()='Nationality']/ancestor::mat-form-field", By.xpath("//mat-option//span[contains(text(),'Monaco')]"));
        waitInSeconds(5);

        ubo.selectItemInDropdown("//mat-label[normalize-space()='Residence']/ancestor::mat-form-field", By.xpath("//mat-option//span[contains(text(),'Qatar')]"));
        waitInSeconds(5);

        ubo.selectItemInDropdown("//mat-label[normalize-space()='Identification Document']/ancestor::mat-form-field", By.xpath("//span[normalize-space()='ID']"));
        waitInSeconds(5);
        ubo.inputIdenNumber(dataKYC.indenNumber);
        waitInSeconds(5);
        ubo.inputPercentage_UBO(dataKYC.percentage_UBO);
        waitInSeconds(5);
        ubo.clickAddButton_Shareholder();
        waitInSeconds(5);
        ubo.clickConfirm_Button();
        ubo.waitAndRefresh(5);


    }


    @Test
    public void TC_05_KYC_UploadFiles_2() {
        KYC_Companies_Actions ubo = new KYC_Companies_Actions(driver);
        CompanydetailActions companydetailActions = new CompanydetailActions(driver);

        ubo.clickKYC_UBO();
        waitInSeconds(2);

        ubo.clickIndividual_LongLayer1();
        waitInSeconds(5);
        ubo.clickUploadButton_ForLongLayer("PASSPORT");
        companydetailActions.uploadFileWithRobotBackup("01.png");
        waitInSeconds(5);


        ubo.clickIndividual_LongLayer1();
        waitInSeconds(5);
        ubo.clickUploadProofOfAddressForLongLayer1();
        companydetailActions.uploadFileWithRobotBackup("01.png");
        waitInSeconds(5);


        ubo.clickIndividual_DrakeLayer1();
        waitInSeconds(5);
        ubo.clickUploadPassport_ForDrakeLayer1();
        companydetailActions.uploadFileWithRobotBackup("01.png");
        waitInSeconds(5);

        ubo.clickIndividual_DrakeLayer1();
        waitInSeconds(5);
        ubo.clickUploadProofOfAddress_ForDrakeLayer1();
        companydetailActions.uploadFileWithRobotBackup("01.png");


        ubo.waitAndRefresh(5);

    }
    @Test
    public void TC_06_KYC_UploadFiles_3 () {
        KYC_Companies_Actions ubo = new KYC_Companies_Actions(driver);
        CompanydetailActions companydetailActions = new CompanydetailActions(driver);

        ubo.clickKYC_UBO();
        waitInSeconds(2);

        ubo.clickDirector_Long();
        waitInSeconds(5);
        ubo.clickUploadPassport_ForDirector();
        companydetailActions.uploadFileWithRobotBackup("01.png");
        waitInSeconds(5);

        ubo.clickDirector_Long();
        waitInSeconds(5);
        ubo.clickUploadProofOfAddress_ForDirector();
        companydetailActions.uploadFileWithRobotBackup("01.png");
        waitInSeconds(5);

        ubo.clickLongAuto_KYCFlow();
        waitInSeconds(5);
        ubo.clickUploadPassport_ForLongKYC_Flow();
        companydetailActions.uploadFileWithRobotBackup("01.png");
        waitInSeconds(5);


        ubo.clickLongAuto_KYCFlow();
        waitInSeconds(5);
        ubo.clickUploadProofOfAddress_ForLongKYC_Flow();
        companydetailActions.uploadFileWithRobotBackup("01.png");

        ubo.waitAndRefresh(5);

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

        }



        @Test
        public void TC_07_Create_Company_Profile () {
            KYC_CreateCompanyProfile_Actions ccp = new KYC_CreateCompanyProfile_Actions(driver);

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

            Map<String, String> status = ccp.KYC_Status(driver, "Long");
            Assert.assertEquals(status.get("companyStatus"), "Active");
            Assert.assertEquals(status.get("kycStatus"), "Confirmed");

        }

    }

