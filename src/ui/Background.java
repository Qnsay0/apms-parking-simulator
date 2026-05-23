package ui;

import javax.swing.*;
import generator.Generator;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import model.Vehicle;
import java.util.Random;
import config.Configuration;
public class Background{

    public static void drawBackground(Graphics2D g2d) {


        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(3));

        //rysowanie lini poziomych
        g2d.drawLine(0, 200, 500, 200);
        g2d.drawLine(0, 400, 500, 400);

        //rysowanie pionowych
        for(int i=0; i<=500; i+=50)
        {
            g2d.drawLine(i, 125, i, 200);
            g2d.drawLine(i, 325, i, 400);
        }
    }
}
