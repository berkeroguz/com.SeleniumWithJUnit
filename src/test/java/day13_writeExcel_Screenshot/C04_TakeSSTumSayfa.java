package day13_writeExcel_Screenshot;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TakeSSTumSayfa extends TestBase {

    @Test
    public void test01(){

        // wisequarter ana sayfaya gidin
        driver.get("https://www.wisequarter.com");
        // ana sayfaya gittiğinzi test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("wisequarter"));
        // tüm sayfa screenshot alin
        ReusableMethods.tumSayfaScreenShotCek(driver,"wiseSS");


    }
}
