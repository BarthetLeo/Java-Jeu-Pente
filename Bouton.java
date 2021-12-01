//import java.time.chrono.HijrahChronology;

import javax.swing.JButton;
public class Bouton extends JButton {
    
    private int x,y;

    Bouton(int x, int y, int width, int height, String name) {
        super(name);
        this.x = x;
        this.y = y;
        setSize(width, height);
        setLocation(x,y);
    }

    public int get_x()
    {
        return x;
    }
    public int get_y()
    {
        return y;
    }
    
}
