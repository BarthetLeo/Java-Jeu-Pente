import java.awt.Color;
import java.awt.event.*;


public class ListenerBouton implements ActionListener {
    private Pente pente;
    private Bouton bouton;
    private Jeton jeton;
    
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
                if(pente.J1.get_tour())
                {
                    jeton.set_couleur(pente.J1.get_couleur());
                    gestion_jeton(pente.J1);
                }
                else if(pente.J2.get_tour())
                {
                    jeton.set_couleur(pente.J2.get_couleur());
                    gestion_jeton(pente.J2);
                }
                enverser_tour(pente.J1,pente.J2);
                jeton.set_sur_terrain(true);
                pente.supprimer(bouton);
                pente.J2.test_jeton();
            }
        }
    }

    public void enverser_tour(Joueur j1,Joueur j2)
    {
        j1.set_tour(!j1.get_tour());
        j2.set_tour(!j2.get_tour());
    }

    public void gestion_jeton(Joueur j)
    {
        j.tour();
        j.get_tab()[j.get_nb_elem()] = jeton;
        j.add_jeton();
        j.alligner();
        //j.affiche();
    }

}
