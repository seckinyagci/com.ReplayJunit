package Tag13_ActionsClass;

import Tag11_WindowHandle_TestBase.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_MouseActions2 extends TestBase {
    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement dragMe= driver.findElement(By.id("draggable"));
        WebElement dropHere= driver.findElement(By.xpath("(//*[@id=\"droppable\"])[1]"));
        actions.dragAndDrop(dragMe,dropHere).perform();
        String dropped=dropHere.getText();
        String expectedResult="Dropped!";

        Assert.assertEquals(dropped,expectedResult);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin


    }


}
