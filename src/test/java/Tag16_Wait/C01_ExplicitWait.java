package Tag16_Wait;

import Tag11_WindowHandle_TestBase.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {



    @Test
    public void implicitWait() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement remove= driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        remove.click();
        WebElement itsGone= driver.findElement(By.id("message"));

        Assert.assertTrue(itsGone.isDisplayed());

    }
    @Test
   public void explicitWait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement remove= driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        remove.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement itSgone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itSgone.isDisplayed());
    }


}
