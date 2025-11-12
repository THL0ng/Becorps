import org.openqa.selenium.By;

public class Quote_Locator {
    public static By checkbox01 = By.cssSelector("mat-checkbox[formcontrolname='isSelected'] .mat-checkbox-inner-container");
    public static By checkbox02 = By.xpath("(//mat-checkbox[@formcontrolname='isSelected']//span[contains(@class,'mat-checkbox-inner-container')])[2]");
    public static By checkbox03 = By.xpath("(//mat-checkbox[@formcontrolname='isSelected']//span[contains(@class,'mat-checkbox-inner-container')])[3]");
    public static By checkbox04 = By.xpath("(//mat-checkbox[@formcontrolname='isSelected']//span[contains(@class,'mat-checkbox-inner-container')])[4]");
    public static By checkbox05 = By.xpath("(//mat-checkbox[@formcontrolname='isSelected']//span[contains(@class,'mat-checkbox-inner-container')])[5]");

    public static By requestButton = By.xpath("//mat-icon[contains(normalize-space(),'request_quote')]");



}
