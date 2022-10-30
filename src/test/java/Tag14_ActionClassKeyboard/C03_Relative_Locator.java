package Tag14_ActionClassKeyboard;


import utilities.TestBaseC;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class C03_Relative_Locator extends TestBaseC {

    @Test
    public void test01() throws InterruptedException {
        //1 yeni bir sekme açarak amazon a nasayfaya gid in
        driver.get("https://www.amazon.com");}
    @Test
    public void test02() {
        //2 dropdown’dan bebek bölümüne secin
        //3 bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement ddm = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(ddm);
        select.selectByIndex(3);
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("puset" + Keys.ENTER);
    }
    @Test
    public void test03(){

        //4 sonuç yazsının puset içerdiğini te st edin
        WebElement ergebnisText= driver.findElement(By.xpath("//div[@cel_widget_id='UPPER-RESULT_INFO_BAR-0']"));
        String ergebnis=ergebnisText.getText();
        Assert.assertTrue(ergebnis.contains("puset"));
        System.out.println(ergebnis);
        //5 üçüncü ürüne relative locater kullanarak tıklay in
        //6 title ve fiyat bilgilerini assign edelim ve ürünü sepete ekley in
        //Test 4
       // test 4 b3ginnt
    }
}
