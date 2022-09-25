package Tag06_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_RelativeLocators {
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
      //  driver.close();
    }
    //
    @Test
            public void test01(){

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html#");
        WebElement boston=driver.findElement(By.id("boston"));
        WebElement sailor=driver.findElement(By.id("sailor"));
        WebElement berlin=driver.findElement(with(By.tagName("li")).above(sailor).toRightOf(boston));
        WebElement london = driver.findElement(with(By.tagName("li")).toLeftOf(boston));

    }
}
