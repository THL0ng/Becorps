import java.util.Random;

public class KYC_commons {
    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    public String firstName = "Long" + getRandomNumber() + "gmail.com";
    public String lastName = "Test" + getRandomNumber();
    public int indenNumber =  getRandomNumber();
    public String percentage = "25";
    public String percentage_UBO = "75";




}
