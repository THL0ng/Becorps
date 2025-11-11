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


}
