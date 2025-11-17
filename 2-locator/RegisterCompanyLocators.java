import org.openqa.selenium.By;

public class RegisterCompanyLocators {
        public static By registerCompanyButton   = By.xpath("//a[contains(normalize-space(.), 'Register Company')]");

    public static By getRegisterCompanyButton() {
        return registerCompanyButton;
    }

    public static void setRegisterCompanyButton(By registerCompanyButton) {
        RegisterCompanyLocators.registerCompanyButton = registerCompanyButton;
    }


}
