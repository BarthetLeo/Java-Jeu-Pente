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

    BufferedImage img;

    public Pente()
    {
        //Tableau permettant de stocker les Jeton mit sur le plateau
        plateau = new Jeton[19][19];
        {
            try
            {
                //Lecture du l'image de fond
                img = ImageIO.read(new File("unamed.jfif"));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
    public void affiche_fond(Graphics g)
    {
        int hauteur = getHeight()-50;
        int longueur = getWidth()-50;
        g.setColor(Color.BLACK);
        g.drawImage(img, 0, 0,longueur, hauteur, null);
    }

    public void paint(Graphics g)
    {
        affiche_fond(g);
    }

}
