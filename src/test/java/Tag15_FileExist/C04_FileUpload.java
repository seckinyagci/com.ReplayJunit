package Tag15_FileExist;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C04_FileUpload extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // 2. https://the-internet.herokuapp.com/upload adresine gidelim
        //3. chooseFile butonuna basalim
        //4. Yuklemek istediginiz dosyayi secelim.
        //5. Upload butonuna basalim.
        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        String pathWeg=System.getProperty("user.home")+"/Downloads/LambdaTest.txt";

        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys(pathWeg);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(5000);

        WebElement onayYazisi=driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(onayYazisi.isDisplayed());





    }
}
