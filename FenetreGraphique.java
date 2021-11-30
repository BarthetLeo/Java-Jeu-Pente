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
        int _width = (int)screenSize.getWidth();
        int _height = (int)screenSize.getHeight();
        setSize(_width,_height);
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
<<<<<<< HEAD
            setResizable(false);
            setAlwaysOnTop(false);
            if(!jeux) {
                
=======

            if(fenetre == 1) {
                //Dimension screenSize = getSize();
                int width = getWidth();
                //double height = screenSize.getHeight();
        
                System.out.println(width);
                    
>>>>>>> f44143412ec2b726a995fbf26651d7bd852a0c47
                menu = new Menu();
                
                menu.setLayout(null);
                
                setContentPane(menu);

                repaint();
            }
<<<<<<< HEAD
            
            else if (jeux) {
=======
    
            else if (fenetre == 2) {

                //Dimension screenSize = getSize();
                int width = getWidth();
                //double height = screenSize.getHeight();
>>>>>>> f44143412ec2b726a995fbf26651d7bd852a0c47
        
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
