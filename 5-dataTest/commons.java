import org.openqa.selenium.By;

import java.io.File;
import java.util.Random;

public class commons {
    public static final String userName = "superadmin@becorps.com";
    public static final String password = "Becorps@2022";


    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    // STEP 1 //
    public String firstName = "Long" + getRandomNumber() + "gmail.com";
    public String secondName = "Test" + getRandomNumber();
    public String thirdName =  "Becorps" + getRandomNumber();
    public String website =  "";
    public String companyActivity =  "Test Automation";
    public Boolean yourOwnAddress;
    public String addresscompany = "Hồ Chí Minh" + " " + getRandomNumber();
    public String apartment =  "Vinpark riverside";
    public String city =  "ABC" + getRandomNumber();
    public String state =  "XYZ" + getRandomNumber() ;
    public String zipcode =  "Code" + getRandomNumber();
    public Boolean country_region;
    public String rental;

    // STEP 2 //
    public int  capitalAmount = getRandomNumber();
    public int  numberOfShares = 1;
    public String addShareHolderButton;
    public String firstNameShareholder = "Long_Shareholder" + getRandomNumber();
    public String lastNameShareholder = "becorps" + getRandomNumber();
    public int identification = getRandomNumber();
    public String email = "JohnDee" + getRandomNumber() + "@gmail.com";
    public int numberPhone = 12345;
    public String addressline = "New york City";
    public String addShareDistribution;
    public String numberShare_shareholder = "1";
    public String saveButton;
    public String addNom_Button;
    public String saveButtonNextStep;

}
