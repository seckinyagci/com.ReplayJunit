package Tag11_WindowHandle_TestBase;

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
import java.util.Objects;
import java.util.Set;

public class C02_WindowHandle2 {
    static WebDriver driver;
    String ilkSayfaHandle;
    String ikinciSayfaHandle;
    @BeforeClass

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        driver.get("https://the-internet.herokuapp.com/windows");
       WebElement yazi= driver.findElement(By.xpath("//h3"));
       String actuelData=yazi.getText();
       String expectedData="Opening a new window";
       Assert.assertEquals(expectedData,actuelData); }
    @Test
    public void test02(){
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actuelData=driver.getTitle();
        String expectedData="The Internet";
        Assert.assertEquals(expectedData,actuelData);

    }
    @Test
    public void test03() {

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        ilkSayfaHandle=driver.getWindowHandle();
        Set <String> handles=driver.getWindowHandles();
        ikinciSayfaHandle = null;
     
        for (String each:handles)
                if(!Objects.equals(each, ilkSayfaHandle)){
                    
                    ikinciSayfaHandle=each;
                }
              {
                  

        }
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaHandle);
        String actuelData=driver.getTitle();
        String expectedData="New Window";
        Assert.assertEquals(expectedData,actuelData);


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement yazi= driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(expectedData,yazi.getText());
        System.out.println(ilkSayfaHandle);
        driver.switchTo().window(ilkSayfaHandle);
        actuelData=driver.getTitle();
        expectedData="The Internet";
        Assert.assertEquals(expectedData,actuelData);

    }







    }

