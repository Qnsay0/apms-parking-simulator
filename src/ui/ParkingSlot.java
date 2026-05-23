package ui;

import java.util.ArrayList;
import javax.swing.*;
import java.util.List;
import java.util.Random;


public class ParkingSlot {
    
    public class ParkingSpot extends JPanel{
        public boolean isOccupied = false; 
        int x;
        int row;
        private ParkingSpot(int x, int row){
            this.x = x;
            this.row = row;
        }
    }

    public List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingSlot(){
        
        for(int x : config.Configuration.PAKRING_SLOT_X){
            parkingSpots.add(new ParkingSpot(x, config.Configuration.PARKING_ROW_Y[0]));
            parkingSpots.add(new ParkingSpot(x, config.Configuration.PARKING_ROW_Y[1]));

        }
    }

    public ParkingSpot getRandomFreeSpot(){
        List<ParkingSpot> freeOnes = parkingSpots.stream().filter(s -> !s.isOccupied).toList();
        if (freeOnes.isEmpty()) return null;
        return freeOnes.get(new Random().nextInt(freeOnes.size()));
    }


}
 


