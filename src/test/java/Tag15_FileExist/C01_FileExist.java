package Tag15_FileExist;

import org.junit.Test;

public class C01_FileExist {
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));
        // bana icinde bulundugum dosya yolunu verir
        ///Users/erstemacbook/eclipse-workspace/ReplayJunit

        System.out.println(System.getProperty("user.home"));

        //bana bilgisayarimin adini verir
        ///Users/erstemacbook

        // masaüstünü görmek istersek
        //          /Users/erstemacbook/Desktop

        // /Users/erstemacbook/eclipse-workspace/ReplayJunit/src/test/java/Tag01_JUnit

    }

}
