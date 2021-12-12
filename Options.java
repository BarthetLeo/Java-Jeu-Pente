import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;

public class Options extends JPanel implements ActionListener {

    BufferedImage img;
    private FenetreOption f_o;
    boolean changeSong = false;

    /**
     * Créé le JPanel Menu avec une image et les boutons
     */
    Options(FenetreOption f_o) {

        // Si en jeux alors affichage différent
        if (FenetreGraphique.vien_de == 2) {
            try {
                img = ImageIO.read(new File("graphics/images/FondMenuOptions.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Si hors jeux alors affichage différent
        else {
            try {
                img = ImageIO.read(new File("graphics/images/FondMenuOptions1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.f_o = f_o;

        creationBouton();
    }

    /**
     * Affiche le fond et l'image
     * 
     * @param Graphics g
     */
    public void affiche_fond(Graphics g) {
        int hauteur = getHeight();
        int longueur = getWidth();
        g.setColor(Color.BLACK);
        g.drawImage(img, 0, 0, longueur, hauteur, null);
    }

    /**
     * Création de tout les boutons sur le Menu
     */
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
        Regles.setActionCommand("Regles");
        Regles.addActionListener(this);
        this.add(Regles);

        if (FenetreGraphique.vien_de == 2) {
            // Bouton aller dans la catégorie Affichage
            Bouton Affichage = new Bouton(820, 90, 400, 110, "Affichage");
            Affichage.setActionCommand("Affichage");
            Affichage.addActionListener(this);
            Color monOrange = new Color(197, 116, 29);
            Affichage.setForeground(monOrange);
            this.add(Affichage);

            // Bouton aller dans la catégorie jeux
            Bouton Jeux = new Bouton(480, 100, 300, 110, "Jeux");
            Jeux.setActionCommand("Jeux");
            Jeux.addActionListener(this);
            this.add(Jeux);

            // Bouton aller dans la catégorie Son
            Bouton Son = new Bouton(1220, 100, 300, 110, "Son");
            Son.setActionCommand("Son");
            Son.addActionListener(this);
            this.add(Son);
        }

        else if (FenetreGraphique.vien_de == 1) {

            // Bouton aller dans la catégorie Affichage
            Bouton Affichage = new Bouton(550, 90, 400, 110, "Affichage");
            Affichage.setActionCommand("Affichage");
            Affichage.addActionListener(this);
            Color monOrange = new Color(197, 116, 29);
            Affichage.setForeground(monOrange);
            this.add(Affichage);

            // Bouton aller dans la catégorie Son
            Bouton Son = new Bouton(1050, 100, 300, 110, "Son");
            Son.setActionCommand("Son");
            Son.addActionListener(this);
            this.add(Son);
        }

        // Bouton revenir ou l'on était avant
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

    /**
     * Assigne a chaque bouton cliqué une action
     * 
     * @param ActionEvent event, le bouton cliqué
     */
    public void actionPerformed(ActionEvent event) {

        // Ferme la fenetre Option
        if (event.getActionCommand().equals("Revenir")) {
            FenetreOption.show = false;
            if (FenetreGraphique.changeScreen == true) { // Si bouton fullscreen est appuyé mais n'est pas appliqué
                FenetreGraphique.fullscreen = !FenetreGraphique.fullscreen; // Alors on remet la valeur de fullScreen
                FenetreGraphique.changeScreen = false; // comme elle l'était
            }
            f_o.dispose();
        }

        // Aller dans la catégorie Jeux
        else if (event.getActionCommand().equals("Jeux")) {
            FenetreOption.window = 3;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }

        // Aller dans la catégorie Son des options
        else if (event.getActionCommand().equals("Son")) {
            FenetreOption.window = 2;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }

        // Permet de mettre le jeux en fullscreen
        else if (event.getActionCommand().equals("Fullscreen")) {
            FenetreGraphique.fullscreen = !FenetreGraphique.fullscreen;
            FenetreGraphique.changeScreen = true;
        }

        // Change une valeur , qui permet d'afficher ou non les FPS
        else if (event.getActionCommand().equals("AfficherFPS")) {
            FenetreGraphique.affiche_fps = !FenetreGraphique.affiche_fps;
        }

        // Applique les changmements, tels que Fullscreen et le son
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

        // Ouvre une fenetre montrant les règles
        else if (event.getActionCommand().equals("Regles")) {
            FenetreOption.window = 4;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }

    }

    /**
     * Dessine le JPanel
     * 
     * @param Graphics g
     */
    public void paintComponent(Graphics g) {
        affiche_fond(g);
        if (FenetreGraphique.affiche_fps) {
            Menu.creation_fps(g);
        }

    }
}