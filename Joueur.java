
import javax.swing.*;
import java.awt.*;

public class Joueur {
    private String pseudo;
    private Color couleur_id;
    //Nombre de jeton restant.
    private int pile_jeton;

    //Constructeur du Joueur.
    public Joueur(String pseudo, Color couleur_id)
    {
        this.pseudo = pseudo;
        this.couleur_id = couleur_id;
        pile_jeton = 60;
    }

    public Color get_couleur()
    {
        return couleur_id;
    }
}
