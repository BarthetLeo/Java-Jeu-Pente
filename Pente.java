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
    Jeton[][] plateau;

    public Pente()
    {
        //Tableau permettant de stocker les Jeton mit sur le plateau
        plateau = new Jeton[19][19];

    }
    public void affiche_grille(Graphics g)
    {
        int WM_plat = (getWidth()/4)*3;
        //Convertissseur de Graphics en Graphics2D pour plus d'option.
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.red);
        g2.drawRect(0, 0, WM_plat, getHeight());
        g2.setColor(Color.black);
        //Boucle pour dessiner les lignes verticales et des noms des lignes
        for(int i =1;i<20;i++)
            g2.drawLine((WM_plat/20)*i, (getHeight()/20), (WM_plat/20)*i, (getHeight()/20)*19);
        //Boucle pour dessiner les lignes horizontales
        for(int i =1;i<20;i++)
            g2.drawLine((WM_plat/20), (getHeight()/20)*i, (WM_plat/20)*19, (getHeight()/20)*i);
    }

    public void paint(Graphics g)
    {
        affiche_grille(g);
    }

}
