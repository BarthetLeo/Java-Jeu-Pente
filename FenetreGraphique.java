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
    static int vien_de;

    FenetreGraphique(String nom)
    {
        super(nom);
        changement = true;
        menu = new Menu();
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

        long temps_avant = System.nanoTime();
        long temps_apres = System.nanoTime();
        while (true) {

            temps_avant = System.nanoTime();

            double despacito = (temps_avant - temps_apres) / 1000000000.0;

            fps = 1/ despacito;
            temps_apres = temps_avant;

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
                        vien_de = window;
                        menu.setLayout(null);
                        System.out.println("Menu");;
                        setContentPane(menu);
                        
                        break;
                    }

                    case 2: {
                                 
                        //background = 2;
        
                        //Dimension screenSize = getSize();
                        //int width = getWidth();
                        //double height = screenSize.getHeight();
                        vien_de = window;
                        if(vien_de == 1)
                            pente = new Pente();
                        System.out.println("Jeux");
                        pente.setLayout(null);
                        setContentPane(pente);
                        nom1 = JOptionPane.showInputDialog(null, "Entrer le nom du J1","Joueur 1");
                        nom2 = JOptionPane.showInputDialog(null, "Entrer le nom du J2", "Joueur 2");
                        
                        
                        break;
                    }

                    case 3: {
                        System.out.println("Options");
                        options.setLayout(null);
                        vien_de = window;
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