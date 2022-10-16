package Tag15_FileExist;

import Tag11_WindowHandle_TestBase.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileDownload extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // 1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("LambdaTest.txt")).click();
        //3. code.txt dosyasını indirelim
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String pathWeg=System.getProperty("user.home")+"/Downloads/LambdaTest.txt";
        Thread.sleep(5000);
        Assert.assertTrue(Files.exists(Paths.get(pathWeg)));
    }
}
