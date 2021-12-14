import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;

public class Menu extends JPanel implements ActionListener {

    BufferedImage img;
    boolean show_fps = false;

    /**
     * Créé le JPanel Menu avec une image et les boutons
     */
    Menu() {
        try {
            img = ImageIO.read(new File("graphics/images/Fond_Menu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        // Bouton permettant de jouer
        Bouton Jouer = new Bouton(400, 250, 300, 110, "Jouer");
        Jouer.setActionCommand("Jouer");
        Jouer.addActionListener(this);
        this.add(Jouer);

        // Bouton créant la fenêtre des options
        Bouton Option = new Bouton(400, 450, 300, 110, "Option");
        Option.setActionCommand("Option");
        Option.addActionListener(this);
        this.add(Option);

        // Bouton qui quitte le jeux
        Bouton Quitter = new Bouton(400, 650, 300, 110, "Quitter");
        Quitter.setActionCommand("Quitter");
        Quitter.addActionListener(this);
        this.add(Quitter);

    }

    /**
     * Assigne a chaque bouton cliqué une action
     * 
     * @param ActionEvent event, le bouton cliqué
     */
    public void actionPerformed(ActionEvent event) {

        // Change le JPanel jeux
        if (event.getActionCommand().equals("Jouer")) {
            FenetreGraphique.window = 2;
            FenetreGraphique.changement = true;

        }

        // Créé une nouvelle fenetre des options
        else if (event.getActionCommand().equals("Option")) {
            FenetreGraphique.window = 3;
            FenetreGraphique.changement = true;
            FenetreOption.show = true;
        }

        // Ferme le programme
        else if (event.getActionCommand().equals("Quitter")) {
            System.exit(0);
        }
    }

    /**
     * Création du texte montrant les FPS
     * 
     * @param Graphics g
     */
    public static void creation_fps(Graphics g) {
        int fps = (int) FenetreGraphique.fps;
        Font font = new Font("Verdana", Font.BOLD, 20);
        g.setFont(font);
        g.drawString("FPS :", 25, 40);
        g.drawString("" + fps, 100, 40);
    }

    /**
     * Dessine le JPanel
     * 
     * @param Graphics g
     */
    public void paintComponent(Graphics g) {
        affiche_fond(g);
        if (FenetreGraphique.affiche_fps) {
            creation_fps(g);
        }
    }
}