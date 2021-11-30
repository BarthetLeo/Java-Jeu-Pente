import javax.swing.*;
/*import java.util.*;
import java.awt.Toolkit;
import java.awt.Dimension;*/
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;

public class Menu extends JPanel implements ActionListener{
    
    BufferedImage img;
    Pente pente;

    Menu()
    {
        try
        {
            img = ImageIO.read(new File("image.jfif"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        creationBouton();
    }

    public void affiche_fond(Graphics g)
    {
        int hauteur = getHeight();
        int longueur = getWidth();
        g.setColor(Color.BLACK);
        g.drawImage(img, 0, 0,longueur, hauteur, null);
    }

    public void creationBouton()
    {
        Bouton Jouer = new Bouton(900,200,100,80,"Jouer");
        Bouton Option = new Bouton(900,400,100,80,"Option");
        Jouer.setActionCommand("Jouer");
        Option.setActionCommand("Options");
        Jouer.addActionListener(this);
        Option.addActionListener(this);
        this.add(Jouer);
        this.add(Option);
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getActionCommand().equals("Jouer")) {
            FenetreGraphique.jeux = true;
        }
    }

    public void paintComponent(Graphics g)
    {
        affiche_fond(g);
    }
}
