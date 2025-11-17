import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class KYC_Team_Actions {
    WebDriver driver;

    public KYC_Team_Actions(WebDriver driver) {
        this.driver = driver;

    }


    public void clickCompanies (){
        driver.findElement(KYC_Team_Locator.Companies).click();

    }


    public void clickImpersonate (){
        driver.findElement(KYC_Team_Locator.Impersonate).click();

    }

    public void verifyChangeRole (){
        String actualText = driver.findElement(KYC_Team_Locator.verifyText).getText();
        Assert.assertEquals(actualText.trim(), "stop impersonate");

    }







}
