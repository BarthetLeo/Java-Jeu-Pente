import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Image;

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
        Image icon = Toolkit.getDefaultToolkit().getImage("graphics/images/Logo.png");
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

        setIconImage(icon);

        // création des valeurs pour la création des fps
        long temps_avant = System.nanoTime();
        long temps_apres = System.nanoTime();
        while (true) { // Boucle de la fonction qui dit qui continue tant qu on fait pas revenir dans
            // les options

            temps_avant = System.nanoTime();

            double temps = (temps_avant - temps_apres) / 1000000000.0;

            fps = 1 / temps;
            temps_apres = temps_avant;

            if ((!sounds.isRunning() || changement && window == 1 || changement && window == 2) && putSong) {
                playMusic();
            }

            if (changement) { // Si on change d'interface
                changement = false;

                switch (window) {
                    case 1: { // Menu
                        menu = new Menu();

                        if (vien_de == 2) {
                            pente = null;
                        }

                        vien_de = window;
                        menu.setLayout(null);
                        setContentPane(menu);

                        break;
                    }

                    case 2: { // jeux de pente

                        if (vien_de == 1) {
                            if (pente == null) {
                                nom1 = JOptionPane.showInputDialog(null, "Entrer le nom du J1", "Joueur 1");
                                nom2 = JOptionPane.showInputDialog(null, "Entrer le nom du J2", "Joueur 2");
                            }
                            pente = new Pente();
                            menu = null;
                        }

                        vien_de = window;

                        pente.setLayout(null);
                        setContentPane(pente);

                        break;
                    }

                    case 3: { // Les options

                        fenetreOption = new FenetreOption(this);

                        window = vien_de;
                        break;
                    }

                    case 4: { // Écran de victoire
                        FenetreGagne gagner = new FenetreGagne();
                        gagner.setLayout(null);
                        setContentPane(gagner);
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

    /**
     * Fonction static pour jouer la musique sous certaine condition
     */
    public static void playMusic() {
        if (window == 1 || (window == 3 && vien_de == 1)) { // Musique du Menu
            sounds.stop();
            sounds = new Sounds("/sounds/Menu.wav");
            sounds.setVolume(lvlSound);
            sounds.play();
        }

        else if (window == 2 || (window == 3 && vien_de == 2)) { // Musique du jeux
            sounds.stop();
            sounds = new Sounds("/sounds/InGame.wav");
            sounds.setVolume(lvlSound);
            sounds.play();
        }
    }

    /**
     * Fonction pour mettre ou enlever le fullscreen
     */
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