package app;

import javax.swing.Timer;

import app.ui.ChartPanel;
import app.ui.Panel;
import app.ui.Screens.ChartView;
import app.ui.Screens.ControlView;
import app.ui.Screens.SimulatorView; 

public class APMSLauncher {

    public static Timer moveTimer;
    public static Timer spawnTimer;

    public static void main(String[] args) {
        SimulatorView parking = new SimulatorView();
        Panel myPanel = new Panel(); 

        ChartView chartwindow = new ChartView();
        ChartPanel myChartPanel = new ChartPanel();
        
        parking.setContentPane(myPanel);
        parking.setVisible(true);

        chartwindow.setContentPane(myChartPanel);
        chartwindow.setVisible(true);

        ControlView controlWindow = new ControlView();
        controlWindow.setVisible(true);

        
        moveTimer = new Timer(app.config.Configuration.MOVE_ALL_VEHICLES_DELAY, e -> {
            myPanel.moveAllVehicles();
            int occupiedCount = myPanel.occupiedCount();
            myChartPanel.updateChart(occupiedCount);
        });
        moveTimer.start();

        
        spawnTimer = new Timer(app.config.Configuration.SPAWN_VEHICLE_DELAY, e -> {
            myPanel.spawnNewVehicle();
           
        });
        spawnTimer.start();
        myPanel.spawnNewVehicle();
    }
}