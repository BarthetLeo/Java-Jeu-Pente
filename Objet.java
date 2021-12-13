import javax.swing.JPanel;

public class Objet extends JPanel {
    private int x,y,width,height;
    /**
     * Constructeur d'un objet
     * @param _x coordonées x du point en haut a gauche ou sera placé l'objet
     * @param _y coordonées y du point en haut a gauche ou sera placé l'objet
     * @param _width  Longueur de l'objet
     * @param _height Largeur de l'objet
     */
    public Objet(int _x, int _y,int _width, int _height)
    {
        this.x = _x;
        this.y = _y;
        this.width = _width;
        this.height = _height;
    }
    /**
     * Revoie la coordonées x du point en haut a gauche 
     */
    public  int get_x()
    {return x;}
    /**
     * Revoie la coordonées y du point en haut a gauche 
     */
    public   int get_y()
    {return y;}
    /**
     * Renvoie la longueur de l'objet
     */
    public  int get_width()
    {return width;}
    /**
     * Renvoie la largeur de l'objet
     */
    public  int get_heigth()
    {return height;}
}
