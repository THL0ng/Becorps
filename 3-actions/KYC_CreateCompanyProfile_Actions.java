import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class KYC_CreateCompanyProfile_Actions {
    WebDriver driver;


    public KYC_CreateCompanyProfile_Actions(WebDriver driver) {
        this.driver = driver;
    }


    public void click_createCompanyProfile_Button (){
       driver.findElement(KYC_CreateCompanyProfile_Locator.create_company_profile).click();
    }

    public void input_registrationNo (){
        driver.findElement(KYC_CreateCompanyProfile_Locator.input_Registration).sendKeys("123456");
    }


    public void setRandomExpiryDate_ofKYC(WebDriver driver) {

        // Locator của input expiryDate
        WebElement dateInput = driver.findElement(By.cssSelector("input[formcontrolname='registrationDate']"));

        // Random date range (2023 → 2030)
        long start = new Date(123, 0, 1).getTime(); // 01/01/2023
        long end = new Date(130, 11, 31).getTime(); // 31/12/2030
        long randomMillis = ThreadLocalRandom.current().nextLong(start, end);

        Date randomDate = new Date(randomMillis);

        // Định dạng dd/MM/yyyy
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(randomDate);

        // Nhập date vào input
        dateInput.clear();
        dateInput.sendKeys(formattedDate);

        // Trigger blur để Angular nhận value
        dateInput.sendKeys("\t");

        System.out.println("✅ Expiry Date set to: " + formattedDate);
    }

    public void clicktoConfirm_CreateCompanyProfile(){
        driver.findElement(KYC_CreateCompanyProfile_Locator.Confirm_createCompanyProfile).click();
    }


    public void Click_TobackCompanies(){
        driver.findElement(KYC_CreateCompanyProfile_Locator.back_to_companies).click();
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
