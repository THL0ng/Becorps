import org.openqa.selenium.By;

public class LoginLocators {
    public static By usernameField = By.id("mat-input-0");
    public static By passwordField = By.id("mat-input-1");
    public static By loginButton   = By.xpath("//button[@type='submit']");


    public static By getUsernameField() {
        return usernameField;
    }

    public static By getPasswordField() {
        return passwordField;
    }


    public static By getLoginButton() {
        return loginButton;
    }


}
