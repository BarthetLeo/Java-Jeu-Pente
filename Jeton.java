import java.awt.*;

public class Jeton extends Objet {
     private Color couleur = Color.yellow;
     private boolean sur_terrain;
     int n = 0;
    /**
     * Constructeur d'un jeton héritant de Objet.
     * @param x Le x du point ou le jeton sera ajouter
     * @param y Le y du point ou le jeton sera ajouter
     * @param width La longueur du jeton
     * @param heigth La largeur du jeton
     */
    public Jeton(int x,int y,int width,int heigth)
    {
        super(x,y,width,heigth);
        sur_terrain = false;
    }

    /**
     * Permet changer la couleur d'un joueur.
     * @param c Une couleur de type Color.
     */
    public void set_couleur(Color c)
    {
        couleur = c;
    }
    /**
     * Permet de modifier si un jeton est sur le terrain ou non
     * @param b 
     */
    public void set_sur_terrain(boolean b)
    {
        sur_terrain = b;
    }
    /**
     * Retourne si le jeton est sur le terrain
     * @return  le bool si il est sur le terrain
     */
    public boolean getbool()
    {return sur_terrain;}

    public void paintComponent(Graphics g)
    {
        
        {
            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(couleur);
            g2.fillOval(get_x(), get_y(), get_width(), get_heigth());
    
        }
    }

}
