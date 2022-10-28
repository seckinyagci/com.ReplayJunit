package Tag22_TakeScreenShot;

import Tag11_WindowHandle_TestBase.utilities.TestBaseC;
import com.github.javafaker.DateAndTime;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_TakeScreenShot extends TestBaseC {
    @Test
    public void test01() throws IOException {
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);
       //amazon sayfasina gidip tüm sayfanin fotosunu cekelim

        //takescreenshot objesi olustur
        TakesScreenshot ts= (TakesScreenshot) driver;
        LocalDateTime ldt=LocalDateTime.now();

        // fotolar icin dosya olustur ve dosya yolu assing et
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        ldt.format(dtf);
        File tumSayfaFoto= new File("target/screenShots/"+ldt+" amazonSearch.jpg");

        //Takescreenshot objesini kullanarak getScreenShotAs metodunu calistir foto türünü sec
        File geciciFoto=ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciFoto,tumSayfaFoto);
    }
}
