package Tag20_Excel;

import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class C02_ExcelSatirEkleme {
    java.util.Scanner scan = new Scanner(System.in);


    @Test
    public void test01() throws IOException {

        String pathExcel="src/resources/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(pathExcel);
        Workbook workBook= WorkbookFactory.create(fis);
        Sheet sheet= workBook.getSheet("Sayfa1");
        Row row=sheet.getRow(0);
        Cell cell= row.getCell(3);
        System.out.println(cell);

        String expectedData="Başkent (Türkçe)";
        String actuelData=workBook
                            .getSheet("Sayfa1")
                            .getRow(0)
                            .getCell(3)
                            .toString();
        System.out.println("lütfen ögrenmek istediginiz excel satirini giriniz");
        String excelSatir= scan.next();
        System.out.println("lütfen ögrenmek istediginiz sütunu giriniz");
        String excelSutun=scan.next();


        Assert.assertEquals(expectedData,actuelData);

    }
}