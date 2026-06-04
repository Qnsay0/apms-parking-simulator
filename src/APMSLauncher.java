import ui.ChartPanel;
import ui.Panel;
import ui.Screens.ChartView;
import ui.Screens.DateView;
import ui.Screens.SimulatorView;

import javax.swing.Timer; 

public class APMSLauncher {

    public static void main(String[] args) {
        SimulatorView parking = new SimulatorView();
        Panel myPanel = new Panel(); 

        ChartView chartwindow = new ChartView();
        ChartPanel myChartPanel = new ChartPanel();
        
        parking.setContentPane(myPanel);
        parking.setVisible(true);

        chartwindow.setContentPane(myChartPanel);
        chartwindow.setVisible(true);

        
        Timer moveTimer = new Timer(config.Configuration.MOVE_ALL_VEHICLES_DELAY, e -> {
            myPanel.moveAllVehicles();
            int occupiedCount = myPanel.occupiedCount();
            myChartPanel.updateChart(occupiedCount);
        });
        moveTimer.start();

        
        Timer spawnTimer = new Timer(config.Configuration.SPAWN_VEHICLE_DELAY, e -> {
            myPanel.spawnNewVehicle();
           
        });
        spawnTimer.start();
        myPanel.spawnNewVehicle();
    }
}