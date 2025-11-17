import org.openqa.selenium.WebDriver;


public class KYC_Dashboard_Actions {

    WebDriver driver;

    public KYC_Dashboard_Actions(WebDriver driver) {
        this.driver = driver;

    }


    public void clickKYC_Button (){
        driver.findElement(KYC_Dashboard_Locator.KYC_Pending).click();
    }

    public void clickProfile (){
        driver.findElement(KYC_Dashboard_Locator.selectProfile).click();
    }






}
