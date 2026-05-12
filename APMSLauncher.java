import generator.Generator;
import model.Vehicle;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import model.ParkingLot;

public class APMSLauncher {

  
    private static final int INITIAL_DELAY = 0;
    private static final int TIME_PERIOD_SECONDS = 5;

    public static void main(String[] args) {

      
        
        // Tworzymy scheduler do wykonywania zadania co określony czas
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        // Tworzymy generator pojazdów
        Generator vehicleGenerator = new Generator();

        System.out.println("Rozpoczynam symulację APMS...\n");

        // Definiujemy zadanie, które będzie wykonywane co określony czas
        Runnable task = () -> {
            Vehicle vehicle = vehicleGenerator.GenerateRandom();
            String vehicleInfo = String.format("Typ: %s, Marka: %s, Kolor: %s, Tablica: %s\n",
                    vehicle.getType(), vehicle.getBrand(), vehicle.getColor(), vehicle.getLicensePlate());
            System.out.print(vehicleInfo);
        };

        scheduler.scheduleAtFixedRate(task, INITIAL_DELAY, TIME_PERIOD_SECONDS, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nZatrzymywanie symulacji APMS...");
            scheduler.shutdown();
        }));
    }
}