package Tag19_Cookikes_WebTables;

import utilities.TestBaseC;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C01_CookiesAutomation extends TestBaseC {

    @Test
    public void test01(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookies= driver.manage().getCookies();
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookies.size()>5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedCookie="i18n-prefs";
        for (Cookie each:cookies
             ) {

            String actuelCookie=each.getName();
            if(expectedCookie.equals(actuelCookie)){
                String cookieValue=each.getValue();
                Assert.assertEquals(cookieValue,"USD");
                System.out.println("Cookies Value : "+cookieValue);
            }

        }

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        Cookie meineLieblichsteCookie= new Cookie("en sevdigim cookie","cikolatali");
       driver.manage().addCookie(meineLieblichsteCookie);
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Set<Cookie>enson=driver.manage().getCookies();
        int sayac=1;
        for (Cookie each:enson
             ) {

            System.out.println(sayac+ ". Cookie :"+each);
            sayac++;

        }
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
       driver.manage().deleteCookieNamed("skin");



        cookies=driver.manage().getCookies();
        for (Cookie each:cookies
             ) { String skin="skin";
            String actuel=each.getName();
            Assert.assertNotEquals(skin, actuel);

        }

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookies=driver.manage().getCookies();

        Assert.assertTrue(cookies.isEmpty());
    }

}
