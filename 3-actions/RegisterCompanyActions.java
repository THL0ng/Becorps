import org.openqa.selenium.WebDriver;

public class RegisterCompanyActions {
    WebDriver driver;

    public RegisterCompanyActions(WebDriver driver) {
        this.driver = driver;
    }

    public void Click_RegisterCompany_Button() {
        driver.findElement(RegisterCompanyLocators.getRegisterCompanyButton()).click();
    }
}
