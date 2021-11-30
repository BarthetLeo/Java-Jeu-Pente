//import java.time.chrono.HijrahChronology;

import javax.swing.JButton;
public class Bouton extends JButton {
    
    int x,y,width,height;
    String name;

    Bouton(int x, int y, int width, int height, String name) {
        super(name);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        JButton b = new JButton(name);
        setSize(width, height);
        setLocation(x,y);
    }
    public void position()
    {
        System.out.println(x);
        System.out.println(y);
    }
}
