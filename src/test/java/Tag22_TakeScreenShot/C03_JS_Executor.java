package Tag22_TakeScreenShot;

import utilities.TestBaseC;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C03_JS_Executor extends TestBaseC {
    @Test
    public void Test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement signIn=driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        jse.executeScript("arguments[0].scrollIntoView(true);",signIn);
        Thread.sleep(5000);


    }
}
