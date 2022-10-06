package Tag09_Authentication_Allert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allertler {
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
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //“You successfully clicked an alert” oldugunu test edin. ●
    @Test
    public void test01() {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
        driver.switchTo().alert().accept();
        WebElement result= driver.findElement(By.xpath("//p[@id=\"result\"]"));
        String expectedData="You successfully clicked an alert";
        String actuelData=result.getText();
        Assert.assertEquals(expectedData,actuelData);
    }
    // Bir metod olusturun: dismissAlert
    //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin.
    @Test
    public void test02() {
        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        driver.switchTo().alert().dismiss();
        WebElement result= driver.findElement(By.xpath("//p[@id=\"result\"]"));
        String expectedData="successfuly";
        String actuelData=result.getText();
        Assert.assertNotEquals(expectedData,actuelData);}

    // ● Bir metod olusturun: sendKeysAlert
    //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın
    @Test
    public void test03() {
        driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
        driver.switchTo().alert().sendKeys("Seckin");
        driver.switchTo().alert().accept();
        WebElement result= driver.findElement(By.xpath("//p[@id=\"result\"]"));
        String expectedData="You entered: Seckin";
        String actuelData=result.getText();
        Assert.assertEquals(expectedData,actuelData);






    }

}
