package Tag16_Wait;


import Tag11_WindowHandle_TestBase.utilities.TestBaseC;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_EnableTest extends TestBaseC {
    //1. Bir class olusturun : EnableTest
    @Test
    public void isEnable01(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


    //2. Bir metod olusturun : isEnabled()
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Textbox’in etkin olmadigini(enabled) dogrulayın
    WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());}

    @Test
    public void isEnable02(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
    //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin


        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        WebElement textBoxEnable=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));

    //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itSEnable= driver.findElement(By.id("message"));
        Assert.assertTrue(itSEnable.isDisplayed());

    //7. Textbox’in etkin oldugunu(enabled) dogrulayın
        Assert.assertTrue(textBoxEnable.isEnabled());}

}
