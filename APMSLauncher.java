import generator.Generator;
import model.Vehicle;
import ui.Panel;
import ui.Parking;



import javax.swing.Timer;

import config.Configuration; 



public class APMSLauncher {
    

    public static void main(String[] args) {
      
        ui.ParkingSlot parkingSystem = new ui.ParkingSlot();
        Panel myPanel = new Panel(parkingSystem); 
        
        Parking parking = new Parking(); 
        parking.setContentPane(myPanel);
        parking.setVisible(true);

        Timer moveTimer = new Timer(Configuration.MOVE_ALL_VEHICLES_DELAY, e -> {
            myPanel.moveAllVehicles(); 
        });
        moveTimer.start();

        
        Timer spawnTimer = new Timer(Configuration.SPAWN_VEHICLE_DELAY, e -> {
            myPanel.spawnNewVehicle();
        });
        spawnTimer.start();
        
      
        myPanel.spawnNewVehicle();
    }
}