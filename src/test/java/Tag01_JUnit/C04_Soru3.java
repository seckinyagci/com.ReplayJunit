package Tag01_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Soru3 {
    public static void main(String[] args) {
        // 1. “https://www.saucedemo.com” Adresine gidin
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com");
        // 2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("standard_user");
        // 3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("secret_sauce");
        // 4. Login tusuna basin
        driver.findElement(By.xpath("//input[@data-test=\"login-button\"]")).click();
        // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun= driver.findElement(By.xpath("(//div[@class=\"inventory_item_name\"])[1]"));
        String ilkUrunIsmi=ilkUrun.getText();
        System.out.println(ilkUrunIsmi);
        ilkUrun.click();
        // 6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
        // 7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
        // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String sepettekiUrun= driver.findElement(By.xpath("//div[@class=\"inventory_item_name\"]")).getText();
        if (ilkUrunIsmi.equals(sepettekiUrun)){
            System.out.println("ilk ürün ile sepetteki ürün ayni \nTest PASS");
        } else System.out.println("Test FAIL");

        // 9. Sayfayi kapatin
        driver.close();
    }
}
