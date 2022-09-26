package Tag07_Asserts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_YoutubeAssertions {
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
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    @Test
    public void test01(){
        driver.get("https://www.youtube.com");
    }
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    @Test
    public void test02(){
        String expectedData="YouTube";
        String actuelData= driver.getTitle();
        Assert.assertTrue(actuelData.contains(expectedData));}
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void test03(){
        WebElement menuButton= driver.
                findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[1]/yt-icon-button[2]/button/yt-icon"));
WebElement
        Assert.assertTrue(actuelData.contains(expectedData));}
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
}
