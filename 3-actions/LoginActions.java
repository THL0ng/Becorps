import org.openqa.selenium.WebDriver;

public class LoginActions {
    WebDriver driver;

    public LoginActions(WebDriver driver) {
        this.driver = driver; }


    public void enterUsername(String userName) {
        driver.findElement(LoginLocators.getUsernameField()).sendKeys(userName);
    }

    public void enterPassword(String password) {
        driver.findElement(LoginLocators.getPasswordField()).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(LoginLocators.getLoginButton()).click();
    }
}
