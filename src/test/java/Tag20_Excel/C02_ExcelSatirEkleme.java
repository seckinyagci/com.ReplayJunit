package Tag20_Excel;


import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;

import java.io.IOException;


public class C02_ExcelSatirEkleme {


    @Test
    public void test01() throws IOException, InterruptedException {

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
        Assert.assertEquals(expectedData,actuelData);

    }
    @Test
    public void test02() throws IOException {
        String seiteNo="Sayfa1";
        int rowIndex=3;
        int cellIndex=2;
        String expectedData="Cezayir";
        String actuelData=showResult(seiteNo,rowIndex,cellIndex);
        Assert.assertEquals(expectedData,actuelData);

    }

    private String showResult(String seiteNo,int rowIndex, int cellIndex) throws IOException {
        String result;
        FileInputStream fis=new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook workBook=WorkbookFactory.create(fis);
       result= workBook.getSheet(seiteNo).getRow(rowIndex).getCell(cellIndex).toString();

    return result; }
}
