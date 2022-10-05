package Tag09_Authentication_Allert;

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

public class C01_BasicAuthentication {
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


    //1- Bir class olusturun : BasicAuthentication
    //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(1000);

        String expectedData="Congratulations! You must have the proper credentials.";
        WebElement actuel= driver.findElement(By.xpath("//*[@id=\"content\"]/div/p"));
        String actuelData=actuel.getText();
        Assert.assertEquals(expectedData,actuelData);
    }
    //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //Html komutu : https://username:password@URL
    //Username : admin
    //password : admin
    //4- Basarili sekilde sayfaya girildigini dogrulayin
}
