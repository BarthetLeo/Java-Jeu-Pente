
public class Joueur {
    String pseudo;
    int couleur_id;
    //Nombre de jeton restant.
    int pile_jeton;

    //Constructeur du Joueur.
    public Joueur(String pseudo, int couleur_id)
    {
        this.pseudo = pseudo;
        this.couleur_id = couleur_id;
        pile_jeton = 60;
    }
}
