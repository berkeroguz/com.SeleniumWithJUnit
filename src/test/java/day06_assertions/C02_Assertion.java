package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {
    /*
        JUnit Framework'u çalıştırılan testlerin passed veya failed olmasını raporlar.
        Ancak raporlamanın doğru sonuç vermesi için Test'lerin Assert class'indaki hazir
        methodlar ile yapılması gerekir.

        Eğer Assert Class'i kullanılmazsa JUnir kodlarin sorunsuz olarak çalışıp bittiğini
        raporlar. C01'de tsetleri if-else ile yaptığımız için testler failed olsa da çalıştı.
        ve testler yeşil tik aldı.

        ßß If-else :=
     */

    int P1Yas= 60;
    int P2Yas= 66;
    int P3Yas= 70;

    @Test
    public void test01(){
      //emekli yasi 65 olduguna göre
      // yas2'nin emekli olabileceğini test edin.
        Assert.assertTrue("Yas kucuk oldugu ıcın emeklı olamaz.",P2Yas>65);

    }

    @Test
    public void test02(){
        //emekli yasi 65 olduguna göre
        // yas1'nin emekli olamayacağını test edin.
        Assert.assertFalse("",P1Yas>65);
    }

    @Test
    public void test03(){

        //emekli yasi 65 ve P3'nin emekli olamayacağını test edin.
        Assert.assertFalse(P3Yas<65);
    }
}
