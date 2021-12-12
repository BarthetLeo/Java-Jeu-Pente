import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

public class FenetreOption extends JFrame implements ActionListener {

    FenetreGraphique f_g;
    Options options;
    OptionsGameplay optionsGameplay;
    OptionsSounds optionsSounds;
    static boolean show = true, changement = true;
    static int window = 1, vien_de = 1;

    /**
     * Création d'une fenêtre d'option passant par dessus celle du jeux avec une
     * opacité de 0.9
     * 
     * @param FenetreGraphique f_g
     */
    FenetreOption(FenetreGraphique f_g) {
        this.f_g = f_g;

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
        options.setLayout(null);
        setContentPane(options);

        // création des valeurs pour la création des fps
        long temps_avant = System.nanoTime();
        long temps_apres = System.nanoTime();
        while (show) { // Boucle de la fonction qui dit qui continue tant qu on fait pas revenir dans
            // les options
            temps_avant = System.nanoTime();

            double temps = (temps_avant - temps_apres) / 1000000000.0;

            FenetreGraphique.fps = 1 / temps;
            temps_apres = temps_avant;

            if (!FenetreGraphique.sounds.isRunning() && FenetreGraphique.putSong) {
                FenetreGraphique.playMusic();
            }

            if (changement) { // Si on change d'interface
                changement = false;

                switch (window) {

                    case 1: { // Option Affichage

                        if (vien_de == 2) {
                            optionsSounds = null;
                        }

                        options = new Options(this);

                        vien_de = window;
                        options.setLayout(null);
                        setContentPane(options);

                        break;
                    }

                    case 2: { // Option Son

                        if (vien_de == 1) {
                            options = null;
                        }

                        optionsSounds = new OptionsSounds(this);

                        vien_de = window;

                        optionsSounds.setLayout(null);
                        setContentPane(optionsSounds);

                        break;
                    }

                    case 3: { // Les options de Gameplay

                        if (vien_de == 2) {
                            optionsSounds = null;
                        }

                        if (vien_de == 1) {
                            options = null;
                        }

                        optionsGameplay = new OptionsGameplay(this);

                        vien_de = window;
                        optionsGameplay.setLayout(null);
                        setContentPane(optionsGameplay);

                        break;
                    }
                    case 4: { // Regles du jeux

                        Regle regle = new Regle();
                        regle.setLayout(null);
                        setContentPane(regle);
                    }

                    default:
                        break;
                }

            }

            repaint();
            setDefaultCloseOperation(FenetreOption.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent event) {

    }

}
