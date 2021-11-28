import javax.swing.*;
import java.util.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class FenetreGraphique extends JFrame {
    ZoneDessin zoneDessin;
    Menu menu;
    Pente pente;
    static boolean jeux;

    FenetreGraphique(String nom)
    {
        super(nom);
        jeux = false;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        setSize((int)width, (int)height);
        setResizable(true);
        setLocationRelativeTo(null);
        setAlwaysOnTop(false);
            
        if (!jeux) {
            menu = new Menu();
            setContentPane(menu);
        }

        else {
            pente = new Pente();
            setContentPane(pente);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
