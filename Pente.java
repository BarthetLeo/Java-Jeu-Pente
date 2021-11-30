import javax.swing.*;
/*import java.util.*;
import java.awt.Toolkit;
import java.awt.Dimension;*/
import java.awt.*;



public class Pente extends JPanel{
    Jeton[][] plateau;
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int Height = (int)dimension.getHeight();
    int Width  = (int)dimension.getWidth();
    
    public Pente()
    {
        //Tableau permettant de stocker les Jeton mit sur le plateau
        plateau = new Jeton[19][19];
        tableau_bouton();
        
    }
    public void affiche_grille(Graphics g)
    {
        //Largeur max du plateau
        int M_W_plat = (Width/4)*3;
        //Espace minimum entre chaque ligne
        int m_H_plat = Height/20;
        
        //Convertissseur de Graphics en Graphics2D pour plus d'option.
        Graphics2D g2 = (Graphics2D)g;
        //Permet de changer l'épaisseur des traits
        g2.setStroke(new BasicStroke(5.0f));
        g2.setColor(Color.red);
        g2.drawRect(5, 5, M_W_plat, getHeight()-10);
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
        int M_W_plat = (Width/4)*3;
        //Espace minimum entre chaque ligne
        int m_H_plat = Height/20;

        int taille = 25;

        for(int i =m_H_plat;i<m_H_plat*20;i +=m_H_plat)
        {
            for(int j =M_W_plat/20;j<M_W_plat;j +=M_W_plat/20)
            {
                Bouton bt = new Bouton(j-taille/2, i-taille/2, taille, taille, "bt");
                this.add(bt);
            }
        }
    }

    public void paintComponent(Graphics g)
    {
       affiche_grille(g);
    }

}
