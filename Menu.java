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
    boolean show_fps = false;

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
        Bouton Jouer = new Bouton(900,250,100,80,"Jouer");
        Bouton Option = new Bouton(900,450,100,80,"Option");
        Bouton Quitter = new Bouton(900,650,100,80,"Quitter");
        Jouer.setActionCommand("Jouer");
        Option.setActionCommand("Option");
        Quitter.setActionCommand("Quitter");
        Jouer.addActionListener(this);
        Option.addActionListener(this);
        Quitter.addActionListener(this);
        this.add(Jouer);
        this.add(Option);
        this.add(Quitter);
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getActionCommand().equals("Jouer")) {
            FenetreGraphique.window = 2;
            FenetreGraphique.changement = true;
        }

        else if (event.getActionCommand().equals("Option")) {
            FenetreGraphique.window = 3;
            FenetreGraphique.changement = true;
        }

        else if (event.getActionCommand().equals("Quitter"))
        {
            System.exit(0);
        }
    }

    public void paintComponent(Graphics g)
    {
        affiche_fond(g);
        if(FenetreGraphique.affiche_fps)
        {
            int fps = (int)FenetreGraphique.fps;
            Font font = new Font("Verdana", Font.BOLD,20);
            g.setFont(font);
            g.drawString("FPS :", 25, 100);
            g.drawString("" + fps, 100, 100);
        }
    }
}