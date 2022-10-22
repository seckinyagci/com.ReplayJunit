package Tag19_Cookikes_WebTables;

import Tag11_WindowHandle_TestBase.utilities.TestBaseC;
import org.bouncycastle.pqc.crypto.qtesla.QTeslaKeyEncodingTests;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class C02_WebTables extends TestBaseC {
    @Test
    public void login() {
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //○ Username : manager
        Actions actions = new Actions(driver);

       WebElement userName= driver.findElement(By.id("UserName"));
        actions.click(userName)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1!")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //○ Password : Manager1! ● table( ) metodu oluşturun
    }
    @Test
    public void table() {

        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBasliklari=driver.findElements(By.xpath("//thead//tr//th"));

        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //● printRows( ) metodu oluşturun //tr
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //○ 4.satirdaki(row) elementleri konsolda yazdırın.

    }

}
