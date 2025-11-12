import org.openqa.selenium.By;

public class Capital_Locator {
    public static By capitalAmountForm = By.xpath("//td[@class='mat-cell']//mat-form-field//input[@type='number']");
    public static By numberOfsharesForm = By.xpath("//td[@class='mat-cell text-center']//mat-form-field//input[@type='number']");
    public static By addShareholderButton = By.xpath("//div[@class='inline-flex gap-1 items-center']");

    public static By firstNameShareholder = By.xpath("//input[@formcontrolname='firstName']");
    public static By lastNameShareholder = By.xpath("//input[@formcontrolname='lastName']");
    public static By identificationForm = By.xpath("//input[@formcontrolname='identificationNumber']");
    public static By emailForm = By.xpath("//input[@type='email']");
    public static By phoneForm = By.xpath("input[type='tel']");
    public static By addressForm = By.xpath("//input[@placeholder='Address line']");

    public static By addShareDistributionButton = By.cssSelector("section.inline-flex > button.mat-focus-indicator > span.mat-button-wrapper");
    public static By numberForm_Shareholder = By.cssSelector("input[formcontrolname='numberOfShares']");
    public static By saveButtonShareholder = By.xpath("//span[normalize-space()='Save']");

    public static By addNomineeDirector = By.xpath("//span[contains(normalize-space(),'Add Nominee Director')]");
    public static By nextbutton = By.xpath("(//button[contains(@class,'mat-stepper-next') and contains(@class,'bg-primary-900')])[2]");




}
