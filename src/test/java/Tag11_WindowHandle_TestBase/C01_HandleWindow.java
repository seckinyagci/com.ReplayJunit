package Tag11_WindowHandle_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindow {
    static WebDriver driver;
    @BeforeClass

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
      driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getWindowHandle());

        String amazonHashCode01= driver.getWindowHandle();
        // bu sayfaya ait unique hascode'ududr

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);

       WebElement ilkUrunResmi= driver.findElement(By.xpath("(//img[@class=\"s-image\"])[1]"));

       //bu asamada yeni tab aciliyor ama tüm islemleri bastan almamiz lazim
       driver.switchTo().newWindow(WindowType.TAB);
       driver.get("https://www.amazon.com");


       //nutella aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);

       //ilk resme tiklayalim

        driver.findElement(By.xpath("(//img[@class=\"s-image\"])[1]")).click();

        //eski sayfaya dönelim

        driver.switchTo().window(amazonHashCode01);
        Thread.sleep(5000);





        // eger sayfalar arasinda driverimizi gezdiriyorsak ve herhangi bir sayfadan
        // suan bulundugumuz sayfaya gecmek istiyorsak bu sayfaniin window handle degerini girerek ulasiriz
    }
}
