package generator;

import model.Vehicle;
import generator.LicensePlateGenerator;
import java.util.Random;


public class Generator {
    private final Random random;

    public Generator(){
        this.random = new Random();
    }

    public Vehicle GenerateRandom(){
        //losowanie typu pojazdu
        Vehicle.VehicleType[] types = Vehicle.VehicleType.values();
        Vehicle.VehicleType type = types[random.nextInt(types.length)];
        
        //losowanie marki
        Vehicle.Brand[] brands = Vehicle.Brand.values();
        Vehicle.Brand brand = brands[random.nextInt(brands.length)];

        //losowanie koloru
        Vehicle.Color[] colors = Vehicle.Color.values();
        Vehicle.Color color = colors[random.nextInt(colors.length)];

        // 1. Generowanie losowego numeru rejestracyjnego za pomocą LicensePlateGenerator
        String licensePlate = LicensePlateGenerator.generatorPlateNumber(); 

        // 2. Przekazujemy ten String do konstruktora Vehicle
        return new Vehicle(type, brand, color, licensePlate);
       
    }
}
