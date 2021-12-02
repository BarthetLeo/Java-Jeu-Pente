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
    static boolean vien_jeu;
    private String action_rev = "Revenir";

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
        if(vien_jeu)
        {action_rev = "Revenir_Jeu";}

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
        //Bouton plein écran
        Bouton Fullscreen = new Bouton(900,450,100,80,"Full");
        Fullscreen.setActionCommand("Fullscreen");
        Fullscreen.addActionListener(this);
        this.add(Fullscreen);

        //Bouton Afficher les FPS
        Bouton AfficherFPS = new Bouton(900, 250, 120, 80, "Afficher Fps");
        AfficherFPS.setActionCommand("AfficherFPS");
        AfficherFPS.addActionListener(this);
        this.add(AfficherFPS);

        //Bouton Revenir au menu principal
        Bouton Revenir = new Bouton(900,650,100,80,"Revenir");
        Revenir.setActionCommand(action_rev);
        Revenir.addActionListener(this);
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
            FenetreGraphique.changeScreen = true;
            FenetreGraphique.changement = true;
        }
        else if(event.getActionCommand().equals("AfficherFPS"))
        {
            FenetreGraphique.affiche_fps = !FenetreGraphique.affiche_fps;
        }
        else if(event.getActionCommand().equals("Revenir_Jeu")) {
            FenetreGraphique.window = 2;
            FenetreGraphique.changement = true;
        }

    }

    public void paintComponent(Graphics g)
    {
        affiche_fond(g);
        if(FenetreGraphique.affiche_fps)
        {
            Menu.creation_fps(g);
        }
    }
}