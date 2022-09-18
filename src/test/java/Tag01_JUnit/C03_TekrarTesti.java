package Tag01_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_TekrarTesti {
    public static void main(String[] args) {
        //1-C01_TekrarTesti isimli bir class olusturun
       // 2- https://www.google.com/ adresine gidin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com");

       // 3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//div[text()=\"Accept all\"]")).click();
       // 4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String sayfaBasligi=driver.getTitle();
        String expectedData="Google";
        if (sayfaBasligi.equals(expectedData)){
            System.out.println("Test PASS");
        } else System.out.println("Test FAIL");
        System.out.println(sayfaBasligi);
       // 5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaMotoru= driver.findElement(By.xpath("//input[@title=\"Search\"]"));
aramaMotoru.click();
        aramaMotoru.sendKeys("Nutella");
aramaMotoru.sendKeys(Keys.ENTER);
       // 6-Bulunan sonuc sayisini yazdirin
        String sonucSayisi=driver.findElement(By.xpath("//div[@id=\"result-stats\"]")).getText();
        System.out.println(sonucSayisi);
        //  7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String [] sonuclar=sonucSayisi.split(" ");
        String rakamYazi=sonuclar[1].replaceAll("\\.","");

        int sonucSayisiInt=Integer.parseInt(rakamYazi);
       if (sonucSayisiInt>10000000){
           System.out.println("Sonuc sayisi 10 milyondan fazla");
           System.out.println("Test PASS");
       }else {
           System.out.println("Sonuc sayisi 10 milyondan az");
           System.out.println("Test FAIL");
       }
       // 8-Sayfayi kapatin
           driver.close();
    }
}
