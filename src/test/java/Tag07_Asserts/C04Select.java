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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_TekrarTesti{
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
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");}

    //2. Sign in butonuna basin
    @Test
    public void test02(){
    driver.findElement(By.id("signin_button")).click();

    }
      //3. Login kutusuna “username” yazin
      //4. Password kutusuna “password.” yazin
      //5. Sign in tusuna basin
    @Test
    public void test03(){
          driver.findElement(By.id("user_login")).sendKeys("username");
          driver.findElement(By.id("user_password")).sendKeys("password");
          driver.findElement(By.name("submit")).click();
          driver.navigate().back();
      }
        //6. Pay Bills sayfasina gidin
    @Test
    public void test04(){
        driver.findElement(By.id("onlineBankingMenu")).click();
            driver.findElement(By.id("pay_bills_link")).click();

        }
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    @Test
    public void test05() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"tabs\"]/ul/li[3]/a")).click();
        WebElement currencyMenu=driver.findElement(By.id("pc_currency"));
        Select select=new Select(currencyMenu);
        select.selectByIndex(6);
        Thread.sleep(5000);
    }
        //9. “amount” kutusuna bir sayi girin
    @Test
    public void test06(){
            driver.findElement(By.id("pc_amount")).sendKeys("199");
    }
    @Test
    public void test07(){
        driver.findElement(By.id("pc_amount")).sendKeys("199");
    }
        //10. “US Dollars” in secilmedigini test edin
    @Test
    public void test08(){
        WebElement dolarSing= driver.findElement(By.id("pc_inDollars_true"));
            Assert.assertFalse(dolarSing.isSelected());
        }

        //11. “Selected currency” butonunu secin
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    @Test
    public void test09(){
        WebElement selectedCurrency= driver.findElement(By.id("pc_inDollars_false"));
        selectedCurrency.click();
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

    }
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin

    @Test
    public void test010(){
        WebElement alertcontet= driver.findElement(By.id("alert_content"));
        String expectedData="Foreign currency cash was successfully purchased.";
        String actuelData=alertcontet.getText();
        Assert.assertEquals(expectedData,actuelData);
        System.out.println(expectedData+"\n"+actuelData);
    }

    }



