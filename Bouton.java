
//import java.time.chrono.HijrahChronology;
import java.awt.*;
import java.io.File;
import javax.swing.JButton;

public class Bouton extends JButton {

    private int x, y;

    Bouton(int x, int y, int width, int height, String name) {
        super(name);
        Color myColor = new Color(1, 131, 148);
        Font font;
        File file;
        this.x = x;
        this.y = y;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        try {
            file = new File("graphics/font/WIldrock.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, file);
            font = font.deriveFont(110.f);
            setFont(font);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        setForeground(myColor);
        setSize(width, height);
        setLocation(x, y);
    }

    public int get_x() {
        return x;
    }

    public int get_y() {
        return y;
    }

}
