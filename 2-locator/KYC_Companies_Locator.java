import org.openqa.selenium.By;

public class KYC_Companies_Locator {
    public static By KYC_UBO = By.xpath("//div[normalize-space()='KYC/UBO']");
    public static By StatusIncomplete = By.xpath("//span[normalize-space()='Incomplete']");
    public static By itemsToComplete = By.xpath("//span[normalize-space()='Corporate Shareholders:']/following-sibling::span[1]");


    public static By COI = By.xpath("//mat-icon[normalize-space()='upload']");
    public static By AOA = By.xpath("(//mat-icon[normalize-space()='upload'])[2]");
    public static By COI2 = By.xpath("(//mat-icon[normalize-space()='upload'])[3]");


    public static By capital_unallocated = By.xpath("//mat-expansion-panel[2]/mat-expansion-panel-header/span[2]");
    public static By add_button = By.xpath("//mat-icon[normalize-space()='add']");


    public static By firstName = By.xpath("//mat-label[normalize-space()='First name']/ancestor::mat-form-field//input");
    public static By lastName = By.xpath("//mat-label[normalize-space()='Last name']/ancestor::mat-form-field//input");
    public static By indenNumber = By.xpath("//mat-label[normalize-space()='Identification Number']/ancestor::mat-form-field//input");
    public static By percentage = By.cssSelector("input[placeholder='Percentage of shares']");
    public static By addButton_Shareholder = By.xpath("//app-company-indirect-shareholder-dialog/mat-dialog-actions/button[2]");
    public static By confirmButton = By.xpath("//span[normalize-space()='Confirm']");



}
