import javax.swing.JFrame;
//import java.util.*;
import java.awt.Dimension;
//import javax.swing.*;
import java.awt.Toolkit;
//import java.awt.*;
import java.awt.event.*;

public class FenetreOption extends JFrame implements ActionListener {

    FenetreGraphique f_g;
    Options options;
    OptionsGameplay optionsGameplay;
    OptionsSounds optionsSounds;
    static boolean show = true, changement = true;
    static int window = 1, vien_de = 1;

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

        long temps_avant = System.nanoTime();
        long temps_apres = System.nanoTime();
        while (show) {
            temps_avant = System.nanoTime();

            double despacito = (temps_avant - temps_apres) / 1000000000.0;

            FenetreGraphique.fps = 1 / despacito;
            temps_apres = temps_avant;

            if (!FenetreGraphique.sounds.isRunning() && FenetreGraphique.putSong) {
                FenetreGraphique.playMusic();
            }

            if (changement) {
                changement = false;

                switch (window) {
                    case 1: {

                        if (vien_de == 2) {
                            optionsSounds = null;
                        }

                        options = new Options(this);

                        vien_de = window;
                        options.setLayout(null);
                        setContentPane(options);

                        break;
                    }

                    case 2: {

                        if (vien_de == 1) {
                            options = null;
                        }

                        optionsSounds = new OptionsSounds(this);

                        vien_de = window;

                        optionsSounds.setLayout(null);
                        setContentPane(optionsSounds);

                        break;
                    }

                    case 3: {

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
                    case 4:{
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
