package utilities;

import net.bytebuddy.asm.Advice;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {

    public static void wait(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e){

        }
    }

    public static void tumSayfaScreenShotCek(WebDriver driver,String ssName) {
        // 1- TakeScreenShot objesi oluştur.
        TakesScreenshot tss = (TakesScreenshot) driver;

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih = ldt.format(dtf);
        String dosyaYolu ="target/ekranResimler/tumEkranSS-"+tarih+".jpeg";
        // 2- Resmi son olarak kaydedeceğimiz dosyayi oluştur.
        File tumSayfaScreenshot = new File(dosyaYolu);

        // 3- tss objesi kullanarak ekran görüntüsü alip geçici dosyaya kaydet
        File geciciDosya= tss.getScreenshotAs(OutputType.FILE);

        // 4- geçici dosyayı ana dosyaya kopyala
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void elementSSCek (WebElement element)
    {
        // 1- Screenshot alacagimiz elementi locate et
        // 2- kaydedecegimiz dosyayi olustur

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih = ldt.format(dtf);
        String dosyaYolu = "target/ekranResimleri/istenenElementSS"+tarih+".jpeg";

        File elementSS = new File(dosyaYolu);
        // 3- Gecici dosyayi oluşturup element üzerinden screenshot yapalım

        File gecici = element.getScreenshotAs(OutputType.FILE);

        // 4- Gecici dosyayi, hedef dosyaya kopyala

        try {
            FileUtils.copyFile(gecici,elementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
