import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
public class TipCalculatorPageTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\paran\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://qatipcalc.ccbp.tech/");

        WebElement BillAmount = driver.findElement(By.cssSelector("input[id ^='billAmo']"));
        BillAmount.sendKeys("1000");

        WebElement percentageTip1 = driver.findElement(By.cssSelector("input[id ^='percentage']"));
        percentageTip1.sendKeys("12");

        WebElement CalculaeBTN = driver.findElement(By.cssSelector("button[id *='calculateButton']"));
        CalculaeBTN.click();

        WebElement TipAmount = driver.findElement(By.cssSelector("p[id *='tipAmount']"));

        String ActualTipAmount = TipAmount.getText();

        String ExpectedTipAmount = "120.00";

        WebElement Total = driver.findElement(By.cssSelector("p[id *='totalAmount']"));

        String ActualTotal = Total.getText();

        String ExpectedTotal = "1120.00";

        if(ActualTipAmount.equals(ExpectedTipAmount) && ActualTotal.equals(ExpectedTotal)){
            System.out.println("Tip Calculated Correctly");
        }
        else {
            System.out.println("Tip Calculated Incorrectly");
        }


        WebElement percentageTip2 = driver.findElement(By.cssSelector("input[id ^='percentage']"));
        percentageTip2.clear();

        CalculaeBTN.click();


        WebElement errormessage = driver.findElement(By.cssSelector("p[id *='errorMessage']"));

        String errorText = errormessage.getText();
        String expectedText = "Please Enter a Valid Input.";

        if(errorText.equals(expectedText)){
            System.out.println("Error message displayed for no input");
        }
        else {
            System.out.println("Error message missing for no input");
        }


        WebElement percentageTip3 = driver.findElement(By.cssSelector("input[id ^='percentage']"));
        percentageTip2.sendKeys("10f");

        CalculaeBTN.click();


        WebElement errormessage2 = driver.findElement(By.cssSelector("p[id *='errorMessage']"));

        String Actualerrormessage = errormessage2.getText();


        String EXPerrormessage = "Please Enter a Valid Input.";

        if(Actualerrormessage.equals(EXPerrormessage)){
            System.out.println("Error message displayed for invalid input");
        }
        else{
            System.out.println("Error message missing for invalid input");
        }



        driver.quit();


    }
}