package app.ui.Screens;

import java.awt.Color;
import javax.swing.*;


// Głowne okno symulacyjne - zawierające wizualizaje symulacji 
public class SimulatorView extends JFrame {
    public SimulatorView() {
        setTitle(app.config.Configuration.SIMULATOR_SCREEN_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(app.config.Configuration.SIMULATOR_SCREEN_SIZE[0], app.config.Configuration.SIMULATOR_SCREEN_SIZE[1]);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
    }
}