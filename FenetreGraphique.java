import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.*;

public class FenetreGraphique extends JFrame implements ActionListener {
    Menu menu;
    Pente pente;
    FenetreOption fenetreOption;
    static Sounds sounds;
    static int window = 1, vien_de = 1;
    static float lvlSound = -30;
    static boolean changement = true, fullscreen = false, changeScreen = false, affiche_fps = false, putSong = true;
    static double fps;
    static String nom1, nom2;

    FenetreGraphique(String nom) {
        super(nom);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double _width = screenSize.getWidth();
        double _height = screenSize.getHeight();
        setSize((int) _width, (int) _height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(false);

        sounds = new Sounds("sounds/Menu.wav");
        sounds.setVolume(-60);

        long temps_avant = System.nanoTime();
        long temps_apres = System.nanoTime();
        while (true) {

            temps_avant = System.nanoTime();

            double despacito = (temps_avant - temps_apres) / 1000000000.0;

            fps = 1 / despacito;
            temps_apres = temps_avant;

            if ((!sounds.isRunning() || changement && window == 1 || changement && window == 2) && putSong) {
                playMusic();
            }

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

                        if (vien_de == 1) {
                            if(pente == null)
                            {
                                nom1 = JOptionPane.showInputDialog(null, "Entrer le nom du J1", "Joueur 1");
                                nom2 = JOptionPane.showInputDialog(null, "Entrer le nom du J2", "Joueur 2");
                            }
                            pente = new Pente();
                            menu = null;
                        }

                        vien_de = window;

                        System.out.println("Jeux");
                        pente.setLayout(null);
                        setContentPane(pente);

                        break;
                    }

                    case 3: {

                        fenetreOption = new FenetreOption(this);

                        window = vien_de;
                        break;
                    }

                    default:
                        break;
                }

            }

            repaint();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

    }

    public static void playMusic() {
        if (window == 1 || (window == 3 && vien_de == 1)) {
            sounds.stop();
            sounds = new Sounds("sounds/Menu.wav");
            sounds.setVolume(lvlSound);
            sounds.play();
        }

        else if (window == 2 || (window == 3 && vien_de == 2)) {
            sounds.stop();
            sounds = new Sounds("sounds/InGame.wav");
            sounds.setVolume(lvlSound);
            sounds.play();
        }
    }

    public void changementDeScreen() {
        changeScreen = false;
        dispose();

        if (fullscreen) {
            setUndecorated(true);
        }

        else if (!fullscreen) {
            setUndecorated(false);
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {

    }

}