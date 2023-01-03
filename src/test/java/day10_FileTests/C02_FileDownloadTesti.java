package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {
    //2. https://the-internet.herokuapp.com/download adresine gidelim
    //3. Facebookd.png dosyasını indirelim
    //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim
        driver.get("https://the-internet.herokuapp.com/download");
        ReusableMethods.wait(1);
        driver.findElement(By.xpath("//a[@href='download/test.pdf']")).click();
        ReusableMethods.wait(2);

        //İndirilen dosyanın beklenen yolu >> Dinamik yol için user.home kullandık
        String beklenenYol=System.getProperty("user.home")+"\\Downloads\\test.pdf";

        // Bir dosyanın bilgisayarımızda varoldugunu test etmek için
        // Java'daki Files class'ından yardım alırız.

        //Dosya var mı? Kodu
        Assert.assertTrue(Files.exists(Paths.get(beklenenYol)));
    }

    @Test
    public void test02(){
        // Masaüstünde MerhabaJava.docx dosyası oldugunu test edin.

        String beklenenYol = System.getProperty("user.home")+"\\Desktop\\MerhabaJava.docx";

        Assert.assertTrue(Files.exists(Paths.get(beklenenYol)));

    }

}
