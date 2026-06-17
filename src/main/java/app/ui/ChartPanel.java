package app.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChartPanel extends JPanel {

    List<Integer> Lista= new ArrayList<>();

    //historia zapelnienia w formie listy
    public ChartPanel(){
        setBackground(Color.BLACK);
        for(int i=0; i<200; i++){
            Lista.add(0);
        }
    }

    //akutalizacja zapelnienia parkingu
    public void updateChart(int OccupiedSpacesCount){
        double spacescount=OccupiedSpacesCount;
        spacescount=(spacescount/84.0)*100;

        Lista.remove(0);
        Lista.add((int)spacescount);

        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(1.5, 1.5);

        //rysowanie linii wykresu
        g2d.setColor(Color.WHITE);
        g2d.drawLine(30, 10, 30, 110);
        g2d.drawLine(30, 110, 240, 110);

        //oznaczenia osi wykresu
        g2d.setFont(new Font("Arial", Font.PLAIN, 8));
        g2d.drawString("100%", 10, 15);
        g2d.drawString("75%", 10, 40);
        g2d.drawString("50%", 10, 65);
        g2d.drawString("25%", 10, 90);

        g2d.drawString("-200", 30, 120);
        g2d.drawString("-100", 130, 120);
        g2d.drawString("0", 230, 120);


        //rysowanie wartosci na wykresie
        g2d.setColor(Color.GRAY);
        for(int i=0; i<200; i++){
            int point=Lista.get(i);
            g2d.fillRect(30+i, (110-point), 1, 1);
        }

    }
}
