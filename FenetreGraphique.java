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
    static boolean jeux;

    FenetreGraphique(String nom)
    {
        super(nom);
        jeux = false;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int _width = (int)screenSize.getWidth();
        int _height = (int)screenSize.getHeight();
        setSize(_width,_height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                //TODO: handle exception
            }
            setResizable(false);
            setAlwaysOnTop(false);
            if(!jeux) {
                
                menu = new Menu();
                
                menu.setLayout(null);
                
                setContentPane(menu);
            }
            
            else if (jeux) {
        
                pente = new Pente();
                pente.setLayout(null);
                setContentPane(pente);
            }

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

    }
    
    public void actionPerformed(ActionEvent event)
    {

    }

}
