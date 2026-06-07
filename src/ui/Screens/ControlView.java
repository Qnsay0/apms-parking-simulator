package ui.Screens;

import javax.swing.*;
import java.awt.*;
import config.Configuration;
import app.APMSLauncher;

public class ControlView extends JFrame {

    public ControlView(){
        setTitle("Panel Sterowania");
        setSize(300,100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(100,450);
        setLayout(new FlowLayout());

        JButton btnSlow = new JButton("Wolno");
        JButton btnNormal = new JButton("Normalnie");
        JButton btnFast = new JButton("Szybko");

        btnSlow.addActionListener(e -> {
            Configuration.SPAWN_VEHICLE_DELAY=500;
            Configuration.MOVE_ALL_VEHICLES_DELAY=25;
            Configuration.SPOT_OCCUPATING_TIME=10000;

            if(APMSLauncher.spawnTimer != null) APMSLauncher.spawnTimer.setDelay(500);
            if(APMSLauncher.moveTimer != null) APMSLauncher.moveTimer.setDelay(25);
        });

        btnNormal.addActionListener(e -> {
            Configuration.SPAWN_VEHICLE_DELAY=100;
            Configuration.MOVE_ALL_VEHICLES_DELAY=10;
            Configuration.SPOT_OCCUPATING_TIME=5000;

            if(APMSLauncher.spawnTimer != null) APMSLauncher.spawnTimer.setDelay(100);
            if(APMSLauncher.moveTimer != null) APMSLauncher.moveTimer.setDelay(10);
        });

        btnFast.addActionListener(e -> {
            Configuration.SPAWN_VEHICLE_DELAY=30;
            Configuration.MOVE_ALL_VEHICLES_DELAY=3;
            Configuration.SPOT_OCCUPATING_TIME=1500;

            if(APMSLauncher.spawnTimer != null) APMSLauncher.spawnTimer.setDelay(30);
            if(APMSLauncher.moveTimer != null) APMSLauncher.moveTimer.setDelay(3);
        });

        add(btnSlow);
        add(btnNormal);
        add(btnFast);
    }
}
