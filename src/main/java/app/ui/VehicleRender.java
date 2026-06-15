package app.ui;

import java.awt.*;

import app.model.Vehicle;

public class VehicleRender {

    public void draw(Graphics2D g2d, Vehicle vehicle, int x, int y, Color awtColor, boolean isVertical) {
        //zapisywanie poprzedniego stanu, zeby nie obrocic calego parkingu ale sam pojazd
        java.awt.geom.AffineTransform oldTransform = g2d.getTransform();

        //obracanie pojazdów o [config.Configuration.VEHICLE_ROTATION] stopni.
        if (isVertical) {
            g2d.rotate(Math.toRadians(app.config.Configuration.VEHICLE_ROTATION), x + (vehicle.getLength() / 2.0), y + (vehicle.getWidth() / 2.0));
        }

        switch (vehicle.getType()) {
            case osobowy:
                drawCar(g2d, x, y, vehicle.getLength(), vehicle.getWidth(), awtColor);
                break;

            case ciezarowy:
                drawTruck(g2d, x, y, vehicle.getLength(), vehicle.getWidth(), awtColor);
                break;

            case motocykl:
                drawMotorcycle(g2d, x, y, vehicle.getLength(), vehicle.getWidth(), awtColor);
                break;
        }

        //przywracanie tla do stanu poczatkowego
        g2d.setTransform(oldTransform);
    }

    private void drawCar(Graphics2D g2d, int x, int y, int length, int width, Color color) {
     g2d.setColor(color);
     g2d.fillRect(x, y, length, width);

     g2d.setColor(new Color(50, 50, 50, 200));
     g2d.fillRect(x+5, y+2, length-10, width-4);

     g2d.setColor(new Color(255,255,255,100));
     g2d.fillRect(x+length-12,y+3,5,width-6);
    }

    private void drawTruck(Graphics2D g2d, int x, int y, int length, int width, Color color) {
        int trailerLength=(int)(length*0.7);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(x,y,trailerLength,width);

        g2d.setColor(color);
        g2d.fillRect(x+trailerLength+2, y+2, length-trailerLength, width-4);

        g2d.setColor(Color.BLACK);
        g2d.fillRect(x+length-6,y+4,3,width-8);
    }

    private void drawMotorcycle(Graphics2D g2d, int x, int y, int length, int width, Color color) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x, y+(width/2)-2, 8, 4);
        g2d.fillRect(x+length-8, y+(width/2)-2,8,4);

        g2d.setColor(color);
        g2d.fillOval(x+5,y+2,length-10,width-4);

        g2d.setColor(Color.DARK_GRAY);
        g2d.fillOval(x+length-15,y,6,6);
        g2d.fillOval(x+length-15, y+width-6, 6, 6);
    }

}

