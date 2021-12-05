import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.*;

public class FenetreGraphique extends JFrame implements ActionListener {
    ZoneDessin zoneDessin;
    Options options;
    Menu menu;
    Pente pente;
    static int window;
    static boolean changement, fullscreen = false, changeScreen = false;
    static double fps;
    static boolean affiche_fps = false;
    static String nom1;
    static String nom2;
    static int vien_de = 1;

    FenetreGraphique(String nom) {
        super(nom);
        changement = true;
        window = 1;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double _width = screenSize.getWidth();
        double _height = screenSize.getHeight();
        setSize((int) _width, (int) _height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(false);

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
                        menu = new Menu();

                        if (vien_de == 2) {
                            pente = null;
                        }

                        vien_de = window;
                        menu.setLayout(null);
                        System.out.println("Menu");
                        setContentPane(menu);

                        break;
                    }

                    case 2: {
                        pente = new Pente();

                        if (vien_de == 1) {
                            menu = null;
                        }

                        vien_de = window;

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
            repaint();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

    }

    public void actionPerformed(ActionEvent event) {

    }

}