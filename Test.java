import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
public class Test extends JPanel {
    
    public Test()
    {
        JButton oui = new JButton("Maib");
        oui.setSize(50, 50);
        oui.setLocation(1800,100);
    }

    public void paintComponent(Graphics g) {
        g.fillRect(1800, 100, 100, 100);
    }
}
