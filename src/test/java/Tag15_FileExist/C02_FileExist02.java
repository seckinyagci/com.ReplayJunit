package Tag15_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExist02 {
    @Test
    public void test01() {

        String dosyaYolu= System.getProperty("user.home")+"/Desktop/seckin.txt";
        System.out.println(dosyaYolu);
// bu dosya yolunda bir dosya var mi
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
