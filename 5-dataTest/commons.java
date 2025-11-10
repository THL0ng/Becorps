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

    public String firstName = "Long" + getRandomNumber() + "gmail.com";
    public String secondName = "Test" + getRandomNumber();
    public String thirdName =  "Becorps" + getRandomNumber();
    public String website =  "";
    public String companyActivity =  "Test Automation";
    public Boolean yourOwnAddress;
    public String addresscompany = "Hồ Chí Minh" + "" + getRandomNumber();
    public String apartment =  "Vinpark riverside";
    public String city =  "ABC" + getRandomNumber();
    public String state =  "XYZ" + getRandomNumber() ;
    public String zipcode =  "Code" + getRandomNumber();
    public Boolean country_region;
    public String rental;












}
