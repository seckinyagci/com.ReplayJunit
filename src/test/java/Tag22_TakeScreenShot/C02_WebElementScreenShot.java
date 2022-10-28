package Tag22_TakeScreenShot;

import Tag11_WindowHandle_TestBase.utilities.TestBaseC;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_WebElementScreenShot extends TestBaseC {

    @Test
    public void test01() throws IOException {
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);
        //amazon sayfasina gidip tüm sayfanin fotosunu cekelim
        WebElement ergebnisText= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        TakesScreenshot ts= (TakesScreenshot) driver;
        LocalDateTime ldt=LocalDateTime.now();

        // fotolar icin dosya olustur ve dosya yolu assing et
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String datum=ldt.format(dtf);
        File ergebnisSS=new File("target/screenShots/"+datum+" ergebnisText.jpg");
        File temp=ergebnisText.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,ergebnisSS);






    }
}
