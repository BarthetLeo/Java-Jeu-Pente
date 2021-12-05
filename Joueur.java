
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

    //Constructeur du Joueur.
    public Joueur(Color couleur_id)
    {
        this.couleur_id = couleur_id;
        pile_jeton = 60;
        tour = false;
        tab_jeton = new Jeton[pile_jeton];
        nb_elem = 0;
        nb_prise = 0;
    }

    public Color get_couleur() {
        return couleur_id;
    }

    public void set_tour(boolean b) {
        tour = b;
    }

    public boolean get_tour() {
        return tour;
    }

    public int get_pile() {
        return pile_jeton;
    }

    public void tour() {
        pile_jeton--;
    }

    public Jeton[] get_tab() {
        return tab_jeton;
    }

    public void add_jeton() {
        nb_elem++;
    }

    public int get_nb_elem() {
        return nb_elem;
    }

    public void add_prise() {
        nb_prise++;
    }

    public int get_prise() {
        return nb_prise;
    }

    public void affiche()
    {
        System.out.println(couleur_id);
        for(int i=0;i<nb_elem;i++)
        {
            System.out.println("X :" + i + " "+ tab_jeton[i].get_x() + " Y :" + i + " "+ tab_jeton[i].get_y());
        }
    }

    public void test_jeton() {
        if (get_pile() == 0 | nb_prise == 5) {
            gagner();
        }
    }

    public void enlever(int n)
    {
        if(n == nb_elem)
            nb_elem --;
        else
        {
            tab_jeton[n] = tab_jeton[nb_elem-1];
            nb_elem--;
        }
    }

    public void ajouter(Jeton j) {
        j.set_couleur(couleur_id);
        tab_jeton[nb_elem] = j;
        add_jeton();
    }

    public void gagner() {
        FenetreGraphique.window = 1;
        FenetreGraphique.changement = true;
    }

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
