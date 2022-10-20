package Tag17_Wiederholung;

import Tag11_WindowHandle_TestBase.utilities.TestBaseC;
import org.apache.log4j.LogManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Logger;


public class C01_ActionsClassHomeWork extends TestBaseC {
    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    @Test
    public void test01() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Actions");

   //     Logger log = (Logger) LogManager.getLogger(C01_ActionsClassHomeWork.class);

    //2. "Hover over Me First" kutusunun ustune gelin
        WebElement howerOver= driver.findElement(By.xpath("//button[text()=\"Hover Over Me First!\"]"));
    //3. "Link 1" e tiklayin
        Actions actions=new Actions(driver);
        actions.moveToElement(howerOver).perform();
        WebElement ddm= driver.findElement(By.xpath("//div[@class=\"dropdown hover\"]"));
        Thread.sleep(5000);
        Select select=new Select(ddm);
        select.selectByIndex(1);
    //4. Popup mesajini yazdirin
        String message=driver.switchTo().alert().getText();
        System.out.println("pop up mesaji : "+message);
        driver.switchTo().alert().accept();
    //5. Popup'i tamam diyerek kapatin

    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin
}}
