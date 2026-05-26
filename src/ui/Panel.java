package ui;

import javax.swing.*;
import generator.Generator;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import model.Vehicle;
import ui.dateWindow.DateWindow;

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

        ParkingSlot.ParkingSpot parkingSpot;

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
    private ParkingSlot parkingManager = new ParkingSlot();





    private DateWindow dateWindow = new DateWindow();

    Random random = new Random();



   public Panel() {
        setBackground(Color.DARK_GRAY);
        Timer textUpdateTimer = new Timer(200, e -> {
            
            
            int currentCars = 0;
            int currentTrucks = 0;
            int currentMotos = 0;

          
            for (PositionedVehicle pv : activeVehicles) {
                if (pv.vehicle.getType() == Vehicle.VehicleType.osobowy) {
                    currentCars++;
                } else if (pv.vehicle.getType() == Vehicle.VehicleType.ciezarowy) {
                    currentTrucks++;
                } else if (pv.vehicle.getType() == Vehicle.VehicleType.motocykl) {
                    currentMotos++;
                }
            }

            
            int currentTotalVehicles = activeVehicles.size(); 
            
            // 3. Aktualizujemy okno prawidłowymi, obecnymi wartościami
            dateWindow.updateCarValue(currentCars);
            dateWindow.updateTruckValue(currentTrucks);
            dateWindow.updateMotoValue(currentMotos);
            dateWindow.updateVehicleValue(currentTotalVehicles); 
            
            repaint(); 
        });
        textUpdateTimer.start();
        dateWindow.setVisible(true);
    }

   public void spawnNewVehicle() {
        Vehicle v = vehicleGenerator.GenerateRandom();
        
        
        if (v != null) {
            
            ParkingSlot.ParkingSpot spot = parkingManager.getRandomFreeSpot();
            
            if (spot == null) {
                return;
            }


            spot.isOccupied = true;

            int startY;
          
            if (spot.row == config.Configuration.PARKING_ROW_Y[0]) {
                startY = 90;
            } else {
                startY = 290; 
            }

            int destinationX = spot.x;
            int destinationY = spot.row - v.getLength() + 45;
            PositionedVehicle pv = new PositionedVehicle(v, 0, startY, destinationX, destinationY, startY);
            pv.parkingSpot = spot;
            activeVehicles.add(pv);
            repaint();
        }
    }


   public void moveAllVehicles() {
        for (PositionedVehicle pv : activeVehicles) {
            switch (pv.state) {
                case 0:
                    pv.isVertical=false;
                    if (Math.abs(pv.x - pv.targetX) <= 5) {
                        pv.x = pv.targetX;
                        pv.state = 1; 
                    } else {
                        pv.x += 5;
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
                        if (pv.parkingSpot != null) {
                            pv.parkingSpot.isOccupied = true;
                        }
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
       activeVehicles.removeIf(pv -> {
            if(pv.x > 500){
             
                if (pv.parkingSpot != null) {
                    pv.parkingSpot.isOccupied = false;
                }
                return true; 
            }
            return false;
        });
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