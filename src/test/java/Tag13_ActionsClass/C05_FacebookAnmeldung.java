package Tag13_ActionsClass;

import Tag11_WindowHandle_TestBase.utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_FacebookAnmeldung extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@data-cookiebanner=\"accept_button\"]")).click();
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@data-testid=\"open-registration-form-button\"]")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions= new Actions(driver);
        WebElement firstName= driver.findElement(By.xpath("//input[@name='firstname']"));
        Faker faker=new Faker();
        WebElement submit= driver.findElement(By.xpath("//button[@name='websubmit']"));
        String email=faker.internet().emailAddress();
        actions.click(firstName)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("01")
                .sendKeys(Keys.TAB)
                .sendKeys("01")
                .sendKeys(Keys.TAB)
                .sendKeys("1979")
                .perform();
        WebElement cinsiyet= driver.findElement(By.xpath("(//input[@name='sex'])[2]"));
        actions.click(cinsiyet).perform();
        actions.click(submit).perform();
        Thread.sleep(15000);
        //4- Kaydol tusuna basalim

    }
}
