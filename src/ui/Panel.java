package ui;

import javax.swing.*;
import generator.Generator;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import model.Vehicle;
import java.util.Random;

public class Panel extends JPanel {
   
    private class PositionedVehicle {
        Vehicle vehicle;
        int x, y;
        int startY;
        int state;
        long waitStartTime = 0;
        int targetX, targetY;
        boolean isVertical=false;

        PositionedVehicle(Vehicle vehicle, int x, int y, int targetX, int targetY, int startY) {
            this.vehicle = vehicle;
            this.x = x;
            this.y = y;
            this.startY = startY;
            this.targetX = targetX;
            this.targetY = targetY;
        }
    }

    private List<PositionedVehicle> activeVehicles = new ArrayList<>();
    private Generator vehicleGenerator = new Generator();
    private VehicleRender vehiclerender = new VehicleRender();
    int[] possibleParkingSlotsX = {50,200,350,500};

    Random random = new Random();


    public Panel() {
        setBackground(Color.DARK_GRAY);
    }

    public void spawnNewVehicle() {
        Vehicle v = vehicleGenerator.GenerateRandom();

        if (v != null) {
            int startY = (random.nextInt(2)+1 == 1) ? 50 : 250;
            
            int destinationX = possibleParkingSlotsX[random.nextInt(possibleParkingSlotsX.length)];
            int destinationY = startY + 100;
            activeVehicles.add(new PositionedVehicle(v, 0, startY, destinationX, destinationY,startY));
            repaint();
        }
    }

   public void moveAllVehicles() {
        for (PositionedVehicle pv : activeVehicles) {
            switch (pv.state) {
                case 0:
                    pv.isVertical=false;
                    if (pv.x < pv.targetX) {
                        pv.x += 5;
                    } else {
                        pv.state = 1; 
                    }
                    break;

                case 1:
                    pv.isVertical=true;
                    if (pv.y < pv.targetY) {
                        pv.y += 5;
                    } else {
                        pv.state = 2;
                        pv.waitStartTime = System.currentTimeMillis(); 
                    }
                    break;

                case 2: 
                    if (System.currentTimeMillis() - pv.waitStartTime >= 5000) {
                        pv.state = 3; 
                    }
                    break;

                case 3: 
                    if (pv.y > pv.startY) {
                        pv.y -= 5;
                    } else {
                        pv.state = 4; 
                    }
                    break;

                case 4:
                    pv.isVertical=false;
                    pv.x += 5;
                    break;
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Background.drawBackground(g2d);

        for (PositionedVehicle pv : activeVehicles) {
            drawVehicle(g2d, pv.vehicle, pv.vehicle.getColor(), pv.vehicle.getType(), pv.x, pv.y, pv.isVertical);
        }
    }


    private Color convertColorEnum(Vehicle.Color vehicleColor) {
        if (vehicleColor == null) return Color.BLACK;
        switch (vehicleColor) {
            case czerwony: return Color.RED;
            case niebieski: return Color.BLUE;
            case bialy: return Color.WHITE;
            case szary: return Color.GRAY;
            case czarny: return Color.BLACK;
            default: return Color.BLACK;
        }
    }

    public void drawVehicle(Graphics g, Vehicle vehicle, Vehicle.Color color, Vehicle.VehicleType type, int x, int y, boolean isVertical) {
        Graphics2D g2d = (Graphics2D) g;
        if (type == null || vehicle == null) return;

        Color awtColor = convertColorEnum(vehicle.getColor());

        vehiclerender.draw(g2d, vehicle, x, y, awtColor, isVertical);

    }
}