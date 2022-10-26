package Tag20_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_Excel {
@Test
    public void excelTest() throws IOException {
    //4. excelAutomation isminde bir package olusturalim
    //5. ReadExcel isminde bir class olusturalim
    //6. readExcel() method olusturalim
    //7. Dosya yolunu bir String degiskene atayalim
    String pathDosya="src/resources/ulkeler.xlsx";
    //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    FileInputStream fis=new FileInputStream(pathDosya);
    //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    Workbook workBook= WorkbookFactory.create(fis);
    //10. WorkbookFactory.create(fileInputStream)
    //11. Worksheet objesi olusturun workbook.getSheetAt(index)
    Sheet sheet= workBook.getSheet("Sayfa1");
    //12. Row objesi olusturun sheet.getRow(index)
    Row row=sheet.getRow(3);
    //13. Cell objesi olusturun row.getCell(index)
    Cell cell=row.getCell(3);

    System.out.println(cell);





    }

}
