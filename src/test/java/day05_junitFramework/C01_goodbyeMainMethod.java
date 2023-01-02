package day05_junitFramework;

import org.junit.Ignore;
import org.junit.Test;

public class C01_goodbyeMainMethod {

    @Test
    public void test01(){
        System.out.println("test01 calisti");
        // @Test notasyonu sayesinde her bir test method'u bagimsiz olarak calisabilir
        // eger testin icerisinde bir assertion yoksa
        // kod problem yasanmadan calisip bittiginde
        // JUnit test passed olarak raporlar
    }

    @Test @Ignore
    public void test02(){
        System.out.println("test02 calisti");
        //@Ignore notasyonu yazıldığı test metohd'unun çalıştırılmamasını sağlar.
    }

    @Test
    public void test03(){
        System.out.println("test03 calisti");
    }
}
