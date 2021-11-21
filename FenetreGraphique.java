import javax.swing.*;
import java.util.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class FenetreGraphique extends JFrame {
    ZoneDessin zoneDessin;

    FenetreGraphique(String nom)
    {
        super(nom);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
            
        setSize((int)width, (int)height);
        setResizable(true);
        setLocationRelativeTo(null);
        setAlwaysOnTop(false);

        setVisible(true);
    }
}
