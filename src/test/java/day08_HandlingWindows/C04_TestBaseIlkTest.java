package day08_HandlingWindows;

import entities.ReusableMethods;
import entities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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
