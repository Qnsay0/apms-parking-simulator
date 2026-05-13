import generator.Generator;
import model.Vehicle;
import ui.Panel;
import ui.Parking;



import javax.swing.Timer; 

public class APMSLauncher {

    public static void main(String[] args) {
        Parking parking = new Parking();
        Panel myPanel = new Panel(); 
        
        parking.setContentPane(myPanel);
        parking.setVisible(true);

        
        Timer moveTimer = new Timer(30, e -> {
            myPanel.moveAllVehicles(); 
        });
        moveTimer.start();

        
        Timer spawnTimer = new Timer(1000, e -> {
            myPanel.spawnNewVehicle();
        });
        spawnTimer.start();
        
      
        myPanel.spawnNewVehicle();
    }
}