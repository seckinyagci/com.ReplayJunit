package Tag07_Asserts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C02_Priority {
    //bu konu testng'ye ait
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
     //   driver.close();
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
       driver.switchTo().alert().accept();
       Actions action=new Actions(driver);
       action.sendKeys(Keys.END).perform();


       driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        WebElement menuButton= driver.
                findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[1]/yt-icon-button[2]/button/yt-icon"));
WebElement logo= driver.findElement(with(By.xpath("//*[@id=\"guide-icon\"]")).toRightOf(menuButton));
        Assert.assertTrue(logo.isDisplayed());}
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void test04(){
        WebElement searchBox= driver.
                findElement(By.xpath("//input[@id=\"search\"]"));
        Assert.assertTrue(searchBox.isEnabled());}

    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void test05(){

        Assert.assertNotEquals("youtube", driver.getTitle());}
}
