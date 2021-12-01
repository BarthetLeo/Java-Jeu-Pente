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
    static boolean changement, fullscreen = false, changeScreen = false;
    static double fps;
    static boolean affiche_fps = false;
    static String nom1;
    static String nom2;
    Test test;

    FenetreGraphique(String nom)
    {
        super(nom);
        changement = true;
        menu = new Menu();
        pente = new Pente();
        options = new Options();
        test = new Test();
        window = 1;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double _width = screenSize.getWidth();
        double _height = screenSize.getHeight();
        setSize((int)_width, (int)_height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(false);

        long jul = System.nanoTime();
        long papacito = System.nanoTime();
        while (true) {

            jul = System.nanoTime();

            double despacito = (jul - papacito) / 1000000000.0;

            fps = 1/ despacito;
            papacito = jul;

            /*try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //TODO: handle exception
            }*/

            if(changement) {
                changement = false;

                switch (window) {
                    case 1: {
                        //background = 1;
                        //Dimension screenSize = getSize();
                        //int width = getWidth();
                        //double height = screenSize.getHeight();
                
                        //System.out.println("width : " + width);
                        
                        menu.setLayout(null);
                
                        setContentPane(menu);
                        
                        break;
                    }

                    case 2: {
                                 
                        //background = 2;
        
                        //Dimension screenSize = getSize();
                        //int width = getWidth();
                        //double height = screenSize.getHeight();
                        System.out.println("Window 2");
                        pente.setLayout(null);
                        setContentPane(pente);
                        nom1 = JOptionPane.showInputDialog(null, "Entrer le nom du J1");
                        nom2 = JOptionPane.showInputDialog(null, "Entrer le nom du J2");
                        
                        
                        break;
                    }

                    case 3: {
                                
                        options.setLayout(null);
        
                        setContentPane(options);                  
                        break;
                    }
                
                    default:
                        break;
                }

                if (changeScreen) {

                    changeScreen = false;
                    dispose();

                    if (fullscreen) {
                        setUndecorated(true);
                    }
    
                    else if (!fullscreen){
                        setUndecorated(false);
                    }
                }

            }

            //int width = getWidth();
            //double height = screenSize.getHeight();
    
            //System.out.println("width : " + width);

            repaint();

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

    }
    
    public void actionPerformed(ActionEvent event)
    {

    }

}