package Tag01_JUnit;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
      //  2. Signin buttonuna tiklayin
        WebElement SingIn= driver.findElement(By.id("signin_button"));
        SingIn.click();
       // 3. Login alanine “username” yazdirin

        driver.findElement(By.xpath("//input[@id=\"user_login\"]")).sendKeys("username");

        // 4. Password alanine “password” yazdirin
        driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("password");

        // 5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();

       // 6. online banking sayfasindan Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//*[text()=\"Online Banking\"][1]")).click();
        driver.findElement(By.xpath("//*[@id=\"pay_bills_link\"]")).click();

        // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin

        driver.findElement(By.xpath("//input[@id=\"sp_amount\"]")).sendKeys("1000");


        // 8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id=\"sp_date\"]")).sendKeys("2020-09-10");
        // 9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id=\"pay_saved_payees\"]")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin

        WebElement sonuc= driver.findElement(By.xpath("//span[text()=\"The payment was successfully submitted.\"]"));
        String actuelResult=sonuc.getText();
        String expectedResult="The payment was successfully submitted.";

        if (expectedResult.equals(actuelResult)){
            System.out.println("Test PASST");
        } else System.out.println("Test FAIL");




        driver.close();

    }
}
