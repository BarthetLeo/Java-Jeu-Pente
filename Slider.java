import javax.swing.JSlider;
import java.awt.Color;

public class Slider extends JSlider {

    /**
     * Création d'un slider horizontal
     * 
     * @param min
     * @param max
     * @param value
     */
    Slider(int min, int max, int value) {
        setMinimum(min);
        setMaximum(max);
        setValue(value);
        setOrientation(JSlider.HORIZONTAL);

        setOpaque(false);
        setFocusable(false);

        Color myColor = new Color(1, 131, 148);
        setBackground(myColor);

        setUI(new SliderUI(this));
    }
}
