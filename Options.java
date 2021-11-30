import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import java.io.File;
import javax.swing.*;

public class Options extends JPanel {
    
    BufferedImage img;

    Options()
    {
        try
        {
            img = ImageIO.read(new File("image.jfif"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
=======
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
>>>>>>> parent of f441434 (oui)
}
