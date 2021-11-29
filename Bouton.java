//import java.time.chrono.HijrahChronology;

import javax.swing.JButton;
public class Bouton extends JButton {
    
    int x,y,width,height;
    String name;

    Bouton(int x, int y, int width, int height, String name) {
        super(name);
        setSize(width, height);
        setLocation(x,y);
        JButton b = new JButton(name);
    }
}
