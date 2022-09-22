package Tag04_WebElemnts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HerokuappTest {
    /*
    Class Work: Add Remove Element
Asagidaki testi text’leri kullanarak locate edin
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
        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick=\"addElement()\"]")).click();
        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton=driver.findElement(By.xpath("//button[@class=\"added-manually\"]"));
        if(deleteButton.isDisplayed()){
            System.out.println("Test PASS");
        } else {
            System.out.println("Test FAIL!!");
        }
        //4- Delete tusuna basin
        deleteButton.click();
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveYazisi= driver.findElement(By.xpath("//*[@id=\"content\"]/h3"));
        if(addRemoveYazisi.isDisplayed()){
            System.out.println("Test 2 PASS");
        } else {
            System.out.println("Test FAIL!!");
        }



    }
}
