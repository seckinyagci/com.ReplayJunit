package Tag17_Wiederholung;

import Tag11_WindowHandle_TestBase.utilities.TestBaseC;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class C01_ActionsClassHomeWork extends TestBaseC {
    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    @Test
    public void test01(){
        driver.get("http://webdriveruniversity.com/Actions");

    //2. "Hover over Me First" kutusunun ustune gelin
        WebElement howerOver= driver.findElement(By.xpath("//button[text()=\"Hover Over Me First!\"]"));
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin
}}
