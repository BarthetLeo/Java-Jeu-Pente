//import java.time.chrono.HijrahChronology;

import javax.swing.JButton;
public class Bouton extends JButton {
    
    int x,y,width,height;
    String name;

    Bouton(int x, int y, int width, int height, String name) {
        super(name);
        this.x = x;
        this.y = y;
        setSize(width, height);
        setLocation(x,y);
    }

    void position()
    {
        System.out.println(x);
        System.out.println(y);
    }
}
