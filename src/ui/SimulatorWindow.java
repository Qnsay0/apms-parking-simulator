package ui;

import java.awt.Color;
import javax.swing.*;

public class SimulatorWindow extends JFrame {

    public SimulatorWindow() {
        setTitle("APMS - Parking Lot Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
    }


}