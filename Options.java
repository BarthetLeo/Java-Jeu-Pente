import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;

public class Options extends JPanel implements ActionListener {

    BufferedImage img;
    //private static boolean vien_jeu;
    //private String action_rev = "Revenir";
    private FenetreOption f_o;

    Options(FenetreOption f_o) {

        try {
            img = ImageIO.read(new File("graphics/images/noir.png"));
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
        // Bouton plein écran
        Bouton Fullscreen = new Bouton(740, 180, 500, 110, "FullScreen");
        Fullscreen.setActionCommand("Fullscreen");
        Fullscreen.addActionListener(this);
        this.add(Fullscreen);

        // Bouton Afficher les FPS
        Bouton AfficherFPS = new Bouton(780, 380, 500, 110, "Afficher Fps");
        AfficherFPS.setActionCommand("AfficherFPS");
        AfficherFPS.addActionListener(this);
        this.add(AfficherFPS);

        // Bouton Afficher règles du jeux
        Bouton Regles = new Bouton(680, 580, 500, 110, "Regles");
        Regles.setActionCommand("Règles");
        Regles.addActionListener(this);
        this.add(Regles);

        // Bouton Revenir au menu principal
        Bouton Revenir = new Bouton(1000, 780, 300, 110, "Revenir");
        Revenir.setActionCommand("Revenir");
        Revenir.addActionListener(this);
        this.add(Revenir);

        // Création de bouton si en jeux
        if (FenetreGraphique.vien_de == 2) {
            Bouton Abandonner = new Bouton(600, 780, 300, 110, "Abandonner");
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

        // else if (event.getActionCommand().equals("Revenir_Jeu")) {
        // FenetreGraphique.changement = true;
        // FenetreGraphique.window = FenetreGraphique.vien_de;
        // }

    }

    public void paintComponent(Graphics g) {
        affiche_fond(g);
        if (FenetreGraphique.affiche_fps) {
            Menu.creation_fps(g);
        }
    }
}