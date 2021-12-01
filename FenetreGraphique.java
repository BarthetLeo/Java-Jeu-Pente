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
    static int window; /* 1 = menu // 2 = game // 3 = settings*///, background /* 1 = settings // 2 = game */;
    static boolean changement;

    FenetreGraphique(String nom)
    {
        super(nom);
        changement = true;
        menu = new Menu();
        pente = new Pente();
        options = new Options();
        window = 1;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double _width = screenSize.getWidth();
        double _height = screenSize.getHeight();
        setSize((int)_width, (int)_height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(false);
        while (true) {
            /*try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //TODO: handle exception
            }*/

            if(changement) {
                changement = false;

                if(window == 1) {
                    //background = 1;
                    //Dimension screenSize = getSize();
                    int width = getWidth();
                    //double height = screenSize.getHeight();
            
                    System.out.println("width : " + width);
                    
                    menu.setLayout(null);
            
                    setContentPane(menu);
    
                    repaint();
                }
        
                else if (window == 2) {
    
                    //background = 2;
    
                    //Dimension screenSize = getSize();
                    //int width = getWidth();
                    //double height = screenSize.getHeight();
                    System.out.println("Window 2");
                    pente.setLayout(null);
                    setContentPane(pente);
                    repaint();
                }
    
                if (window == 3) {
    
                    options.setLayout(null);
    
                    setContentPane(options);
    
                    repaint();
                }
            }

            int width = getWidth();
            //double height = screenSize.getHeight();
    
            System.out.println("width : " + width);

            repaint();

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

    }
    
    public void actionPerformed(ActionEvent event)
    {

    }

}