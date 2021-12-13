
import java.awt.*;

public class Joueur {
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    public int ecart  = (((int)dimension.getWidth()/4)*3-16)/20;
    public int ecart_y = (int)dimension.getHeight()/20-1;
    private Color couleur_id;
    // Nombre de jeton restant.
    private int pile_jeton;
    // Savoir si c'est a son tour
    private boolean tour;
    private Jeton[] tab_jeton;
    private int nb_elem;
    private int nb_prise;
    private String pseudo;

    /**
     * Constructeur du joueur qui prend une couleur et un nom.
     * @param couleur_id  Couleur du joueur
     * @param pseudo   Nom du joueur
     */
    public Joueur(Color couleur_id,String pseudo)
    {
        this.pseudo = pseudo;
        this.couleur_id = couleur_id;
        pile_jeton = 60;
        tour = false;
        tab_jeton = new Jeton[pile_jeton];
        nb_elem = 0;
        nb_prise = 0;
    }
    /**
     * Retourne le nom du joueur
     * @return  nom du joueur
     */
    public String get_pseudo()
    {return pseudo;}

    /**
     * Retourne la couleur du joueur
     * @return  Couleur du joueur
     */
    public Color get_couleur() {
        return couleur_id;
    }

    /**
     * Permet de modifier le tour du joueur a son tour ou non.
     * @param b 
     */
    public void set_tour(boolean b) {
        tour = b;
    }
    /**
     * Retourne si le joueur est train de jouer ou non
     * @return  Le joueur joue ou non.
     */
    public boolean get_tour() {
        return tour;
    }
    /**
     * Retourne le nombre de jeton du joueur.
     * @return  le nombre de jeton restant.
     */
    public int get_pile() {
        return pile_jeton;
    }
    /**
    * Enleve un jeton au joueur.
    */
    public void tour() {
        pile_jeton--;
    }
    /**
     * Retourne le tableau de jeton acquis par le joueur
     * @return  tableau de jeton du joueur
     */
    public Jeton[] get_tab() {
        return tab_jeton;
    }
    /**
     * Agrandit la taille du tableau de 1.
     */
    public void add_jeton() {
        nb_elem++;
    }
    /**
     * Retourne le nombre de jeton que possède le joueur
     * @return  nombre de jeton possédés
     */
    public int get_nb_elem() {
        return nb_elem;
    }
    /**
     * Ajoute +1 au nombre de prise qu'a effectuer le joueur
     */
    public void add_prise() {
        nb_prise++;
    }
    /**
     * Retourne la valeur de prise faite par le joueur
     * @return  valeur de prise faite
     */
    public int get_prise() {
        return nb_prise;
    }
    /**
     * affiche la couleur et les jetons que possède le joueur
     */
    public void affiche()
    {
        System.out.println(couleur_id);
        for(int i=0;i<nb_elem;i++)
        {
            System.out.println("X :" + i + " "+ tab_jeton[i].get_x() + " Y :" + i + " "+ tab_jeton[i].get_y());
        }
    }
    /**
     * Test pour savoir si le joueur a gagner par prise ou par manque de jeton.
     */
    public void test_jeton() {
        if (get_pile() == 0 | nb_prise == 5) {
            gagner();
        }
    }
    /**
     * Enleve un jeton précis au joueur.
     * @param n Emplacement du jeton dans le tableau de jeton.
     */
    public void enlever(int n)
    {
        Color c=new Color(0,0,0,1 );
        tab_jeton[n].set_couleur(c);
        if(n == nb_elem)
            nb_elem --;
        else
        {
            tab_jeton[n] = tab_jeton[nb_elem-1];
            nb_elem--;
        }
    }
    /**
     * Ajoute un jeton dans le tableau de jeton
     * @param j Jeton a ajouter au joueur
     */
    public void ajouter(Jeton j) {
        j.set_couleur(couleur_id);
        tab_jeton[nb_elem] = j;
        add_jeton();
    }
    /**
     * Permet de savoir le nom du gagnant et d'aller a l'écran de victoire
     */
    public void gagner() {
        Pente.nom_gagnant = pseudo;
        FenetreGraphique.window = 4;
        FenetreGraphique.changement = true;
    }
    /**
     * Test de victoire par allignement de 5 jetons
     * Diagonales,verticale,horizontales.
     */
    public void alligner() {
        int jeton_alligner_x;
        int jeton_alligner_y;
        int jeton_diagonal_gd;
        int jeton_diagonal_dg;
        if(nb_elem >= 5)
        {
            for(int i = 0;i<nb_elem;i++)
            {
                jeton_alligner_x = 0;
                jeton_alligner_y = 0;
                jeton_diagonal_gd = 0;
                jeton_diagonal_dg = 0;
                for(int j = 0;j<nb_elem;j++)
                {
                    //5 jeton alginés vertical
                    if(tab_jeton[i].get_x() == tab_jeton[j].get_x() & i != j)
                        if(tab_jeton[j].get_y() <= tab_jeton[i].get_y()+ecart*2 & tab_jeton[j].get_y() >= tab_jeton[i].get_y()-ecart*2)
                            jeton_alligner_x++;

                    // 5 jeton alginés horizontale
                    if (tab_jeton[i].get_y() == tab_jeton[j].get_y() & i != j)
                        if (tab_jeton[j].get_x() <= tab_jeton[i].get_x() + ecart * 2
                                & tab_jeton[j].get_x() >= tab_jeton[i].get_x() - ecart * 2)
                            jeton_alligner_y++;
                
                    //5 Jeton aligner sur la diagonale de gauche a droite
                    if(tab_jeton[i].get_x()+ecart == tab_jeton[j].get_x() & tab_jeton[i].get_y()-ecart_y == tab_jeton[j].get_y())
                        {jeton_diagonal_gd++;}
                    if(tab_jeton[i].get_x()+ecart*2 == tab_jeton[j].get_x() & tab_jeton[i].get_y()-ecart_y*2 == tab_jeton[j].get_y())
                        {jeton_diagonal_gd++;}
                    if(tab_jeton[i].get_x()-ecart == tab_jeton[j].get_x() & tab_jeton[i].get_y()+ecart_y == tab_jeton[j].get_y())
                        {jeton_diagonal_gd++;}
                    if(tab_jeton[i].get_x()-ecart*2 == tab_jeton[j].get_x() & tab_jeton[i].get_y()+ecart_y*2 == tab_jeton[j].get_y())
                        {jeton_diagonal_gd++;}

                    //5 Jeton aligner sur la diagonale de droite a gauche
                    if(tab_jeton[i].get_x()+ecart == tab_jeton[j].get_x() & tab_jeton[i].get_y()+ecart_y == tab_jeton[j].get_y())
                        {jeton_diagonal_dg++;}
                    if(tab_jeton[i].get_x()+ecart*2 == tab_jeton[j].get_x() & tab_jeton[i].get_y()+ecart_y*2 == tab_jeton[j].get_y())
                        {jeton_diagonal_dg++;}
                    if(tab_jeton[i].get_x()-ecart == tab_jeton[j].get_x() & tab_jeton[i].get_y()-ecart_y == tab_jeton[j].get_y())
                        {jeton_diagonal_dg++;}
                    if(tab_jeton[i].get_x()-ecart*2 == tab_jeton[j].get_x() & tab_jeton[i].get_y()-ecart_y*2 == tab_jeton[j].get_y())
                        {jeton_diagonal_dg++;}

                    if(jeton_alligner_x == 4 | jeton_alligner_y == 4 | jeton_diagonal_gd == 4 | jeton_diagonal_dg == 4)
                    {
                        gagner();
                        i = nb_elem;
                        j = nb_elem;
                    }
                }
            }
        }
    }
}
