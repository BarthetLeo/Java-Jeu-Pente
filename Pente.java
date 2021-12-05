import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

/*import java.util.*;
import java.awt.Toolkit;
import java.awt.Dimension;*/
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import javax.lang.model.util.ElementScanner14;

import java.io.File;
import java.awt.event.*;

public class Pente extends JPanel implements KeyListener {
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int Height = (int) dimension.getHeight();
    int Width = (int) dimension.getWidth();
    BufferedImage img;
    boolean cliqued = false;
    Jeton[][] j_tab;
    Joueur J1;
    Joueur J2;
    private Font font;
    private File file;

    public Pente() {
        j_tab = new Jeton[19][19];
        try {
            img = ImageIO.read(new File("fond_jeu.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            file = new File("WIldrock.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, file);
            font = font.deriveFont(60.f);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        // Tableau permettant de stocker les Jeton mit sur le plateau
        tableau_bouton();
        J1 = new Joueur(Hub.nom1, Color.red);
        J2 = new Joueur(Hub.nom2, Color.yellow);

        J1.set_tour(true);
    }

    public void affiche_grille(Graphics g) {
        // Largeur max du plateau
        int M_W_plat = (Width / 4) * 3 - 16;
        // Espace minimum entre chaque ligne
        int m_H_plat = Height / 20 - 1;

        // Convertissseur de Graphics en Graphics2D pour plus d'option.
        Graphics2D g2 = (Graphics2D) g;
        // Permet de changer l'épaisseur des traits
        g2.setStroke(new BasicStroke(5.0f));
        g2.setColor(Color.red);
        g2.drawRect(0, 0, M_W_plat, Height);
        g2.setStroke(new BasicStroke(3.0f));
        g2.setColor(Color.black);
        g2.setFont(new Font("Verdana", Font.BOLD, 15));

        // Boucle pour dessiner les colonne et des noms des colonnes
        String[] lettre = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S" };
        for (int i = 1; i < 20; i++) {
            g2.drawLine((M_W_plat / 20) * i, (m_H_plat), (M_W_plat / 20) * i, (m_H_plat) * 19);
            g2.drawString(lettre[i - 1], ((M_W_plat / 20) * i) - 3, ((m_H_plat) * 19) + 30);
        }

        // Boucle pour dessiner les lignes et les nombres des lignes
        for (int i = 1; i < 20; i++) {
            g2.drawLine((M_W_plat / 20), (m_H_plat) * i, (M_W_plat / 20) * 19, (m_H_plat) * i);
            String nb = String.valueOf(i);
            if (i < 10) {
                g2.drawString(nb, ((M_W_plat / 20) - 20), ((m_H_plat) * i) + 3);
            } else
                g2.drawString(nb, ((M_W_plat / 20) - 30), ((m_H_plat) * i) + 6);
        }

    }

    public void tableau_bouton() {
        // Largeur max du plateau
        int M_W_plat = (Width / 4) * 3 - 16;
        // Espace minimum entre chaque ligne
        int m_H_plat = Height / 20 - 1;

        int taille = 34;
        int k = 0, l = 0;
        for (int i = m_H_plat; i < m_H_plat * 20; i += m_H_plat) {
            k++;
            l = 0;
            for (int j = M_W_plat / 20; j < M_W_plat - M_W_plat / 20; j += M_W_plat / 20) {
                l++;
                Bouton bt = new Bouton(j - taille / 2, i - taille / 2, taille, taille, "");
                Jeton jeton = new Jeton(j - taille / 2, i - taille / 2, taille, taille);
                bt.setBorderPainted(false);
                bt.setContentAreaFilled(false);
                bt.setFocusPainted(false);
                // On définie le nom de l'action
                bt.setActionCommand("Cliquez");
                // On créer un nouveau ListenerBouton pour le bouton
                bt.addActionListener(new ListenerBouton(this, bt, jeton));
                this.add(bt);
                j_tab[k - 1][l - 1] = jeton;
            }
        }
    }

    public void affiche_fond(Graphics g) {
        int hauteur = Height;
        int longueur = Width;
        g.setColor(Color.BLACK);
        g.drawImage(img, 0, 0, longueur, hauteur, null);
    }

    public void supprimer(Bouton bt) {
        this.remove(bt);
    }

    public void dessine_grille(Graphics g) {
        affiche_fond(g);
        affiche_grille(g);
        if (FenetreGraphique.affiche_fps) {
            Menu.creation_fps(g);
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (j_tab[i][j].getbool())
                    dessine_jeton(g, j_tab[i][j]);
            }
        }
    }

    public void dessine_jeton(Graphics g, Jeton j) {
        j.paintComponent(g);
    }

    public void affiche_joueur(Graphics g) {
        Color couleur = new Color(247, 130, 55);
        g.setFont(font);
        if (J1.get_tour()) {
            g.setColor(couleur);
            g.drawString(Hub.nom1, Width - ((Width / 4) / 4) * 4, Height / 20);
            g.setColor(Color.black);
            g.drawString(Hub.nom2, Width - ((Width / 4) / 4) * 4, (Height / 20) * 19);
        } else if (J2.get_tour()) {
            g.setColor(couleur);
            g.drawString(Hub.nom2, Width - ((Width / 4) / 4) * 4, (Height / 20) * 19);
            g.setColor(Color.black);
            g.drawString(Hub.nom1, Width - ((Width / 4) / 4) * 4, Height / 20);
        }
    }

    public void paintComponent(Graphics g) {
        dessine_grille(g);
        affiche_joueur(g);
    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }
}