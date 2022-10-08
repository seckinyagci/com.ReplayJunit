package Tag10_Iframe;

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

public class C01_Iframe {
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
    //● Bir class olusturun: IframeTest
    //● https://the-internet.herokuapp.com/iframe adresine gidin.
    //● Bir metod olusturun: iframeTest


    //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //dogrulayin ve konsolda yazdirin
    @Test
    public void IframeTest010(){
        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement baslikElementi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());}
        @Test
        public void IframeTest02(){
        //○ Text Box’a “Merhaba Dunya!” yazin.
       /*     WebElement textKutusu=driver.findElement(By.xpath("//body[@id='tinymce']"));
              textKutusu.sendKeys("MerhabaDunya");
              calismaz cunku ilk once iframe icine swichto ile girmek lazim
              iframe icindeki web elementler aslinda baska bir sayfadadir
        */
            WebElement iframeElementi= driver.findElement(By.id("mce_0_ifr"));

            driver.switchTo().frame(iframeElementi);

            WebElement textKutusu=driver.findElement(By.xpath("//body[@id='tinymce']"));
            textKutusu.sendKeys("MerhabaDunya");


    }

}
