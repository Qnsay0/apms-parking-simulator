import ui.Panel;
import ui.Screens.DateView;
import ui.Screens.SimulatorView;

import javax.swing.Timer; 

public class APMSLauncher {

    public static void main(String[] args) {
        SimulatorView parking = new SimulatorView();
        Panel myPanel = new Panel(); 

    
        
        parking.setContentPane(myPanel);
        parking.setVisible(true);

        
        Timer moveTimer = new Timer(config.Configuration.MOVE_ALL_VEHICLES_DELAY, e -> {
            myPanel.moveAllVehicles(); 
        });
        moveTimer.start();

        
        Timer spawnTimer = new Timer(config.Configuration.SPAWN_VEHICLE_DELAY, e -> {
            myPanel.spawnNewVehicle();
           
        });
        spawnTimer.start();
        myPanel.spawnNewVehicle();
    }
}