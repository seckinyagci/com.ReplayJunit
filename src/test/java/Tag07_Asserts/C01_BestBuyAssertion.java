package Tag07_Asserts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BestBuyAssertion {
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
    public void test01() {
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
        //testleri yapin
        driver.get("https://www.bestbuy.com/");
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    }
    @Test
    public void test02(){
        String expectedData="https://www.bestbuy.com/";
        String actuelData=driver.getCurrentUrl();
        Assert.assertEquals(expectedData,actuelData);}
    @Test
    public void test03(){
        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String unExpectedData="Rest";
        String seiteTitle=driver.getTitle();
        Assert.assertFalse(seiteTitle.contains(unExpectedData));}

    @Test
    public void test04(){
        //○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo= driver.findElement(By.xpath("(//div/img[@alt=\"Best Buy Logo\"])[1]"));
        Assert.assertTrue(logo.isDisplayed()); }
    @Test
    public void test05(){
        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement franzoesichLink=driver.findElement(By.xpath("//li/button[@lang=\"fr\"]"));
        Assert.assertTrue(franzoesichLink.isDisplayed());
    }
    }
