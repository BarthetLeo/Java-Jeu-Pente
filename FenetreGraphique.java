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
        jeux = true;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //double width = screenSize.getWidth();
        //double height = screenSize.getHeight();
        //setSize((int)width, (int)height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setLocationRelativeTo(null);
        setAlwaysOnTop(false);
            
        if (!jeux) {
            menu = new Menu();
            menu.setLayout(null);
            Bouton Jouer = new Bouton(400,200,100,80,"Jouer");
            JButton Option = new JButton("Option");

            setContentPane(menu);
            getContentPane().add(Jouer);
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
