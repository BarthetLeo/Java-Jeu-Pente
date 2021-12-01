import java.awt.*;

public class Jeton extends Objet {
     private int couleur;
     private boolean sur_terrain;
     int n = 0;

    public Jeton(int couleur,int x,int y,int width,int heigth)
    {
        super(x,y,width,heigth);
        this.couleur = couleur;
        sur_terrain = false;
    }
    public void set_sur_terrain(boolean b)
    {
        sur_terrain = b;
    }

    public boolean getbool()
    {return sur_terrain;}

    public void paintComponent(Graphics g)
    {
        
        {
            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(Color.yellow);
            g2.fillOval(get_x(), get_y(), get_width(), get_heigth());
    
        }
    }
}
