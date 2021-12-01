
import java.awt.*;

public class Joueur {
    private String pseudo;
    private Color couleur_id;
    //Nombre de jeton restant.
    private int pile_jeton;
    private boolean tour;

    //Constructeur du Joueur.
    public Joueur(String pseudo, Color couleur_id)
    {
        this.pseudo = pseudo;
        this.couleur_id = couleur_id;
        pile_jeton = 60;
        tour = false;
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
}
