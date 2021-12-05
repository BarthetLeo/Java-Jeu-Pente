import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Hub extends JPanel implements ActionListener {

    Options options;
    Menu menu;
    Pente pente;
    static double fps;
    static String nom1, nom2;
    static boolean changement = true, changeScreen = false, fullscreen = false;
    static int window = 1, vient_de = 1;

    Hub() {

        FenetreGraphique f = new FenetreGraphique("Jeux");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // double _width = screenSize.getWidth();
        // double _height = screenSize.getHeight();

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

                        if (vient_de == 2) {
                            pente = null;
                        }

                        else if (vient_de == 3) {
                            options = null;
                        }

                        menu = new Menu();
                        setPreferredSize(screenSize);

                        vient_de = window;
                        menu.setLayout(null);
                        f.add(menu);
                        System.out.println("Menu");

                        break;
                    }

                    case 2: {

                        if (vient_de == 1) {
                            menu = null;
                        }

                        else if (vient_de == 3) {
                            options = null;
                        }

                        pente = new Pente();
                        setPreferredSize(screenSize);

                        vient_de = window;

                        System.out.println("Jeux");
                        pente.setLayout(null);
                        f.add(pente);
                        nom1 = JOptionPane.showInputDialog(null, "Entrer le nom du J1", "Joueur 1");
                        nom2 = JOptionPane.showInputDialog(null, "Entrer le nom du J2", "Joueur 2");

                        break;
                    }

                    case 3: {

                        vient_de = window;
                        options = new Options();
                        System.out.println("Options");

                        f.remove(menu);
                        menu.setEnabled(false);
                        f.add(menu);
                        // menu.invalidate();
                        // menu.requestFocus(false);

                        options.setBackground(new Color(90, 90, 90, 123));
                        options.setLayout(null);
                        options.setOpaque(true);
                        f.add(options);

                        break;
                    }

                    default:
                        break;
                }

                if (changeScreen) {

                    f.changeDeScreen();
                }

            }

            repaint();
            f.setVisible(true);
        }
    }

    public void oui(Graphics g) {
        update(g);
    }

    public void actionPerformed(ActionEvent event) {

    }
}
