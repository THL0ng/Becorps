import org.openqa.selenium.By;

public class KYC_Companies_Locator {
    public static By KYC_UBO = By.xpath("//div[normalize-space()='KYC/UBO']");
    public static By StatusIncomplete = By.xpath("//span[normalize-space()='Incomplete']");
    public static By itemsToComplete = By.xpath("//span[normalize-space()='Corporate Shareholders:']/following-sibling::span[1]");

    public static By capital_unallocated = By.xpath("//div[normalize-space()='1 missing']");
    public static By add_button = By.xpath("//mat-icon[normalize-space()='add']");

    public static By firstName = By.xpath("//mat-label[normalize-space()='First name']/ancestor::mat-form-field//input");
    public static By lastName = By.xpath("//mat-label[normalize-space()='Last name']/ancestor::mat-form-field//input");
    public static By indenNumber = By.xpath("//mat-label[normalize-space()='Identification Number']/ancestor::mat-form-field//input");
    public static By percentage = By.cssSelector("input[placeholder='Percentage of shares']");
    public static By addButton_Shareholder = By.xpath("//app-company-indirect-shareholder-dialog/mat-dialog-actions/button[2]");
    public static By confirmButton = By.xpath("//span[normalize-space()='Confirm']");



    public static By LongIndividual_Layer1 = By.xpath("//span[normalize-space()='Long Individual_ Layer1']");
    public static By DrakeIndividual_Layer1 = By.xpath("//span[normalize-space()='Drake Individual_ Layer1']");
    public static By Nominee_Long = By.xpath("//span[normalize-space()='Director:']");
    public static By LongKYC_Flow = By.xpath("//span[contains(@class,'font-bold') and contains(., 'Long_Autog')]");


    public static By statusVerifying = By.xpath("//span[normalize-space()='Verifying']");
    public static By confirmKYC = By.xpath("//button[normalize-space()='upload_file Confirm KYC']");
    public static By Sure_confirmKYC = By.xpath("//span[normalize-space()='Confirm']");

    public static By done_uploadfiles_KYC = By.xpath("//span[normalize-space()='Confirmed']");



}
