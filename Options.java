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

public class Options extends JPanel implements ActionListener{
    
    BufferedImage img;

    Options()
    {
        try
        {
            img = ImageIO.read(new File("Ivanne.png"));
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
        Bouton Fullscreen = new Bouton(900,450,100,80,"Full");
        Bouton Revenir = new Bouton(900,650,100,80,"Revenir");
        Fullscreen.setActionCommand("Fullscreen");
        Revenir.setActionCommand("Revenir");
        Fullscreen.addActionListener(this);
        Revenir.addActionListener(this);
        this.add(Fullscreen);
        this.add(Revenir);
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getActionCommand().equals("Revenir")) {
            FenetreGraphique.window = 1;
            FenetreGraphique.changement = true;
        }

        else if (event.getActionCommand().equals("Fullscreen")) {
            FenetreGraphique.fullscreen = !FenetreGraphique.fullscreen;
            FenetreGraphique.changement = true;
        }
    }

    public void paintComponent(Graphics g)
    {
        affiche_fond(g);
    }
}