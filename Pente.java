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
        //Convertissseur de Graphics en Graphics2D pour plus d'option.
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.black);
        //Boucle pour dessiner les lignes verticales
        for(int i =1;i<20;i++)
            g2.drawLine((getWidth()/20)*i, 0, (getWidth()/20)*i, getHeight());
        //Boucle pour dessiner les lignes horizontales
        for(int i =1;i<20;i++)
            g2.drawLine(0, (getHeight()/20)*i, getWidth(), (getHeight()/20)*i);
    }

    public void paint(Graphics g)
    {
        affiche_grille(g);
    }

}
