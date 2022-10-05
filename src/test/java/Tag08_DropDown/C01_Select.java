package Tag08_DropDown;

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
import java.util.ArrayList;

public class C01_Select {

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
    //     ● Bir class oluşturun: DropDown
    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    @Test
    public void test02()  {
      WebElement dropdownMenu=driver.findElement(By.id("dropdown"));
      dropdownMenu.click();
      Select select=new Select(dropdownMenu);
      select.selectByIndex(1);

        select.selectByIndex(2);



    }


    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    @Test
    public void test03(){
        WebElement dropdownMenu=driver.findElement(By.id("dropdown"));

        Select select=new Select(dropdownMenu);
        select.selectByIndex(1);
        select.selectByIndex(2);
        System.out.println( select.getFirstSelectedOption().getText());

        for (int i = 0; i <select.getOptions().size() ; i++) {
            System.out.println("for döngüsü = "+select.getOptions().get(i).getText());

        }


        if(select.getOptions().size()==4){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
        System.out.println("dropdownun boyutu: "+select.getOptions().size());
    }
    //4.Tüm dropdown değerleri(value) yazdırın
    //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    //False yazdırın

}
