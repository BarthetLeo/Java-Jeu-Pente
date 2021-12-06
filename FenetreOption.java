import javax.swing.JFrame;
import java.util.*;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.*;

public class FenetreOption extends JFrame implements ActionListener{

    Options options;
    static boolean show = true;

    FenetreOption(String nom) {

        super(nom);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double _width = screenSize.getWidth() / 1.5;
        double _height = screenSize.getHeight() / 1.5;
        setSize((int) _width, (int) _height);
        setUndecorated(true);
        setOpacity(0.8f);
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(false);

        options = new Options(this);
        System.out.println("Options");
        options.setLayout(null);
        setContentPane(options);

        while (show) {
            repaint();
            setDefaultCloseOperation(FenetreOption.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent event) {

    }

}
