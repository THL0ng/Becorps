import org.openqa.selenium.By;

public class KYC_Team_Locator {
    public static By Companies = By.xpath("//a[contains(normalize-space(.), 'Team')]");
    public static By Impersonate = By.xpath("//td[.//span[contains(text(),'Expert Long_01_Test')]]/parent::tr//button[@ng-reflect-message='Impersonate']");
    public static By verifyText = By.cssSelector("div.menu-item-wrapper > button.mat-focus-indicator > span.mat-button-wrapper");







}
