import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;

public class Options extends JPanel implements ActionListener{

    BufferedImage img;
    private FenetreOption f_o;
    boolean changeSong = false;

    Options(FenetreOption f_o) {

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

        // Bouton plein écran
        Bouton Fullscreen = new Bouton(720, 350, 500, 110, "FullScreen");
        Fullscreen.setActionCommand("Fullscreen");
        Fullscreen.addActionListener(this);
        this.add(Fullscreen);

        // Bouton Afficher les FPS
        Bouton AfficherFPS = new Bouton(760, 600, 500, 110, "Afficher Fps");
        AfficherFPS.setActionCommand("AfficherFPS");
        AfficherFPS.addActionListener(this);
        this.add(AfficherFPS);

        // Bouton Afficher règles du jeux
        Bouton Regles = new Bouton(1500, 950, 500, 110, "Regles");
        Regles.setActionCommand("Règles");
        Regles.addActionListener(this);
        this.add(Regles);

        // Bouton aller dans la catégorie Affichage
        Bouton Affichage = new Bouton(550, 100, 400, 110, "Affichage");
        Affichage.setActionCommand("Activer le son");
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
            if (FenetreGraphique.changeScreen == true) {
                FenetreGraphique.fullscreen = !FenetreGraphique.fullscreen;
                FenetreGraphique.changeScreen = false;
            }
            f_o.dispose();
        }

        else if (event.getActionCommand().equals("Jeux")) {
            FenetreOption.window = 3;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }

        else if (event.getActionCommand().equals("Son")) {
            FenetreOption.window = 2;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }

        else if (event.getActionCommand().equals("Fullscreen")) {
            FenetreGraphique.fullscreen = !FenetreGraphique.fullscreen;
            FenetreGraphique.changeScreen = true;
        }

        else if (event.getActionCommand().equals("AfficherFPS")) {
            FenetreGraphique.affiche_fps = !FenetreGraphique.affiche_fps;
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
}