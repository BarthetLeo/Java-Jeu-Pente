import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class SliderUI extends BasicSliderUI {

    SliderUI(JSlider slider) {
        super(slider);
    }

    /**
     * Décoration du slider
     */
    public void paintTrack(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(slider.getBackground());
        g2.fillOval(2, slider.getHeight() / 2 - 2, slider.getWidth() - 2, 5);
    }
}
