import javax.swing.*;
import java.util.*;
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
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //double width = screenSize.getWidth();
        //double height = screenSize.getHeight();
        //setSize((int)width, (int)height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(false);

        //Dimension screenSize = getSize();
        double width = getWidth();
        //double height = screenSize.getHeight();

        System.out.println(width);
            
        if (!jeux) {
            menu = new Menu();
            
            Bouton Jouer = new Bouton(900,200,100,80,"Jouer");
            Bouton Option = new Bouton(900,400,100,80,"Option");

            menu.setLayout(null);

            setContentPane(menu);
            getContentPane().add(Jouer);
            getContentPane().add(Option);
        }

        else {
            pente = new Pente();
            setContentPane(pente);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {

    }
    

}
