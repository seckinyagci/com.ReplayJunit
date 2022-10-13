package Tag14_ActionClassKeyboard;

import Tag11_WindowHandle_TestBase.utilities.TestBaseC;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_KeyboardActions2 extends TestBaseC {
Actions actions=new Actions(driver);
    @Test
    public void test01(){
        driver.get("https://html.com/tags/iframe/");
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        WebElement iframeElement=driver.findElement(By.xpath("//iframe[@width=\"560\"]"));
        driver.switchTo().frame(iframeElement);
        WebElement playClick= driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[4]/button"));
        playClick.click();
        WebElement playing= driver.findElement(By.xpath("//a[@class=\"ytp-youtube-button ytp-button yt-uix-sessionlink\"]"));
        Assert.assertTrue(playing.isDisplayed());


}
}
