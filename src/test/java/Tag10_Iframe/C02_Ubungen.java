package Tag10_Iframe;

import utilities.TestBaseC;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02_Ubungen extends TestBaseC {

    @Test
    public void test01() throws InterruptedException {
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin

        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //2. “Our Products” butonuna basin
        WebElement iframe= driver.findElement(By.id("frame"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("//*[text()='Our Products']")).click();
        Thread.sleep(3000);
        //3. “Cameras product”i tiklayin

        driver.findElement(By.xpath("//*[text()='Cameras']")).click();

        Thread.sleep(3000);
        //4. Popup mesajini yazdirin

        String popUp=driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[2]/p")).getText();
        System.out.println("popup :"+popUp);
        Thread.sleep(3000);
        //5. “close” butonuna basin
        driver.findElement(By.xpath("//button[text()='Close']")).click();
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().parentFrame();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']")).click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl="http://webdriveruniversity.com/index.html";
        String actuelUrl=driver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertEquals(expectedUrl,actuelUrl);
        System.out.println(actuelUrl);
    }
}
