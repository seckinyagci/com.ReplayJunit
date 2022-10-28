package Tag20_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_BeforeAfter {
    protected  Workbook workBook;
    @Before
    public void setUp() throws IOException {
        String excelPatch="src/resources/ulkeler.xlsx";
        String sheet="Sayfa1";
        FileInputStream fis=new FileInputStream(excelPatch);
        workBook=WorkbookFactory.create(fis);
         }
}
