import javax.swing.JPanel;

public class Objet extends JPanel {
    private int x,y,width,height;

    public Objet(int _x, int _y,int _width, int _height)
    {
        this.x = _x;
        this.y = _y;
        this.width = _width;
        this.height = _height;
    }
    
    public  int get_x()
    {return x;}
    public   int get_y()
    {return y;}
    public  int get_width()
    {return width;}
    public  int get_heigth()
    {return height;}
}
