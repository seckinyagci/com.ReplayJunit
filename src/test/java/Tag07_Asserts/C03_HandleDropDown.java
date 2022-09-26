package Tag07_Asserts;

import com.sun.jna.Structure;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_HandleDropDown {
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
    public void test01(){
        driver.get("https://www.amazon.com");
       WebElement ddm= driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(ddm);
        select.selectByIndex(5);
        WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("bible");
        driver.findElement(By.xpath("(//*[@class=\"s-suggestion s-suggestion-ellipsis-direction\"])[1]")).click();

    }
}
