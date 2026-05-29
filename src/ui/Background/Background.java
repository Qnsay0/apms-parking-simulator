package ui.Background;

import java.awt.*;

public class Background{

    public static void drawBackground(Graphics2D g2d) {


        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(3));

        //rysowanie lini poziomych
        g2d.drawLine(0, 0, 800,0);
        g2d.drawLine(0, 270, 800, 270);
        g2d.drawLine(0, 540, 800, 540);

        //dla motocykli
        g2d.drawLine(800, 25, 1000, 25);
        g2d.drawLine(800, 245, 1000, 245);
        g2d.drawLine(800, 295, 1000, 295);
        g2d.drawLine(800, 515, 1000, 515);


        //rysowanie pionowych dla samochodow
        for(int i=0; i<=800; i+=50){
            g2d.drawLine(i, 195, i, 345);
            g2d.drawLine(i, 0, i, 75);
            g2d.drawLine(i, 465, i, 540);
        }
        //rysowanie pionowych dla motocykli
        for(int i=800; i<=1000; i+=40){
            g2d.drawLine(i, 25, i, 75);
            g2d.drawLine(i, 195, i, 245);
            g2d.drawLine(i, 295, i, 345);
            g2d.drawLine(i, 465, i, 515);
        }

        //rysowanie jezdni
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 80, 1000, 110);
        g2d.fillRect(0, 350, 1000, 110);

        //rysowanie pasow
        g2d.setColor(Color.WHITE);
        for(int i=0; i<1000; i+=40){
            g2d.fillRect(i, 135, 20, 2);
            g2d.fillRect(i, 405, 20, 2);
        }
    }
}
