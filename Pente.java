import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;

import java.io.File;
import java.awt.event.*;

public class Pente extends JPanel implements ActionListener {
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
    protected static int nb_regle = 1;
    // Largeur max du plateau
    private int M_W_plat = (Width / 4) * 3 - 16;
    // Espace minimum entre chaque ligne
    private int m_H_plat = Height / 20 - 1;
    private int taille = 34;
    protected int nb_tour = 1;
    public static String nom_gagnant;
    /**
     * Constructeur du jeux de pente.
     */
    public Pente() {
        j_tab = new Jeton[19][19];
        try {
            img = ImageIO.read(new File("graphics/images/fond_jeux.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            file = new File("graphics/font/WIldrock.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, file);
            font = font.deriveFont(60.f);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        nb_regle = 1;
        regle_1();
        J1 = new Joueur(Color.red,FenetreGraphique.nom1);
        J2 = new Joueur(Color.yellow,FenetreGraphique.nom2);

        J1.set_tour(true);

        Bouton B_option = new Bouton(Width - ((Width / 4) / 4)*2-50, (Height / 20)*9-5, 200, 100, "Options",60);
        B_option.setActionCommand("Options");
        B_option.setBorderPainted(true);
        B_option.addActionListener(this);
        this.add(B_option);
    }
    /**
     * Permet de respecter la 1er regle le joueur 1 doit forcerment commencer au milieu
     */
    public void regle_1() {
        Bouton bt = new Bouton(693, 513, taille, taille, "");
        Jeton jeton = new Jeton(693, 513, taille, taille);
        bt.setContentAreaFilled(false);
        bt.setActionCommand("Cliquez");
        bt.addActionListener(new ListenerBouton(this, bt, jeton));
        this.add(bt);
        j_tab[9][9] = jeton;
    }
    /**
     * Le joueur doit placer un jeton dans la zone prescrite ici 2 écart avec le milieu
     */
    public void regle_2() {

        int k = 0, l;
        for (int i = m_H_plat * 8; i < m_H_plat * 13; i += m_H_plat) {
            k++;
            l = 0;
            for (int j = (M_W_plat / 20) * 8; j < (M_W_plat / 20) * 13; j += M_W_plat / 20) {
                l++;
                if (j != 693 + 17 | i != 513 + 17) {
                    Bouton bt = new Bouton(j - taille / 2, i - taille / 2, taille, taille, "");
                    Jeton jeton = new Jeton(j - taille / 2, i - taille / 2, taille, taille);
                    bt.setContentAreaFilled(false);
                    bt.setActionCommand("Cliquez");
                    bt.addActionListener(new ListenerBouton(this, bt, jeton));
                    this.add(bt);
                    j_tab[6 + l][6 + k] = jeton;
                }
            }
        }
        nb_regle++;
    }
    /**
     * Affiche la grille de jeu avec le nom des colonnes et lignes
     */
    public void affiche_grille(Graphics g) {
        // Convertissseur de Graphics en Graphics2D pour plus d'option.
        Graphics2D g2 = (Graphics2D) g;
        // Permet de changer l'épaisseur des traits
        g2.setColor(Color.black);
        g2.setFont(new Font("Verdana", Font.BOLD, 15));

        // Boucle pour dessiner les colonne et des noms des colonnes
        String[] lettre = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S" };
        for (int i = 1; i < 20; i++) {
            g2.setStroke(new BasicStroke(3.0f));

            if (i == 10)
                g2.setStroke(new BasicStroke(5.0f));

            g2.drawLine((M_W_plat / 20) * i, (m_H_plat), (M_W_plat / 20) * i, (m_H_plat) * 19);
            g2.drawString(lettre[i - 1], ((M_W_plat / 20) * i) - 3, ((m_H_plat) * 19) + 30);
        }

        // Boucle pour dessiner les lignes et les nombres des lignes
        for (int i = 1; i < 20; i++) {
            g2.setStroke(new BasicStroke(3.0f));

            if (i == 10)
                g2.setStroke(new BasicStroke(5.0f));

            g2.drawLine((M_W_plat / 20), (m_H_plat) * i, (M_W_plat / 20) * 19, (m_H_plat) * i);
            String nb = String.valueOf(i);
            if (i < 10) {
                g2.drawString(nb, ((M_W_plat / 20) - 20), ((m_H_plat) * i) + 3);
            } else
                g2.drawString(nb, ((M_W_plat / 20) - 30), ((m_H_plat) * i) + 6);
        }

        if (nb_regle == 2) {
            g2.setStroke(new BasicStroke(3.0f));
            g2.setColor(Color.red);
            g2.drawRect((M_W_plat / 20) * 8, m_H_plat * 8, (M_W_plat / 20) * 4, m_H_plat * 4);
        }
    }
    /**
     * Créer les boutons qui son placer a chaque intersection de lignes et colonnes.
     */
    public void tableau_bouton() {
        int k = 0, l = 0;
        for (int i = m_H_plat; i < m_H_plat * 20; i += m_H_plat) {
            k++;
            l = 0;
            for (int j = M_W_plat / 20; j < M_W_plat - M_W_plat / 20; j += M_W_plat / 20) {
                l++;
                if (j_tab[k - 1][l - 1] == null) {
                    Bouton bt = new Bouton(j - taille / 2, i - taille / 2, taille, taille, "");
                    Jeton jeton = new Jeton(j - taille / 2, i - taille / 2, taille, taille);
                    bt.setContentAreaFilled(false);
                    // On définie le nom de l'action
                    bt.setActionCommand("Cliquez");
                    // On créer un nouveau ListenerBouton pour le bouton
                    bt.addActionListener(new ListenerBouton(this, bt, jeton));
                    this.add(bt);
                    j_tab[k - 1][l - 1] = jeton;
                }
            }
        }
    }
    /**
     * affiche le fond du jeux ici une image
     */
    public void affiche_fond(Graphics g) {
        int hauteur = Height;
        int longueur = Width;
        g.setColor(Color.BLACK);
        g.drawImage(img, 0, 0, longueur, hauteur, null);
    }
    /**
     * Supprime un bouton placer sur le jeux
     * @param bt Bouton a supprimer
     */
    public void supprimer(Bouton bt) {
        this.remove(bt);
    }
    /**
     * Affiche pour chaque Joueur son nombre de jeton avec un rectangle remplie qui se vide selon le nombre de jetons.
     */
    public void affiche_pile(Graphics g)
    {
        g.setColor(J1.get_couleur());
        g.fillRect(Width - ((Width / 4) / 4), (Height / 20)*2, 20, -J1.get_pile());
        g.setColor(J2.get_couleur());
        g.fillRect(Width - ((Width / 4) / 4), (Height / 20)*18, 20, -J2.get_pile());
        g.setColor(Color.black);
        g.drawRect(Width - ((Width / 4) / 4)-2, (Height / 20)*2-62, 22, 62);
        g.drawRect(Width - ((Width / 4) / 4)-2, (Height / 20)*18-62, 22, 62);
        g.drawString("Il reste  : " + J1.get_pile() + " jetons.",Width - ((Width / 4) / 4) * 4, (Height / 20)*2);
        g.drawString("Il reste  : " + J2.get_pile() + " jetons.",Width - ((Width / 4) / 4) * 4, (Height / 20)*18);
    }
    /**
     * Affiche le nombre de capture effectuer par les Joueurs
     */
    public void affiche_prise(Graphics g)
    {
        g.drawString("Nombre de prise : " + J1.get_prise() + " jetons.",Width - ((Width / 4) / 4) * 4, (Height / 20)*3);
        g.drawString("Nombre de prise : " + J2.get_prise() + " jetons.",Width - ((Width / 4) / 4) * 4, (Height / 20)*19);
    }
    /**
     * Affiche le tour
     */
    public void affiche_tour(Graphics g)
    {
        g.drawString("Tour : "+nb_tour,Width - ((Width / 4) / 4)*4, (Height / 20)*10);
    }
    /**
     * Affiche la grille, le fond,les fps et les jetons placée sur le plateau.
     * @param g
     */
    public void dessine_grille(Graphics g) {
        affiche_fond(g);
        affiche_grille(g);
        if (FenetreGraphique.affiche_fps) {
            Menu.creation_fps(g);
        }

        if (nb_regle >= 3) {
            for (int i = 0; i < 19; i++) {
                for (int j = 0; j < 19; j++) {
                    if (j_tab[i][j].getbool())
                        dessine_jeton(g, j_tab[i][j]);
                }
            }
        }
        if (nb_regle == 1) {
            if (j_tab[9][9].getbool())
                dessine_jeton(g, j_tab[9][9]);
        }
        if (nb_regle == 2) {
            for (int i = 7; i < 12; i++) {
                for (int j = 7; j < 12; j++) {
                    if (j_tab[i][j].getbool())
                        dessine_jeton(g, j_tab[i][j]);
                }
            }
        }
    }
    /**
     * Permet d'afficher le jeton placée
     * @param g
     * @param j Jeton a faire apparaitre
     */
    public void dessine_jeton(Graphics g, Jeton j) {
        j.paintComponent(g);
    }
    /**
     * Affiche le nom des Joueurs et selon a qui est le tour la couleur du Joueur jouant est en orange
     * @param g
     */
    public void affiche_joueur(Graphics g) {
        Color couleur = new Color(247, 130, 55);
        font = font.deriveFont(60.f);
        g.setFont(font);
        if (J1.get_tour()) {
            g.setColor(couleur);
            g.drawString(J1.get_pseudo(), Width - ((Width / 4) / 4) * 4, Height / 20);
            g.setColor(Color.black);
            g.drawString(J2.get_pseudo(), Width - ((Width / 4) / 4) * 4, (Height / 20) * 17);
        } else if (J2.get_tour()) {
            g.setColor(couleur);
            g.drawString(J2.get_pseudo(), Width - ((Width / 4) / 4) * 4, (Height / 20) * 17);
            g.setColor(Color.black);
            g.drawString(J1.get_pseudo(), Width - ((Width / 4) / 4) * 4, Height / 20);
        }
    }

    public void paintComponent(Graphics g) {
        dessine_grille(g);
        affiche_joueur(g);
        affiche_tour(g);
        font = font.deriveFont(40.f);
        g.setFont(font);
        affiche_pile(g);
        affiche_prise(g);
    }

    public void actionPerformed(ActionEvent event) {

        if (event.getActionCommand().equals("Options")) {
            FenetreGraphique.window = 3;
            FenetreGraphique.changement = true;
            FenetreOption.window = 3;
            FenetreOption.changement = true;
            FenetreOption.show = true;
        }
    }
}