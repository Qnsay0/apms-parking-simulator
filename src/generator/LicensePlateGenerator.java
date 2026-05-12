package generator;
import java.util.Random;

public class LicensePlateGenerator {


    // Metoda do generowania losowego numeru rejestracyjnego
    public static String generatorPlateNumber(){
        Random random = new Random();
        return "DW" + (random.nextInt(900000) + 100000);
    }

}
