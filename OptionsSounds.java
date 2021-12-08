import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;

public class OptionsSounds extends JPanel implements ActionListener, ChangeListener {

    BufferedImage img;
    // private static boolean vien_jeu;
    // private String action_rev = "Revenir";
    private FenetreOption f_o;
    boolean changeSong = false;

    OptionsSounds(FenetreOption f_o) {

        try {
            img = ImageIO.read(new File("graphics/images/FondMenuOptions.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f_o = f_o;

        /*
         * if (vien_jeu) {
         * action_rev = "Revenir_Jeu";
         * }
         */

        creationBouton();
    }

    public void affiche_fond(Graphics g) {
        int hauteur = getHeight();
        int longueur = getWidth();
        g.setColor(Color.BLACK);
        g.drawImage(img, 0, 0, longueur, hauteur, null);
    }

    public void creationBouton() {

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 60, 30);
        slider.setLocation(400, 300);
        slider.setOpaque(false);
        slider.setSize(300, 200);

        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(10);

        slider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                if (!slider.getValueIsAdjusting()) {
                    FenetreGraphique.sounds.setVolume((float) (-60 + slider.getValue()));
                    FenetreGraphique.lvlSound = (float) (-60 + slider.getValue());
                }
            }
        });

        this.add(slider);

        // Bouton Revenir au menu principal
        Bouton Revenir = new Bouton(1100, 780, 300, 110, "Revenir");
        Revenir.setActionCommand("Revenir");
        Revenir.addActionListener(this);
        this.add(Revenir);

        // Bouton Appliquer les changements
        Bouton Appliquer = new Bouton(200, 880, 400, 110, "Appliquer");
        Appliquer.setActionCommand("Appliquer");
        Appliquer.addActionListener(this);
        this.add(Appliquer);

        // Bouton Appliquer les changements
        Bouton ActiverLeSon = new Bouton(200, 600, 500, 110, "Activer le son");
        ActiverLeSon.setActionCommand("Activer le son");
        ActiverLeSon.addActionListener(this);
        this.add(ActiverLeSon);

        // Bouton Appliquer les changements
        Bouton Graphisme = new Bouton(1600, 400, 400, 110, "Graphisme");
        Graphisme.setActionCommand("Activer le son");
        Graphisme.addActionListener(this);
        this.add(Graphisme);

        // Bouton Appliquer les changements
        Bouton Son = new Bouton(1600, 700, 300, 110, "Son");
        Son.setActionCommand("Son");
        Son.addActionListener(this);
        this.add(Son);

        // Création de bouton si en jeux
        if (FenetreGraphique.vien_de == 2) {
            Bouton Abandonner = new Bouton(500, 780, 500, 110, "Abandonner");
            Abandonner.setActionCommand("Abandonner");
            Abandonner.addActionListener(this);
            this.add(Abandonner);
        }
    }

    public void actionPerformed(ActionEvent event) {

        if (event.getActionCommand().equals("Revenir")) {
            FenetreOption.show = false;
            f_o.dispose();
        }

        else if (event.getActionCommand().equals("Abandonner")) {
            FenetreOption.show = false;
            f_o.dispose();
            FenetreGraphique.changement = true;
            FenetreGraphique.window = 1;
        }

        else if (event.getActionCommand().equals("Graphisme")) {
            FenetreOption.window = 1;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }

        else if (event.getActionCommand().equals("Activer le son")) {
            changeSong = true;
        }

        else if (event.getActionCommand().equals("Appliquer")) {
            if (FenetreGraphique.changeScreen == true) {
                JeuxPente.f.changementDeScreen();
            }

            else if (changeSong) {
                changeSong = false;
                FenetreGraphique.sounds.stop();
                FenetreGraphique.putSong = !FenetreGraphique.putSong;
            }
        }

        // else if (event.getActionCommand().equals("Revenir_Jeu")) {
        // FenetreGraphique.changement = true;
        // FenetreGraphique.window = FenetreGraphique.vien_de;
        // }

    }

    public void stateChanged(ChangeEvent e) {

    }
}
