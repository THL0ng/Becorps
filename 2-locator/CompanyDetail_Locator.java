import org.openqa.selenium.By;

import java.io.File;

public class CompanyDetail_Locator {
    public static By firstNameForm = By.xpath("//mat-label[text()='First proposed name']/ancestor::mat-form-field//input");
    public static By secondNameForm = By.xpath("//mat-label[text()='Second proposed name']/ancestor::mat-form-field//input");
    public static By thirdNameForm = By.xpath("//mat-label[text()='Third proposed name']/ancestor::mat-form-field//input");
    public static By websiteForm = By.xpath("//mat-label[text()='Website']/ancestor::mat-form-field//input");
    public static By companyActivityForm = By.xpath("//mat-label[text()='Company activity']/ancestor::mat-form-field//textarea");
    public static By yourOwnAddress = By.xpath("//p[text()=' Use your own address in ']");
    public static By addressCompanyForm = By.xpath("//mat-label[text()='Address Line']/ancestor::mat-form-field//input");
    public static By apartmentForm = By.xpath("//mat-label[text()='Apartment , suite , etc.']/ancestor::mat-form-field//input");
    public static By cityForm = By.xpath("//mat-label[text()='City']/ancestor::mat-form-field//input");
    public static By stateForm = By.xpath("//mat-label[text()='State / Province']/ancestor::mat-form-field//input");
    public static By zipCodeForm = By.xpath("//mat-label[text()='Zipcode / Postal code']/ancestor::mat-form-field//input");
    public static By countryForm = By.xpath("//mat-label[text()='Country/Region']/ancestor::mat-form-field//input");
    public static By rentalForm = By.xpath("//ngx-dropzone-label[text()=' Upload rental agreement document']");

    public static By uploadFile = By.xpath("//input[@type='file']");

    public static By submitButton = By.xpath("//button[@type='submit']");
    public static By dropdownList = By.id ("mat-select-value-3");
    public static By country = By.xpath("//mat-label[text()='Country of Incorporation']");
}
