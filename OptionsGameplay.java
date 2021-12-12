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
    private FenetreOption f_o;
    boolean changeSong = false;

    OptionsGameplay(FenetreOption f_o) {

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

    public void affiche_fond(Graphics g) {
        int hauteur = getHeight();
        int longueur = getWidth();
        g.setColor(Color.BLACK);
        g.drawImage(img, 0, 0, longueur, hauteur, null);
    }

    public void creationBouton() {

        // Bouton Afficher règles du jeux
        Bouton Regles = new Bouton(1500, 950, 500, 110, "Regles");
        Regles.setActionCommand("Regles");
        Regles.addActionListener(this);
        this.add(Regles);

        // Bouton aller dans la catégorie Affichage
        Bouton Affichage = new Bouton(820, 90, 400, 110, "Affichage");
        Affichage.setActionCommand("Affichage");
        Affichage.addActionListener(this);
        this.add(Affichage);

        // Bouton aller dans la catégorie Jeux
        Bouton Jeux = new Bouton(480, 100, 300, 110, "Jeux");
        Jeux.setActionCommand("Jeux");
        Jeux.addActionListener(this);
        Color monOrange = new Color(197, 116, 29);
        Jeux.setForeground(monOrange);
        this.add(Jeux);

        // Bouton aller dans la catégorie Son
        Bouton Son = new Bouton(1220, 100, 300, 110, "Son");
        Son.setActionCommand("Son");
        Son.addActionListener(this);
        this.add(Son);

        // Bouton revenir ou l'on était
        Bouton Revenir = new Bouton(1100, 880, 300, 110, "Revenir");
        Revenir.setActionCommand("Revenir");
        Revenir.addActionListener(this);
        this.add(Revenir);

        // Bouton Appliquer les changements
        Bouton Appliquer = new Bouton(550, 880, 400, 110, "Appliquer");
        Appliquer.setActionCommand("Appliquer");
        Appliquer.addActionListener(this);
        this.add(Appliquer);

        // Bouton Abandonner la partie en cours
        Bouton Abandonner = new Bouton(720, 350, 500, 110, "Abandonner");
        Abandonner.setActionCommand("Abandonner");
        Abandonner.addActionListener(this);
        this.add(Abandonner);

        // Bouton recommencer la partie en cours
        Bouton Recommencer = new Bouton(760, 600, 500, 110, "Recommencer");
        Recommencer.setActionCommand("Recommencer");
        Recommencer.addActionListener(this);
        this.add(Recommencer);

    }

    /**
     * Assigne a chaque bouton cliqué une action
     * 
     * @param ActionEvent event, le bouton cliqué
     */
    public void actionPerformed(ActionEvent event) {

        // Ferme la fenetre option
        if (event.getActionCommand().equals("Revenir")) {
            FenetreOption.show = false;
            if (FenetreGraphique.changeScreen == true) { // Si bouton fullscreen est appuyé mais n'est pas appliqué
                FenetreGraphique.fullscreen = !FenetreGraphique.fullscreen; // Alors on remet la valeur de fullScreen
                FenetreGraphique.changeScreen = false; // comme elle l'était
            }
            f_o.dispose();
        }

        // Aller dans la catégorie Son des options
        else if (event.getActionCommand().equals("Son")) {
            FenetreOption.window = 2;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }

        // Aller dans la catégorie affichage des options
        else if (event.getActionCommand().equals("Affichage")) {
            FenetreOption.window = 1;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }

        // Quitte la partie et revient au menu
        else if (event.getActionCommand().equals("Abandonner")) {
            FenetreOption.show = false;
            f_o.dispose();
            FenetreGraphique.changement = true;
            FenetreGraphique.window = 1;
        }

        // Recommencer la partie
        else if (event.getActionCommand().equals("Recommencer")) {
            FenetreOption.show = false;
            f_o.dispose();
            FenetreGraphique.vien_de = 1;
            FenetreGraphique.window = 2;
            FenetreGraphique.changement = true;

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

    public void stateChanged(ChangeEvent e) {

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