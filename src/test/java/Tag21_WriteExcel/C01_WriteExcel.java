package Tag21_WriteExcel;

import Tag20_Excel.C04_BeforeAfter;
import org.junit.Test;


import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel extends C04_BeforeAfter {

    @Test
    public void excelTest01() throws IOException {
        workBook
                .getSheet("Sayfa1")
                .getRow(0)
                .createCell(5)
                .setCellValue("Nufus");
        workBook
                .getSheet("Sayfa1")
                .getRow(1)
                .createCell(5)
                .setCellValue(1500000);
        FileOutputStream fos=new FileOutputStream("src/resources/ulkeler.xlsx");
        workBook.write(fos);
        fos.close();
        workBook.close();
    }

}
