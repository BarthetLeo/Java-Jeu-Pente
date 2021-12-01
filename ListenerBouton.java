import java.awt.Color;
import java.awt.event.*;

public class ListenerBouton implements ActionListener {
    private Pente pente;
    private Bouton bouton;
    private Jeton jeton;
    static int compteur = 0;
    
    public ListenerBouton(Pente pente,Bouton bouton,Jeton jeton)
    {
        this.bouton = bouton;
        this.pente = pente;
        this.jeton = jeton;
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getActionCommand().equals("Cliquez")) {
            {
                if(compteur%2 == 0)
                {
                    jeton.set_couleur(Color.red);
                }
                jeton.set_sur_terrain(true);
                pente.supprimer(bouton);
                compteur++;
            }
        }
    }
}
