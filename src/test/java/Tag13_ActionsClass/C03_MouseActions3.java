package Tag13_ActionsClass;

import utilities.TestBaseC;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_MouseActions3 extends TestBaseC {

    @Test
    public void test01(){
    //1- https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirelim
        //3- “Create a list” butonuna basalim
        WebElement accountList=driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        WebElement createAList=driver.findElement(By.xpath("//*[text()='Create a List']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList)
                .click(createAList).perform();

        //

        String expectedResult="Your Lists";
        String actuelResult=driver.findElement(By.xpath("//*[@id=\"my-lists-tab\"]/a")).getText();
        System.out.println(actuelResult);
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim
       Assert.assertEquals(expectedResult,actuelResult);


    }
}
