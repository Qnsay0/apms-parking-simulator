package ui.Screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import javax.swing.*;

public class DataView extends JFrame {

    private int vehicleValue;
    private int carValue;
    private int truckValue;
    private int motoValue;

    private JPanel drawPanel;

    public DataView() {
        createDataWindow();
        drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); 
                Graphics2D g2d = (Graphics2D) g;

                g2d.setColor(Color.BLACK); 
                g2d.setFont(new Font("Arial", Font.BOLD, 15)); 

            
                String layoutMessage = "Wszystkie pojazdy: " + vehicleValue + "\n"
                                     + "Samochody osobowe: " + carValue + "\n"
                                     + "Ciężarówki: " + truckValue + "\n"
                                     + "Motocykle: " + motoValue;
               
                int startX = 20;
                int y = 30;
                int lineSpacing = 25;
                
                for (String line : layoutMessage.split("\n")) {
                    g2d.drawString(line, startX, y);
                    y += lineSpacing;
                }
            }
        };
        
        drawPanel.setBackground(Color.WHITE); 
        add(drawPanel); 
    }

    private void createDataWindow(){
        setTitle(config.Configuration.DATA_SCREEN_NAME);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setSize(config.Configuration.DATA_SCREEN_SIZE[0], config.Configuration.DATA_SCREEN_SIZE[1]);
        setLocationRelativeTo(null);
    }



    public void updateVehicleValue(int vehicleValueUpdate) {
        this.vehicleValue = vehicleValueUpdate; 
        drawPanel.repaint();      
    }

    public void updateCarValue(int carValueUpdate) {
        this.carValue = carValueUpdate;
        drawPanel.repaint();
    }

    public void updateTruckValue(int truckValueUpdate) {
        this.truckValue = truckValueUpdate;
        drawPanel.repaint();
    }

    public void updateMotoValue(int motoValueUpdate) {
        this.motoValue = motoValueUpdate;
        drawPanel.repaint();
    }
}