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
    private FenetreOption f_o;
    boolean changeSong = false;

    OptionsSounds(FenetreOption f_o) {

        try {
            img = ImageIO.read(new File("graphics/images/FondMenuOptions.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f_o = f_o;

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
        slider.setLocation(830, 520);
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

        // Bouton Appliquer les changements
        Bouton ActiverLeSon = new Bouton(720, 350, 500, 110, "Activer le son");
        ActiverLeSon.setActionCommand("Activer le son");
        ActiverLeSon.addActionListener(this);
        this.add(ActiverLeSon);

        // Bouton Afficher règles du jeux
        Bouton Regles = new Bouton(1500, 950, 500, 110, "Regles");
        Regles.setActionCommand("Règles");
        Regles.addActionListener(this);
        this.add(Regles);

        // Bouton Appliquer les changements
        Bouton Affichage = new Bouton(550, 100, 400, 110, "Affichage");
        Affichage.setActionCommand("Affichage");
        Affichage.addActionListener(this);
        this.add(Affichage);

        if (FenetreGraphique.vien_de == 2) {
            // Bouton aller dans Gameplay
            Bouton Jeux = new Bouton(200, 100, 300, 110, "Jeux");
            Jeux.setActionCommand("Jeux");
            Jeux.addActionListener(this);
            this.add(Jeux);
        }

        // Bouton Appliquer les changements
        Bouton Son = new Bouton(1050, 100, 300, 110, "Son");
        Son.setActionCommand("Son");
        Son.addActionListener(this);
        Color monOrange = new Color(197, 116, 29);
        Son.setForeground(monOrange);
        this.add(Son);

        // Bouton Revenir au menu principal
        Bouton Revenir = new Bouton(1100, 880, 300, 110, "Revenir");
        Revenir.setActionCommand("Revenir");
        Revenir.addActionListener(this);
        this.add(Revenir);

        // Bouton Appliquer les changements
        Bouton Appliquer = new Bouton(550, 880, 400, 110, "Appliquer");
        Appliquer.setActionCommand("Appliquer");
        Appliquer.addActionListener(this);
        this.add(Appliquer);
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

        else if (event.getActionCommand().equals("Affichage")) {
            FenetreOption.window = 1;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }

        else if (event.getActionCommand().equals("Jeux")) {
            FenetreOption.window = 3;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }

        else if (event.getActionCommand().equals("Activer le son")) {
            changeSong = true;
        }

        else if (event.getActionCommand().equals("Appliquer")) {
            if (FenetreGraphique.changeScreen == true) {
                f_o.f_g.changementDeScreen();
            }

            else if (changeSong) {
                changeSong = false;
                FenetreGraphique.sounds.stop();
                FenetreGraphique.putSong = !FenetreGraphique.putSong;
            }
        }

    }

    public void paintComponent(Graphics g) {
        affiche_fond(g);
        if (FenetreGraphique.affiche_fps) {
            Menu.creation_fps(g);
        }
    }

    public void stateChanged(ChangeEvent e) {

    }
}
