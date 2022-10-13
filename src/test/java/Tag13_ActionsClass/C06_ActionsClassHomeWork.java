package Tag13_ActionsClass;


import Tag11_WindowHandle_TestBase.utilities.TestBaseC;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C06_ActionsClassHomeWork extends TestBaseC {
    Actions actions=new Actions(driver);
    @Test
    public void test01() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        WebElement homf = driver.findElement(By.xpath("//*[text()=\"Hover Over Me First!\"]"));

        actions.moveToElement(homf).perform();
    } @Test
    public void test02(){
        //3- Link 1" e tiklayin
        WebElement homfl1= driver.findElement(By.xpath("(//*[text()=\"Link 1\"])[1]"));
        actions.click(homfl1).perform();}
    @Test
    public void test03(){
        //4- Popup mesajini yazdirin
        String alertText=driver.switchTo().alert().getText();
        System.out.println(alertText);}
    @Test
    public void test05(){
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();}
    @Test
    public void test06(){
        //6- “Click and hold" kutusuna basili tutun
        WebElement cah= driver.findElement(By.xpath("//*[text()='Click and Hold!']"));
        actions.clickAndHold(cah).perform();}
    @Test
    public void test07(){
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement welldone= driver.findElement(By.xpath("//div[@id=\"click-box\"]"));
        String welldonekeep=welldone.getText();
        System.out.println(welldonekeep);}
    @Test
    public void test08(){

        //8- “Double click me" butonunu cift tiklayin
        WebElement dcm= driver.findElement(By.xpath("//*[@class='div-double-click']"));
        actions.doubleClick(dcm).perform();


    }

}
