package Tag12_TestBaseClass;

import org.junit.Test;
import Tag11_WindowHandle_TestBase.utilities.TestBase;

public class C01_TestBaseFirstTest extends TestBase {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

    }
}
