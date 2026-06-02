package ui;

import javax.swing.*;
import generator.Generator;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import model.Vehicle;
import ui.Background.Background;
import ui.Screens.DateView;
import model.ParkingSpace;
import java.util.Random;

public class Panel extends JPanel {
    
    // Konstruktor dot. pojazdów - wyznaczania ich miejsca docelowego, startu oraz state (stanu)
    private class PositionedVehicle {
        Vehicle vehicle;
        int x, y;
        int startY;
        int state;
        long waitStartTime = 0;
        int targetX, targetY;
        boolean isVertical = false;

        ParkingSpace parkingSpace;

        PositionedVehicle(Vehicle vehicle, int x, int y, int targetX, int targetY, int startY) {
            this.vehicle = vehicle;
            this.x = x;
            this.y = y;
            this.startY = startY;
            this.targetX = targetX;
            this.targetY = targetY;
        }
    }

    // Tworzenie nowych obiekótw wykorzystywanych do poprawnego działania symulacji
    private List<PositionedVehicle> activeVehicles = new ArrayList<>();
    private Generator vehicleGenerator = new Generator();
    private VehicleRender vehiclerender = new VehicleRender();
    private ParkingSpace parkingManager = new ParkingSpace(0, 0, Vehicle.VehicleType.osobowy, false);
    private DateView dateWindow = new DateView();
    Random random = new Random();

    public Panel() {
        setBackground(Color.DARK_GRAY);
        Timer textUpdateTimer = new Timer(config.Configuration.STATS_UPDATE_DELAY, e -> {
            
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
            
            ParkingSpace spot = parkingManager.getRandomFreeSpot(v.getType());
            
            if (spot == null) {
                return;
            }

            spot.occupied = true;

            int startY = calculateStartY(spot.y);;
        
            

            int destinationX = spot.x;
            int destinationY = spot.y;
            PositionedVehicle pv = new PositionedVehicle(v, 0, startY, destinationX, destinationY, startY);
            pv.parkingSpace = spot;
            activeVehicles.add(pv);
            repaint();
        }
    }
    private int calculateStartY(int spotY) {
        if (spotY < 100) return 100;
        if (spotY < 270) return 150;
        if (spotY < 380) return 370;
        return 430; 
    }
 
    // Tutaj zmienić kod na wzorzec !!!

    public void moveAllVehicles() {
        for (PositionedVehicle pv : activeVehicles) {
            switch (pv.state) {
                case 0:
                    pv.isVertical = false;
                    if (Math.abs(pv.x - pv.targetX) <= 5) {
                        pv.x = pv.targetX;
                        pv.state = 1; 
                    } else {
                        pv.x += 5;
                    }
                    break;

                case 1:
                    pv.isVertical = true;
                    if (pv.y < pv.targetY) {
                        pv.y += 5;
                    } else if(pv.y > pv.targetY) {
                        pv.y -= 5;
                    }else {
                        pv.state = 2;
                        pv.waitStartTime = System.currentTimeMillis(); 
                    }
                    break;

                case 2: 
                    if (System.currentTimeMillis() - pv.waitStartTime >= config.Configuration.SPOT_OCCUPATING_TIME) {
                        pv.state = 3; 
                       
                    }
                    break;

                case 3: 
                    if (pv.y > pv.startY) {
                        pv.y -= 5;
                    } else if(pv.y < pv.startY) {
                         pv.y += 5;
                    }else{
                        pv.state = 4;
                    }
                    break;

                case 4:
                    pv.isVertical = false;
                    pv.x += 5;
                    break;
            }
        }
        activeVehicles.removeIf(pv -> {
           
            if(pv.x > 1200){
             
                if (pv.parkingSpace != null) {
                    pv.parkingSpace.occupied = false; 
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

    // Zamiana nazwy koloru na właściwy kolor
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


    // Funckja zajmująca się rysowaniem pojazdów
    public void drawVehicle(Graphics g, Vehicle vehicle, Vehicle.Color color, Vehicle.VehicleType type, int x, int y, boolean isVertical) {
        Graphics2D g2d = (Graphics2D) g;
        if (type == null || vehicle == null) return;

        Color awtColor = convertColorEnum(vehicle.getColor());

        vehiclerender.draw(g2d, vehicle, x, y, awtColor, isVertical);
    }
}