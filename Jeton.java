import javax.swing.JPanel;
import java.awt.*;

public class Jeton extends JPanel {
     int couleur;
     boolean sur_terrain;
     Bouton bouton;

    public Jeton(int couleur,Bouton bouton)
    {
        this.bouton = bouton;
        this.couleur = couleur;
        sur_terrain = false;
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.yellow);
        g2.fillOval(bouton.x, bouton.y, 50, 50);
    }
}
