import javax.swing.*;
//import java.util.*;
//import java.awt.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.*;

public class FenetreGraphique extends JFrame implements ActionListener{
    ZoneDessin zoneDessin;
    Menu menu;
    Pente pente;
    Options options;
    static int fenetre;

    FenetreGraphique(String nom)
    {
        super(nom);
        fenetre = 1; // 1 = menu // 2 = le jeux // 3 = option
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double _width = screenSize.getWidth();
        double _height = screenSize.getHeight();
        setSize((int)_width, (int)_height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(false);
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //TODO: handle exception
            }

            if(fenetre == 1) {
                //Dimension screenSize = getSize();
                int width = getWidth();
                //double height = screenSize.getHeight();
        
                System.out.println(width);
                    
                menu = new Menu();
                
                menu.setLayout(null);
        
                setContentPane(menu);

                repaint();
            }
    
            else if (fenetre == 2) {

                //Dimension screenSize = getSize();
                int width = getWidth();
                //double height = screenSize.getHeight();
        
                System.out.println(width);
                pente = new Pente();
                pente.setLayout(null);
                setContentPane(pente);
                repaint();
            }

            if (fenetre == 3) {
                
                options = new Options();

                options.setLayout(null);

                setContentPane(options);

                repaint();
            }

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

    }
    
    public void actionPerformed(ActionEvent event)
    {

    }

}
