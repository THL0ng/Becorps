import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class test extends Browsers {
    commons data = new commons();
    KYC_commons dataKYC = new KYC_commons();
    KYC_Team_Actions team = new KYC_Team_Actions(driver);
    KYC_JobRequest_Actions job = new KYC_JobRequest_Actions(driver);
    LoginActions actions = new LoginActions(driver);
    KYC_Companies_Actions ubo = new KYC_Companies_Actions(driver);
    CompanydetailActions companydetailActions = new CompanydetailActions(driver);


    @Test
    public void TC_01_ClickTo_KYC() {
        driver.get("https://www.staging.becorps.net/login");
        actions.enterUsername2(data.userName);
        actions.enterPassword2(data.password);
        sleepInSeconds(2);
        actions.clickLogin();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//a[contains(normalize-space(.), 'Team')]")).click();
        sleepInSeconds(2);


        driver.findElement(By.xpath("//td[.//span[contains(text(),' Expert 03 Test ')]]/parent::tr//button[@ng-reflect-message='Impersonate']")).click();

        driver.findElement(By.xpath("//p[normalize-space()='KYC Pending']")).click();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//span[contains(normalize-space(),'kycTest')]")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//div[normalize-space()='KYC/UBO']")).click();
        sleepInSeconds(2);


        String actualText = driver.findElement(By.xpath("//span[normalize-space()='Verifying']")).getText();
        Assert.assertEquals(actualText.trim(),"Verifying");
        sleepInSeconds(2);

        driver.findElement(By.xpath("//button[normalize-space()='upload_file Confirm KYC']")).click();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//span[normalize-space()='Confirm']")).click();
        sleepInSeconds(2);

        String actualText2 = driver.findElement(By.xpath("//span[normalize-space()='Confirmed']")).getText();
        Assert.assertEquals(actualText2.trim(),"Confirmed");
        sleepInSeconds(2);


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


        driver.findElement(By.xpath("//a[contains(normalize-space(.), 'Companies')]")).click();
        sleepInSeconds(2);
        Map<String, String> status = KYC_Status(driver, "Long-@@");
        Assert.assertEquals(status.get("companyStatus"), "Active");
        Assert.assertEquals(status.get("kycStatus"), "Confirmed");


    }


    public Map<String, String> KYC_Status(WebDriver driver, String companyName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement row = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//tr[contains(@class,'mat-row')]" +
                                        "[.//td[contains(@class,'mat-column-name')]//span" +
                                        "[contains(normalize-space(),'" + companyName + "')]]"
                        )
                )
        );

        String companyStatus = row
                .findElement(By.cssSelector("td.mat-column-status app-status"))
                .getText()
                .trim();

        String kycStatus = row
                .findElement(By.cssSelector("td.mat-column-kycStatus app-status"))
                .getText()
                .trim();

        Map<String, String> result = new HashMap<>();
        result.put("companyStatus", companyStatus);
        result.put("kycStatus", kycStatus);

        return result;
    }

}


