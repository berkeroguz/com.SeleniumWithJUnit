package day08_HandlingWindows;

import utilities.ReusableMethods;
import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class C04_TestBaseIlkTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        ReusableMethods.wait(3);

        String expectedKelime ="amazon";
        String actualKelime=driver.getCurrentUrl();

        Assert.assertTrue(actualKelime.contains(expectedKelime));

        ReusableMethods.wait(3);
    }

}
