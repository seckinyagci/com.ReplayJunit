package Tag14_ActionClassKeyboard;


import Tag11_WindowHandle_TestBase.utilities.TestBaseC;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class C02_DropDown extends TestBaseC {
    Actions actions=new Actions(driver);

    @Test
    public void test01(){
        //Test01 :
        //1- amazon gidin
        driver.get("https://www.amazon.com");
        WebElement ddm= driver.findElement(By.id("searchDropdownBox"));
        //dropdown menusunun tagi select ile baslar ve select ile ddm nün icine girilir

        Select select=new Select(ddm);
        int ddpsize=select.getOptions().size();
        System.out.println(ddpsize);
        Assert.assertNotEquals(40, ddpsize);

        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        //3- dropdown menude 40 eleman olduğunu doğrulayın
    }

}
