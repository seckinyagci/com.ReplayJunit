package Tag02_RadioButton_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CheckBoxTest {
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
        driver.close();

    }

    @Test
    //a. Verilen web sayfasına gidin.
    public void tes01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        // b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]"));
        // c. Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        Thread.sleep(3000);
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }



    }}