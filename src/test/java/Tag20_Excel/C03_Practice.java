package Tag20_Excel;

import org.junit.Assert;
import org.junit.Test;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C03_Practice extends C04_BeforeAfter{

    @Test
    public void test01() throws IOException {
        //Yeni bir test method olusturalim readExcel2( )
        String sheet= "Sayfa1";
        int row=1;
        int cell=2;

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workBook.getSheet(sheet).getRow(1).getCell(2));
        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String zweitesCell=workBook.getSheet(sheet).getRow(1).getCell(2).toString();
        System.out.println("ikinci hücre = "+zweitesCell);
        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedData="Kabil";

        String actuelData=workBook.getSheet(sheet).getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedData,actuelData);
        //- Satir sayisini bulalim
        System.out.println("Son Satir Indexi :"+workBook.getSheet(sheet).getLastRowNum());
        int sonSatirIndexi=workBook.getSheet(sheet).getLastRowNum();
        //- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Fiziki olarak kullanilan  Satir Sayisi : "+workBook.getSheet(sheet).getPhysicalNumberOfRows());
        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String> excelUlkeler=new HashMap<>();
        for (int i = 1; i <=sonSatirIndexi ; i++) {
            //Key dosyadaki i satirindaki sifirinci indexteki veridir
            String key= workBook.getSheet(sheet).getRow(i).getCell(0).toString();
            //value 0 satirin
            String value=workBook.getSheet(sheet).getRow(i).getCell(1).toString()
                    +", "+ workBook.getSheet(sheet).getRow(i).getCell(2).toString()
                    +", "+ workBook.getSheet(sheet).getRow(i).getCell(3).toString();
            excelUlkeler.put(key,value);

        }
        for (int i = 1; i <sonSatirIndexi ; i++) {
            String key=workBook.getSheet(sheet).getRow(i).getCell(0).toString();
            String value=workBook.getSheet(sheet).getRow(i).getCell(1).toString();
            System.out.println(key+ ": "+value);

        }
//ülkeler listinde gana var mi
        Assert.assertTrue(excelUlkeler.containsKey("Ghana"));

    }

}
