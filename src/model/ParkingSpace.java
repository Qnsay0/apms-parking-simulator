package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import config.Configuration;
public class ParkingSpace extends JPanel {

    public int x;
    public int y;
    public Vehicle.VehicleType typ;
    public boolean occupied;

    public List<ParkingSpace> parkingSpaces = new ArrayList<>();

    // Konstruktor dla głównego zarządcy miejsc parkingowych
    public ParkingSpace(int x, int y, Vehicle.VehicleType typ, boolean occupied) {
        this.x = x;
        this.y = y;
        this.typ = typ;
        this.occupied = occupied;
        
        // Tworzenie miejsc dla samochodów i ciężarówek
        for (int configX = 0; configX < 800; configX += 50) { 
            for (int currentY : config.Configuration.PARKING_SPACE_Y_CARS) {
               
                parkingSpaces.add(new ParkingSpace(configX, currentY, Vehicle.VehicleType.osobowy, false, true));
            }
        }

       // Tworzenie miejsc dla motocykli
        for (int configX = 800; configX < 1000; configX += 42) {
            for (int currentY : config.Configuration.PARKING_SPACE_Y_MOTO) {
                
                parkingSpaces.add(new ParkingSpace(configX, currentY, Vehicle.VehicleType.motocykl, false, true));
            }
        }
    }
        
    // Prywatny konstruktor dla miejsc parkingowych, które są częścią listy parkingSpaces
    private ParkingSpace(int x, int y, Vehicle.VehicleType typ, boolean occupied, boolean isSubSpot) {
        this.x = x;
        this.y = y;
        this.typ = typ;
        this.occupied = occupied;
        
    }

    // Metoda do pobierania losowego, wolnego miejsca parkingowego
    public ParkingSpace getRandomFreeSpot(Vehicle.VehicleType incomingVehicleType) {
        List<ParkingSpace> freeOnes = parkingSpaces.stream()
                .filter(s -> !s.occupied)
                .filter(s -> {
                    if(incomingVehicleType == Vehicle.VehicleType.motocykl) {
                        return s.typ == Vehicle.VehicleType.motocykl;
                    } else {
                        return s.typ == Vehicle.VehicleType.osobowy || s.typ == Vehicle.VehicleType.ciezarowy;
                    }
                })
                .toList();
                
        if (freeOnes.isEmpty()) {
            return null;
        }
        
        return freeOnes.get(new Random().nextInt(freeOnes.size()));
    }
}