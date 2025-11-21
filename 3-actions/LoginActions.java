import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginActions {
    WebDriver driver;

    public LoginActions(WebDriver driver) {
        this.driver = driver; }


    public void enterUsername(String userName) {
        driver.findElement(LoginLocators.usernameField).sendKeys(userName);
    }

    public void enterPassword(String password) {
        driver.findElement(LoginLocators.getPasswordField()).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(LoginLocators.getLoginButton()).click();
    }



    /// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void enterUsername2(String userName) {
        WebElement input = driver.findElement(LoginLocators.getUsernameField());
        input.clear();
        input.sendKeys(userName);
        input.sendKeys(Keys.TAB);
    }

    public void enterPassword2(String password) {
        WebElement input = driver.findElement(LoginLocators.getPasswordField());
        input.clear();
        input.sendKeys(password);
        input.sendKeys(Keys.TAB);
    }


}
