import javax.swing.JFrame;
//import java.util.*;
import java.awt.Dimension;
//import javax.swing.*;
import java.awt.Toolkit;
//import java.awt.*;
import java.awt.event.*;

public class FenetreOption extends JFrame implements ActionListener{

    Options options;
    static boolean show = true;

    FenetreOption(String nom) {

        super(nom);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double _width = screenSize.getWidth();
        double _height = screenSize.getHeight();
        setSize((int) _width, (int) _height);
        setUndecorated(true);
        setOpacity(0.9f);
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(false);

        options = new Options(this);
        System.out.println("Options");
        options.setLayout(null);
        setContentPane(options);

        long temps_avant = System.nanoTime();
        long temps_apres = System.nanoTime();
        while (show) {
            temps_avant = System.nanoTime();

            double despacito = (temps_avant - temps_apres) / 1000000000.0;

            FenetreGraphique.fps = 1 / despacito;
            temps_apres = temps_avant;

            repaint();
            setDefaultCloseOperation(FenetreOption.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent event) {

    }

}
