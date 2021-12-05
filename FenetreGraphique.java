import javax.swing.*;
//import java.util.*;
//import java.awt.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.*;

public class FenetreGraphique extends JFrame implements ActionListener {

    static boolean affiche_fps = false;
    Options options;
    Menu menu;
    Pente pente;
    static double fps;
    static String nom1, nom2;
    static boolean changement = true, changeScreen = false, fullscreen = false;
    static int window = 1, vient_de = 1;

    FenetreGraphique(String nom) {
        super(nom);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

        long temps_avant = System.nanoTime();
        long temps_apres = System.nanoTime();
        while (true) {

            temps_avant = System.nanoTime();

            double despacito = (temps_avant - temps_apres) / 1000000000.0;

            fps = 1 / despacito;
            temps_apres = temps_avant;

            if (changement) {
                changement = false;

                switch (window) {
                    case 1: {
                        // background = 1;
                        // Dimension screenSize = getSize();
                        // int width = getWidth();
                        // double height = screenSize.getHeight();

                        // System.out.println("width : " + width);
                        menu = new Menu();

                        if (vient_de == 2) {
                            pente = null;
                        }

                        vient_de = window;
                        menu.setLayout(null);
                        System.out.println("Menu");
                        setContentPane(menu);

                        break;
                    }

                    case 2: {

                        // background = 2;

                        // Dimension screenSize = getSize();
                        // int width = getWidth();
                        // double height = screenSize.getHeight();

                        pente = new Pente();

                        if (vient_de == 1) {
                            menu = null;
                        }

                        vient_de = window;

                        System.out.println("Jeux");
                        pente.setLayout(null);
                        setContentPane(pente);
                        nom1 = JOptionPane.showInputDialog(null, "Entrer le nom du J1", "Joueur 1");
                        nom2 = JOptionPane.showInputDialog(null, "Entrer le nom du J2", "Joueur 2");

                        break;
                    }

                    case 3: {

                        options = new Options();
                        System.out.println("Options");
                        options.setLayout(null);
                        setContentPane(options);

                        break;
                    }

                    default:
                        break;
                }

                if (changeScreen) {

                    changeScreen = false;
                    dispose();

                    if (fullscreen) {
                        setUndecorated(true);
                    }

                    else if (!fullscreen) {
                        setUndecorated(false);
                    }
                }

            }
        }

            // int width = getWidth();
            // double height = screenSize.getHeight();
        }

    public void actionPerformed(ActionEvent event) {

    }

}