package Tag18_Uebungen;

import Tag11_WindowHandle_TestBase.utilities.TestBaseC;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class C01_WindowHandle extends TestBaseC {
    @Test
    public void test01(){
        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //2."Login Portal" a kadar asagi inin
        Actions actions=new Actions(driver);
        //3."Login Portal" a tiklayin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();
        String ersteSeiteHandle=driver.getWindowHandle();
        Set<String> setHandle=driver.getWindowHandles();
        String zweiteSeiteHandle=null;
        for (String each:setHandle
             ) {if (!each.equals(ersteSeiteHandle)){
                 zweiteSeiteHandle=each;
        }
        }
        driver.switchTo().window(zweiteSeiteHandle);

        //4.Diger window'a gecin
        //5."username" ve "password" kutularina deger yazdirin
        WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        actions.sendKeys(username)
                .sendKeys("username")
                .sendKeys(Keys.TAB)
                .sendKeys("password")
                .sendKeys(Keys.ENTER)
                .perform();

        //6."login" butonuna basin
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actuelAllert=driver.switchTo().alert().getText();
        String expectedAlert="validation failed";
        Assert.assertEquals(expectedAlert,actuelAllert);
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ersteSeiteHandle);
        //10.Ilk sayfaya donuldugunu test edin
        String ersteSeiteHandle2=driver.getWindowHandle();
        Assert.assertEquals(ersteSeiteHandle,ersteSeiteHandle2);
    }
}
