package Tag15_FileExist;

import Tag11_WindowHandle_TestBase.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Paths;

public class C06_FileUpload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //3. chooseFile butonuna basalim
        String dosyaYolu=System.getProperty(String.valueOf(Paths.get("user.home")))+"/Downloads/LambdaTest.txt";
        driver.findElement(By.id("file-upload")).sendKeys(dosyaYolu);
        Thread.sleep(5000);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(5000);
        //4. Yuklemek istediginiz dosyayi secelim.
        //5. Upload butonuna basalim.
        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement yuklemeYazisi= driver.findElement(By.xpath("//h3"));
        WebElement yuklenenDosyaAdi= driver.findElement(By.id("uploaded-files"));
        String dosyaAdi="LambdaTest.txt";
        String yuklenenDosya=yuklenenDosyaAdi.getText();
        Assert.assertTrue(yuklemeYazisi.isDisplayed());
        Assert.assertEquals(yuklenenDosya,dosyaAdi);


    }


}
