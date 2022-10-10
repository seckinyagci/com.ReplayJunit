package Tag13_ActionsClass;

import Tag11_WindowHandle_TestBase.utilities.TestBaseC;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_ActionClass extends TestBaseC {
   @Test
   public void test01() throws InterruptedException {
       Actions actions=new Actions(driver);
       driver.get("https://www.amazon.com");
       WebElement menu = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
       actions.moveToElement(menu).perform();
       WebElement menuElementi = driver.findElement(By.xpath("//*[text()='Create a List']"));

       menuElementi.click();
       Thread.sleep(5000);

   }

}
