package Tag13_ActionsClass;

import Tag11_WindowHandle_TestBase.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C04_KeyboardActions1 extends TestBase {
    @Test
    public void test01(){
        //https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        //3- Arama kutusuna actions method’larine kullanarak
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);

        actions.click(aramaKutusu).sendKeys("samsung A71"+ Keys.ENTER).perform();


        //samsung A71 yazdirin ve Enter’a basarak arama
        //yaptirin
        //4- aramanin gerceklestigini test edin
        WebElement sonucYazisi= driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());



    }
}
