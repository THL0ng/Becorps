import org.openqa.selenium.WebDriver;

public class Review_Actions {
    WebDriver driver;


    public Review_Actions(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToNextButtonReview(){
        driver.findElement(Review_Locator.nextButton).click();
    }
}
