import javax.swing.*;
/*import java.util.*;
import java.awt.Toolkit;
import java.awt.Dimension;*/
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import java.io.File;


public class Pente extends JPanel{
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int Height = (int)dimension.getHeight();
    int Width  = (int)dimension.getWidth();
    BufferedImage img;
    
    public Pente()
    {
        try
        {
            img = ImageIO.read(new File("fond_jeu.jpg"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //Tableau permettant de stocker les Jeton mit sur le plateau
        tableau_bouton();
        
    }
    public void affiche_grille(Graphics g)
    {
        //Largeur max du plateau
        int M_W_plat = (Width/4)*3-16;
        //Espace minimum entre chaque ligne
        int m_H_plat = Height/20-1;
        
        //Convertissseur de Graphics en Graphics2D pour plus d'option.
        Graphics2D g2 = (Graphics2D)g;
        //Permet de changer l'épaisseur des traits
        g2.setStroke(new BasicStroke(5.0f));
        g2.setColor(Color.red);
        g2.drawRect(0, 0, M_W_plat, Height);
        g2.setStroke(new BasicStroke(3.0f));
        g2.setColor(Color.black);

        //Boucle pour dessiner les colonne et des noms des colonnes
        String [] lettre = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S"};
        for(int i =1;i<20;i++)
        {
            g2.drawLine((M_W_plat/20)*i, (m_H_plat), (M_W_plat/20)*i, (m_H_plat)*19);
            g2.drawString(lettre[i-1], ((M_W_plat/20)*i)-3,((m_H_plat)*19)+30);
            
        }
        
        //Boucle pour dessiner les lignes et les nombres des lignes
        for(int i =1;i<20;i++)
        {
            g2.drawLine((M_W_plat/20), (m_H_plat)*i, (M_W_plat/20)*19, (m_H_plat)*i);
            String nb = String.valueOf(i);
            if(i<10)
            {
                g2.drawString(nb, ((M_W_plat/20)-20),((m_H_plat)*i)+3);
            }
            else
                g2.drawString(nb, ((M_W_plat/20)-30),((m_H_plat)*i)+6);
        }
    
        
    }
    public void tableau_bouton()
    {
        //Largeur max du plateau
        int M_W_plat = (Width/4)*3-16;
        //Espace minimum entre chaque ligne
        int m_H_plat = Height/20-1;

        int taille = 25;

        for(int i =m_H_plat;i<m_H_plat*20;i +=m_H_plat)
        {

            for(int j =M_W_plat/20;j<M_W_plat-M_W_plat/20;j +=M_W_plat/20)
            {
                Bouton bt = new Bouton(j-taille/2, i-taille/2, taille, taille, "");
                //bt.setBorderPainted(false);
                bt.setContentAreaFilled(false);
                bt.setFocusPainted(false);
                //On définie le nom de l'action
                bt.setActionCommand("Cliquez");
                //On créer un nouveau ListenerBouton pour le bouton
                bt.addActionListener(new ListenerBouton(this, bt)); 
                this.add(bt);
            }
        }
    }
    public void affiche_fond(Graphics g)
    {
        int hauteur = getHeight();
        int longueur = getWidth();
        g.setColor(Color.BLACK);
        g.drawImage(img, 0, 0,longueur, hauteur, null);
    }

    public void paintComponent(Graphics g)
    {
        affiche_fond(g);
        affiche_grille(g);
    }

    public void supprimer(Bouton bt)
    {
        this.remove(bt);
    }

    public void ajout_jeton(Bouton bt)
    {
        Jeton j = new Jeton(1, bt);
        this.add(j);
    }

}