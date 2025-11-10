import org.openqa.selenium.By;

public class LoginLocators {
    public static By usernameField = By.id("mat-input-0");
    public static By passwordField = By.id("mat-input-1");
    public static By loginButton   = By.xpath("//button[@type='submit']");


    public static By getUsernameField() {
        return usernameField;
    }

    public static void setUsernameField(By usernameField) {
        LoginLocators.usernameField = usernameField;
    }

    public static By getPasswordField() {
        return passwordField;
    }

    public static void setPasswordField(By passwordField) {
        LoginLocators.passwordField = passwordField;
    }

    public static By getLoginButton() {
        return loginButton;
    }

    public static void setLoginButton(By loginButton) {
        LoginLocators.loginButton = loginButton;
    }
}
