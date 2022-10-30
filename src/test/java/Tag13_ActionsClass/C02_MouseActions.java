package Tag13_ActionsClass;

import utilities.TestBaseC;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class C02_MouseActions extends TestBaseC {
    @Test
    public void test01() throws InterruptedException {

        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions=new Actions(driver);

        //3- Cizili alan uzerinde sag click yapalim
        WebElement alan= driver.findElement(By.id("hot-spot"));
        actions.contextClick(alan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        String allertText=driver.switchTo().alert().getText();
        String expectedData= "You selected a context menu";
        //test edelim.
        Assert.assertEquals(expectedData,allertText);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilkHandle=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> handles=driver.getWindowHandles();
        String ikinciHandle = null;
        for (String each:handles
             ) {if (!each.equals(ilkHandle)){
                 ikinciHandle=each;
        }

        }driver.switchTo().window(ikinciHandle);
        String tag=driver.getTitle();
        String tagExpectedData="Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro";
        Assert.assertEquals(tagExpectedData,tag);




    }
}
