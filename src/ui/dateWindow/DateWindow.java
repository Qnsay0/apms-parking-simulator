package ui.dateWindow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import javax.swing.*;




public class DateWindow extends JFrame {

    public String statusText = ""; 
    private JPanel drawPanel; // Zapisujemy panel jako pole klasy, żeby móc go odświeżać

    public DateWindow() {
        setTitle("App Date");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setSize(400, 700);
        setLocationRelativeTo(null);
        
        drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); 
                Graphics2D g2d = (Graphics2D) g;

                g2d.setColor(Color.BLACK); 
                g2d.setFont(new Font("Arial", Font.BOLD, 12)); 
                g2d.drawString(statusText, 20, 30);
            }
        };
        
        drawPanel.setBackground(Color.WHITE); 
        add(drawPanel); 
        
    }

    public void updateText(String newText) {
        this.statusText = newText; 
        System.out.println(newText);
        drawPanel.repaint();      
    }


    
}
