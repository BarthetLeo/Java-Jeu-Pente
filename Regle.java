import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;

public class Regle extends JPanel implements ActionListener{

    BufferedImage img;
    boolean changeSong = false;
    /**
     * Constructeur du Jpanel Regles
     */
    Regle() {

        try {
            img = ImageIO.read(new File("graphics/images/Noir.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        creationBouton();
    }
    /**
     * Affiche le fond des regles.
     * @param g
     */
    public void affiche_fond(Graphics g) {
        int hauteur = getHeight();
        int longueur = getWidth();
        g.setColor(Color.BLACK);
        g.drawImage(img, 0, 0, longueur, hauteur, null);
    }
    /**
     * Crée le bouton Revenir.
     */
    public void creationBouton()
    {
        Bouton Revenir = new Bouton(1600, 980, 300, 110, "Revenir");
        Revenir.setActionCommand("Revenir");
        Revenir.addActionListener(this);
        this.add(Revenir);
    }

    public void actionPerformed(ActionEvent event) {

        if (event.getActionCommand().equals("Revenir")) {
            FenetreOption.window = FenetreOption.vien_de;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }
    }
    /**
     * Affiche les regles a l'écran
     */
    public void affiche_regle(Graphics g)
    {
        g.setFont(new Font("Verdana", Font.BOLD, 50));
        g.setColor(Color.white);
        g.drawString("Bienvenue sur le jeux de Pente", getWidth()/2-8*50, 60);
        g.setFont(new Font("Verdana", Font.BOLD, 20));
        g.drawString("Le Pente se joue sur un plateau de 19x19 intersections et les pierres sont placées sur les intersections, pas sur les cases. La partie commence avec le plateau vide", 50, 200);
        g.drawString("Le but est d'aligner 5 pierres ou plus sur une ligne verticale, horizontale ou diagonale, ou de capturer au moins 10 pierres adverses. Soit 5 prises.", 50, 250);
        g.drawString("Comment placer les pierres :", 40, 350);
        g.drawString("Chaque joueur peut placer une pierre sur une intersection libre par tour. Cependant, afin d'équilibrer les chances de victoire entre les rouges et jaunes,", 50, 400);
        g.drawString("plusieurs restrictions sont appliquées:", 50, 450);
        g.drawString("-La première pierre des rouges doit être placée au centre du plateau - l'intersection J10", 65, 500);
        g.drawString("-La première pierre des jaunes doit être placée dans ou sur le rectangle rouge.", 65, 550);
        g.drawString("Comment capturer les pierres adverses :", 40, 650);
        g.drawString("Un joueur capture les pièces adverses en entourant verticalement, horizontalement ou en diagonale, deux et seulement deux pierres adverses.", 50, 700);
        g.drawString("Les pierres capturées sont immédiatement retirées du jeu.", 50, 750);
        g.drawString("Il est possible de réaliser une capture multiple en entourant deux ou plusieurs paires de pierres adverses à la fois.", 50, 800);
        g.drawString("Si un joueur place une pierre et se retrouve avec une paire entourée par des pierres adverses, ses pierres ne sont pas capturées.", 50, 850);        
        g.drawString("La capture ne se produit que sur un coup du joueur qui capture.", 50, 900);

    }

    public void paintComponent(Graphics g) {
        affiche_fond(g);
        affiche_regle(g);
    }
}