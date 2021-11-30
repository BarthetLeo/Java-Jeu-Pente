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
        Bouton Jouer = new Bouton(900,800,100,80,"Quitter");
        Jouer.setActionCommand("Jouer");
        Jouer.addActionListener(this);
        this.add(Jouer);
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getActionCommand().equals("Quitter")) {
            FenetreGraphique.option = false;
        }
    }

    public void paintComponent(Graphics g)
    {
        affiche_fond(g);
    }
}
