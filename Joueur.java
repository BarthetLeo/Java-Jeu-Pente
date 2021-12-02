
import java.awt.*;

public class Joueur {
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int ecart  = (((int)dimension.getWidth()/4)*3-16)/20;
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

    public void test_jeton()
    {
        if(get_pile() == 0)
        {
            FenetreGraphique.window = 1;
            FenetreGraphique.changement = true;
        }

    }

    public void alligner()
    {
        int jeton_alligner_x;
        int jeton_alligner_y;
        if(nb_elem >= 5)
        {
            for(int i = 0;i<nb_elem;i++)
            {
                jeton_alligner_x = 0;
                jeton_alligner_y = 0;
                for(int j = 0;j<nb_elem;j++)
                {
                    if(tab_jeton[i].get_x() == tab_jeton[j].get_x() & i != j)
                        if(tab_jeton[j].get_y() <= tab_jeton[i].get_y()+ecart*2 & tab_jeton[j].get_y() >= tab_jeton[i].get_y()-ecart*2)
                            jeton_alligner_x++;
                    
                    if(tab_jeton[i].get_y() == tab_jeton[j].get_y() & i != j)
                        if(tab_jeton[j].get_x() <= tab_jeton[i].get_x()+ecart*2 & tab_jeton[j].get_x() >= tab_jeton[i].get_x()-ecart*2)
                            jeton_alligner_y++;
                        
                        if(jeton_alligner_x == 4 | jeton_alligner_y == 4)
                        {
                            FenetreGraphique.window = 1;
                            FenetreGraphique.changement = true;
                            i = nb_elem;
                            j = nb_elem;
                        }
                    //System.out.println("jX1 = " + tab_jeton[i].get_x() +" " +i + " " + "jX2 = " + tab_jeton[j].get_x() + " "+j + " " + jeton_alligner_y);
                    //System.out.println("jY1 = " + tab_jeton[i].get_y() +" " +i + " " + "jY2 = " + tab_jeton[j].get_y() + " "+j + " " + jeton_alligner_x);
                    //System.out.println("i = " + i + " j =" + j + " NB= " + nb_elem + " jetonY = " + jeton_alligner_x + " jetonX = " + jeton_alligner_y);
                }
            }
        }

        
    }
}
