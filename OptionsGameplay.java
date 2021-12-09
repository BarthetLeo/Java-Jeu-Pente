import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;

public class OptionsGameplay extends JPanel implements ActionListener, ChangeListener {

    BufferedImage img;
    // private static boolean vien_jeu;
    // private String action_rev = "Revenir";
    private FenetreOption f_o;
    boolean changeSong = false;

    OptionsGameplay(FenetreOption f_o) {

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

        // Bouton Afficher règles du jeux
        Bouton Regles = new Bouton(1500, 950, 500, 110, "Regles");
        Regles.setActionCommand("Règles");
        Regles.addActionListener(this);
        this.add(Regles);

        // Bouton aller dans la catégorie graphisme
        Bouton Graphisme = new Bouton(550, 100, 400, 110, "Graphisme");
        Graphisme.setActionCommand("Activer le son");
        Graphisme.addActionListener(this);
        this.add(Graphisme);

        // Bouton Appliquer les changements
        Bouton Son = new Bouton(1050, 100, 300, 110, "Son");
        Son.setActionCommand("Son");
        Son.addActionListener(this);
        this.add(Son);

        if (FenetreGraphique.vien_de == 1) {

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

        // Création de bouton si en jeux
        else if (FenetreGraphique.vien_de == 2) {

            // Bouton Abandonner la partie en cours
            Bouton Abandonner = new Bouton(750, 680, 500, 110, "Abandonner");
            Abandonner.setActionCommand("Abandonner");
            Abandonner.addActionListener(this);
            this.add(Abandonner);

            // Bouton Revenir au menu principal
            Bouton Revenir = new Bouton(1225, 880, 300, 110, "Revenir");
            Revenir.setActionCommand("Revenir");
            Revenir.addActionListener(this);
            this.add(Revenir);

            // Bouton Appliquer les changements
            Bouton Appliquer = new Bouton(400, 880, 400, 110, "Appliquer");
            Appliquer.setActionCommand("Appliquer");
            Appliquer.addActionListener(this);
            this.add(Appliquer);
        }
    }

    public void actionPerformed(ActionEvent event) {

        if (event.getActionCommand().equals("Revenir")) {
            FenetreOption.show = false;
            f_o.dispose();
        }

        else if (event.getActionCommand().equals("Son")) {
            FenetreOption.window = 2;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }

        else if (event.getActionCommand().equals("Graphisme")) {
            FenetreOption.window = 1;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }

        else if (event.getActionCommand().equals("Fullscreen")) {
            FenetreGraphique.fullscreen = !FenetreGraphique.fullscreen;
            FenetreGraphique.changeScreen = true;
            FenetreGraphique.changement = true;
        }

        else if (event.getActionCommand().equals("AfficherFPS")) {
            FenetreGraphique.affiche_fps = !FenetreGraphique.affiche_fps;
        }

        else if (event.getActionCommand().equals("Abandonner")) {
            FenetreOption.show = false;
            f_o.dispose();
            FenetreGraphique.changement = true;
            FenetreGraphique.window = 1;
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

    public void paintComponent(Graphics g) {
        affiche_fond(g);
        if (FenetreGraphique.affiche_fps) {
            Menu.creation_fps(g);
        }
    }
}