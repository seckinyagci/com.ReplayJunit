package Tag04_WebElemnts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_AmazonSearchTest {
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

      //  driver.close();
    }
    /*
    1. Bir class oluşturun :
2. Main method oluşturun ve aşağıdaki görevi tamamlayın.



d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
     */

@Test
    public void test01() throws InterruptedException {
    //a.web sayfasına gidin. https://www.amazon.com/
    driver.get("https://www.amazon.com");
    //b. Search(ara) “city bike”
    WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
    searchBox.sendKeys("city bike");
    searchBox.sendKeys(Keys.ENTER);
    //c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
    WebElement sonucSayisi= driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
    String sonuclar=sonucSayisi.getText();
    String sonucarr[]=sonuclar.split(" ");

    System.out.println("Amazon'da görüntülenen ilgili sonuçların sayısı= "+sonucarr[2]);

    WebElement ilkImage=driver.findElement(By.xpath("(//img[@class=\"s-image\"])[1]"));
    WebElement ikinciImage= driver.findElement(with(By.tagName("img")).below(ilkImage));
    WebElement ucuncuImage= driver.findElement(with(By.className("s-image")).below(ikinciImage));
    Thread.sleep(5000);
   ucuncuImage.click();
   Thread.sleep(5000);
// sadece with diyip elemente ait bir degerin simini girip sonraki locatorlara göre konumunu yaziyoruz





}
}
