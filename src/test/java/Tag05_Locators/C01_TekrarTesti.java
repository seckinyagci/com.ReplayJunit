package Tag05_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    /*
    1-C01_TekrarTesti isimli bir class olusturun

     */
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
        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //3- Browseri tam sayfa yapin
        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        if(driver.getTitle().contains("Spend less")){
            System.out.println("Sayfa basligi “Spend less” ifadesi iceriyor TEST PASS");
        }else {
            System.out.println("Test FAIL!!");
        }
        //6- Gift Cards sekmesine basin
        driver.findElement(By.xpath("//a[@href=\"/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc\"]"))
                .click();
        //7- Birthday butonuna basin
        driver.findElement(By.xpath("//img[@src=\"https://images-na.ssl-images-amazon.com/images/G/01/gift-certificates/consumer/2021/GCLP/Support/2x/Occ_Birthday_346x130.png\"]")).click();

        //8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("//*[@id=\"acs-product-block-0\"]/div[1]/a/img")).click();
        //9- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("(//button[@id=\"gc-mini-picker-amount-1\"])[1]")).click();
        //10-Urun ucretinin 25$ oldugunu test edin
       String price= driver.findElement(By.xpath("//span[@class=\"a-color-price a-text-bold\"]")).getText();
       price=price.substring(1,3);
       int fiyat=Integer.parseInt(price);
        System.out.println(fiyat);
        if (fiyat==25){
            System.out.println("Test PASS");
        }else {
            System.out.println("test FAIL");
        }
        //10-Sayfayi kapatin


    }
}
