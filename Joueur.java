
import java.awt.*;

public class Joueur {
    private String pseudo;
    private Color couleur_id;
    //Nombre de jeton restant.
    private int pile_jeton;
    //Savoir si c'est a son tour
    private boolean tour;
    private Jeton[] tab_jeton;
    private int nb_elem;

    //Constructeur du Joueur.
    public Joueur(String pseudo, Color couleur_id)
    {
        this.pseudo = pseudo;
        this.couleur_id = couleur_id;
        pile_jeton = 60;
        tour = false;
        tab_jeton = new Jeton[pile_jeton];
        nb_elem = 0;
    }

    public Color get_couleur()
    {return couleur_id;}
    
    public void set_tour(boolean b)
    {tour = b;}

    public boolean get_tour()
    {return tour;}

    public int get_pile()
    {return pile_jeton;}

    public void tour()
    {pile_jeton--;}

    public Jeton[] get_tab()
    {return tab_jeton;}

    public void add_jeton()
    {nb_elem++;}

    public int get_nb_elem()
    {return nb_elem;}

    public void affiche()
    {
        for(int i=0;i<nb_elem;i++)
        {
            System.out.println("X :" + i + " "+ tab_jeton[i].get_x());
            System.out.println("Y :" + i + " "+ tab_jeton[i].get_y());
        }
    }
}
