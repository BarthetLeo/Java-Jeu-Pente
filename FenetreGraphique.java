import javax.swing.*;
//import java.util.*;
//import java.awt.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.*;

public class FenetreGraphique extends JFrame implements ActionListener {

    static boolean affiche_fps = false;

    FenetreGraphique(String nom) {
        super(nom);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void changeDeScreen() {

        Hub.changeScreen = false;
        dispose();

        if (Hub.fullscreen) {
            setUndecorated(true);
        }

        else if (!Hub.fullscreen) {
            setUndecorated(false);
        }
    }

    public void actionPerformed(ActionEvent event) {

    }

}