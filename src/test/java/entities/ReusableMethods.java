package entities;

public class ReusableMethods {

    public static void wait(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e){

        }
    }
}