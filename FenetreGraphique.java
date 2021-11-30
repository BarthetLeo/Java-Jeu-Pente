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
<<<<<<< HEAD
    static boolean jeux;
=======
    Options options;
    static boolean jeux;
    static boolean option;
>>>>>>> parent of f441434 (oui)

    FenetreGraphique(String nom)
    {
        super(nom);
<<<<<<< HEAD
=======
        option = false;
>>>>>>> parent of f441434 (oui)
        jeux = false;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double _width = screenSize.getWidth();
        double _height = screenSize.getHeight();
        setSize((int)_width, (int)_height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                //TODO: handle exception
            }
<<<<<<< HEAD
            setResizable(false);
            setLocationRelativeTo(null);
            setAlwaysOnTop(false);
=======

            if (option) {
                
                options = new Options();

                options.setLayout(null);

                setContentPane(options);

                repaint();
            }

>>>>>>> parent of f441434 (oui)
            if(!jeux) {
                //Dimension screenSize = getSize();
                int width = getWidth();
                //double height = screenSize.getHeight();
        
                System.out.println(width);
                    
                menu = new Menu();
                
                menu.setLayout(null);
        
                setContentPane(menu);
            }
    
            else if (jeux) {

                //Dimension screenSize = getSize();
                int width = getWidth();
                //double height = screenSize.getHeight();
        
                System.out.println(width);
                pente = new Pente();
                pente.setLayout(null);
                setContentPane(pente);
<<<<<<< HEAD
            }
=======
                repaint();
            }

>>>>>>> parent of f441434 (oui)

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

    }
    
    public void actionPerformed(ActionEvent event)
    {

    }

}
