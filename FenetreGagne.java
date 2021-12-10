import javax.swing.JPanel;

import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.awt.*;
import java.awt.event.*;


public class FenetreGagne extends JPanel implements ActionListener{
    private Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private int Height = (int) dimension.getHeight();
    private int Width = (int) dimension.getWidth();
    private BufferedImage img;
    private File file;
    private Font font;


    public FenetreGagne()
    {
        try {
            img = ImageIO.read(new File("graphics/images/fond_victoire.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            file = new File("graphics/font/WIldrock.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, file);
            font = font.deriveFont(100.f);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        creationBouton();
    }

    public void affiche_fond(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(img, 0, 0, Width, Height, null);
    }

    public void creationBouton()
    {
        Bouton Recommencer = new Bouton(Width/2+50, Height/2+110, 500, 110, "Recommencer");
        Recommencer.setActionCommand("Recommencer");
        Recommencer.addActionListener(this);
        this.add(Recommencer);

        Bouton Menu = new Bouton(Width/2-550, Height/2+110, 500, 110, "Menu");
        Menu.setActionCommand("Menu");
        Menu.addActionListener(this);
        this.add(Menu);

    }

    public void affiche_gagnant(Graphics g)
    {
        font = font.deriveFont(100.f);
        g.setFont(font);
        g.drawString("Bravo, " + Pente.nom_gagnant, Width/4+100, Height/5);
        g.drawString("Tu as gagné", Width/4+300, (Height/5)+100);
        font = font.deriveFont(40.f);
        g.setFont(font);
        g.drawString("Made by LOCHUNGVU Maxence, BARTHER Léo", (Width/10)*7, Height-30);
    }

    public void paintComponent(Graphics g)
    {
        affiche_fond(g);
        affiche_gagnant(g);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Recommencer")) {
            FenetreGraphique.vien_de = 1;
            FenetreGraphique.window = 2;
            FenetreGraphique.changement = true;
        }
        else if (event.getActionCommand().equals("Menu")) {
            FenetreGraphique.window = 1;
            FenetreGraphique.changement = true;
        }
    }
}