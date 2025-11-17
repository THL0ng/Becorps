import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

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
        

        /*ubo.verifyStatus();
        sleepInSeconds(2);

        ubo.Corporate_Shareholder();
        sleepInSeconds(2);

        ubo.upload_Incorporation();
        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(3);


        ubo.upload_Association();
        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(3);

        ubo.upload_Incumbency();
        companydetailActions.uploadFileWithRobotBackup ("01.png");
        sleepInSeconds(3);*/

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
        sleepInSeconds(2);





    }





}
