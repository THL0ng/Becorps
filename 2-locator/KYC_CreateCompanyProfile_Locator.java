import org.openqa.selenium.By;

public class KYC_CreateCompanyProfile_Locator {

    public static By create_company_profile = By.xpath("//span[normalize-space()='Create Company Profile']");
    public static By input_Registration = By.xpath("//mat-label[text()='Registration No']/ancestor::mat-form-field//input");
    public static By Confirm_createCompanyProfile = By.xpath("//mat-dialog-actions//span[normalize-space()='Create Company Profile']");


    public static By back_to_companies2 = By.xpath("//span[@class='mat-list-text']//div[@class='mat-line' and normalize-space()='Companies']");
    public static By back_to_companies = By.xpath("//a[contains(normalize-space(.), 'Companies')]");




}
