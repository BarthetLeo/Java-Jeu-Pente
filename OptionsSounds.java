import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OptionsSounds extends JPanel implements ActionListener, ChangeListener {

    BufferedImage img;
    private FenetreOption f_o;
    boolean changeSong = false;

    OptionsSounds(FenetreOption f_o) {

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

        // Slider permettant de modifier le volume des musiques
        Slider slider = new Slider(0, 60, 30);
        slider.setLocation(830, 520);
        slider.setSize(300, 200);

        slider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                Slider slider = (Slider) e.getSource();
                if (!slider.getValueIsAdjusting()) {
                    FenetreGraphique.sounds.setVolume((float) (-60 + slider.getValue())); // -60 + 60 = 0 donc son non
                    FenetreGraphique.lvlSound = (float) (-60 + slider.getValue()); // modifié
                }
            }
        });

        this.add(slider);

        // Bouton activer / désactiver les sons
        Bouton ActiverLeSon = new Bouton(720, 350, 500, 110, "Activer le son");
        ActiverLeSon.setActionCommand("Activer le son");
        ActiverLeSon.addActionListener(this);
        this.add(ActiverLeSon);

        // Bouton Afficher règles du jeux
        Bouton Regles = new Bouton(1500, 950, 500, 110, "Regles");
        Regles.setActionCommand("Regles");
        Regles.addActionListener(this);
        this.add(Regles);

        // Si en pleine partie, boutons posé differemment
        if (FenetreGraphique.vien_de == 2) {

            // Bouton aller dans la catégorie Affichage
            Bouton Affichage = new Bouton(820, 90, 400, 110, "Affichage");
            Affichage.setActionCommand("Affichage");
            Affichage.addActionListener(this);
            this.add(Affichage);

            // Bouton aller dans la catégorie Jeux
            Bouton Jeux = new Bouton(480, 100, 300, 110, "Jeux");
            Jeux.setActionCommand("Jeux");
            Jeux.addActionListener(this);
            this.add(Jeux);

            // Bouton aller dans la catégorie Son
            Bouton Son = new Bouton(1220, 100, 300, 110, "Son");
            Son.setActionCommand("Son");
            Son.addActionListener(this);
            Color monOrange = new Color(197, 116, 29);
            Affichage.setForeground(monOrange);
            this.add(Son);
        }

        // Si dans le menu alors Optino sans jeux
        else if (FenetreGraphique.vien_de == 1) {

            // Bouton Appliquer les changements
            Bouton Affichage = new Bouton(550, 90, 400, 110, "Affichage");
            Affichage.setActionCommand("Affichage");
            Affichage.addActionListener(this);
            this.add(Affichage);

            // Bouton aller dans la catégorie Son
            Bouton Son = new Bouton(1050, 100, 300, 110, "Son");
            Son.setActionCommand("Son");
            Son.addActionListener(this);
            Color monOrange = new Color(197, 116, 29);
            Son.setForeground(monOrange);
            this.add(Son);
        }

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

        // Abandonne la partie en cours pour revenir au menu
        else if (event.getActionCommand().equals("Abandonner")) {
            FenetreOption.show = false;
            f_o.dispose();
            FenetreGraphique.changement = true;
            FenetreGraphique.window = 1;
        }

        // Aller dans la catégorie affichage des options
        else if (event.getActionCommand().equals("Affichage")) {
            FenetreOption.window = 1;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }

        // Aller dans la catégorie jeux des options
        else if (event.getActionCommand().equals("Jeux")) {
            FenetreOption.window = 3;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }

        // Permet d'activer / désactiver les musiques
        else if (event.getActionCommand().equals("Activer le son")) {
            changeSong = true;
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

    public void stateChanged(ChangeEvent e) {

    }
}
