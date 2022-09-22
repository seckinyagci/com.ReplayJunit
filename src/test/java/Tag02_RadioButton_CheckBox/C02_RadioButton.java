package Tag02_RadioButton_CheckBox;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C02_RadioButton {
    Faker faker=new Faker();
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
    //    driver.close();

    }
    // https://www.facebook.com adresine gidin
@Test
    public void test01(){
        driver.get("https://www.facebook.com");
    //   - Cookies’i kabul edin
        driver.findElement(By.xpath("//button[@data-cookiebanner=\"accept_button\"]")).click();
    //- “Create an Account” button’una basin
    driver.findElement(By.xpath("(//a[@role=\"button\"])[2]")).click();
    Actions actions=new Actions(driver);


    WebElement formNameAlani= driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
    actions.click(formNameAlani)
            .sendKeys(faker.name().firstName())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.name().lastName())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.phoneNumber().cellPhone())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.internet().password())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.date().birthday().toString())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.date().toString())
            .sendKeys(Keys.TAB)
            .sendKeys("1980")
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.ENTER)
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.ENTER)

            .perform();
    System.out.println(driver.getCurrentUrl());
    System.out.println(driver.getPageSource());
    System.out.println();
    System.out.println(driver.getWindowHandle());
    System.out.println(driver.getWindowHandles());


    }




//- “radio buttons” elementlerini locate edin
//- Secili degilse cinsiyet butonundan size uygun olani secin
}
