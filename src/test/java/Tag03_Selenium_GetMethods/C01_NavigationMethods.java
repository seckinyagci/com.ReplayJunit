package Tag03_Selenium_GetMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NavigationMethods {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }




    @Test
    public void test01(){


        //2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com/");
      //  3. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");

       // 4. Tekrar YouTube’sayfasina donelim
        driver.navigate().back();
    //    5. Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
       // 6. Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
       // 7. Sayfayi kapatalim / Tum sayfalari kapatalim

    }
}
