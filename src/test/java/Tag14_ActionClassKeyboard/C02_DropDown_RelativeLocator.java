package Tag14_ActionClassKeyboard;


import utilities.TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C02_DropDown_RelativeLocator extends TestBase {

    Select select;

    @Test
    public void test01(){
        //Test01 :
        //1- amazon gidin
        driver.get("https://www.amazon.com");
        WebElement ddm= driver.findElement(By.id("searchDropdownBox"));
        //dropdown menusunun tagi select ile baslar ve select ile ddm nün icine girilir

        select=new Select(ddm);
        int ddpsize=select.getOptions().size();
        System.out.println(ddpsize);
        Assert.assertNotEquals(40, ddpsize);

        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        //3- dropdown menude 40 eleman olduğunu doğrulayın
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Thread.sleep(1000);
        WebElement ddm= driver.findElement(By.id("searchDropdownBox"));
        //dropdown menusunun tagi select ile baslar ve select ile ddm nün icine girilir

        select=new Select(ddm);
        //Test02
        //1- dropdown menuden elektronik bölümü seçin
        select.selectByIndex(10);
        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın 3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
       WebElement searchbox= driver.findElement(By.id("twotabsearchtextbox"));
       searchbox.sendKeys("iphone"+ Keys.ENTER);
        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement erstesElement= driver.findElement(By.xpath("//div[@cel_widget_id=\"MAIN-SEARCH_RESULTS-1\"]"));
        WebElement siebtesElement= driver.findElement(By.xpath("//div[@cel_widget_id=\"MAIN-SEARCH_RESULTS-7\"]"));
        WebElement zweitesElement= driver.findElement(with(By.tagName("img")).above(siebtesElement).toRightOf(erstesElement));
        Thread.sleep(15000);
        zweitesElement.click();
        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
    }

}
