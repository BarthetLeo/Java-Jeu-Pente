import java.awt.event.*;

public class ListenerBouton implements ActionListener {
    private Pente pente;
    private Bouton bouton;
    private Jeton jeton;
    /**
     * Constructeur du Listener de bouton pour chaque bouton sur la grille.
     * @param pente Référence au jeux de pente actif
     * @param bouton Référence au bouton associer a ce Listener
     * @param jeton Référence au jeton associer au bouton
     */
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
                if(Pente.nb_regle >= 3)
                {
                    if(pente.J1.get_tour())
                    {
                        jeton.set_couleur(pente.J1.get_couleur());
                        gestion_jeton(pente.J1);
                        capture(pente.J1,pente.J2, jeton);
                    }
                    else if(pente.J2.get_tour())
                    {
                        jeton.set_couleur(pente.J2.get_couleur());
                        gestion_jeton(pente.J2);
                        capture(pente.J2,pente.J1, jeton);
                        pente.nb_tour++;
                    }
                }
                else if(Pente.nb_regle == 1)
                {
                    jeton.set_couleur(pente.J1.get_couleur());
                    gestion_jeton(pente.J1);
                    pente.regle_2();
                }

                else if(Pente.nb_regle == 2)
                {
                    jeton.set_couleur(pente.J2.get_couleur());
                    gestion_jeton(pente.J2);
                    pente.tableau_bouton();
                    pente.nb_tour++;
                    Pente.nb_regle = 3;
                }
                enverser_tour(pente.J1,pente.J2);
                jeton.set_sur_terrain(true);
                pente.supprimer(bouton);
            }
        }
    }
    /**
     * Enverse le tour des 2 joueurs.
     * @param j1    Joueur 1
     * @param j2    Joueur 2
     */
    public void enverser_tour(Joueur j1,Joueur j2)
    {
        j1.set_tour(!j1.get_tour());
        j2.set_tour(!j2.get_tour());
    }
    /**
     * Gére toutes les opérations a effectuer au sein du Joueur
     * @param j Joueur
     */
    public void gestion_jeton(Joueur j)
    {
        j.tour();
        j.get_tab()[j.get_nb_elem()] = jeton;
        j.add_jeton();
        j.alligner();
        j.test_jeton();
        //j.affiche();
    }
    /**
     * Permet de créer un bouton a l'emplacement d'un jeton.
     */
    public void ajout_bouton(Jeton jeton_j)
    {
        Bouton bt = new Bouton(jeton_j.get_x(), jeton_j.get_y(), 34, 34, "");
        bt.setBorderPainted(false);
        bt.setContentAreaFilled(false);
        bt.setFocusPainted(false);
        // On définie le nom de l'action
        bt.setActionCommand("Cliquez");
        // On créer un nouveau ListenerBouton pour le bouton
        bt.addActionListener(new ListenerBouton(pente, bt, jeton_j));
        pente.add(bt);
    }
    /**
     * On vérifie sur le jeton placée si on peut on capturer des jetons.
     * 
     * @param j1 Joueur a qui appartient le jeton
     * @param j2 Joueur a retirer les jetons
     * @param jeton Jeton qui vient d'etre placer
     */
    public void capture(Joueur j1,Joueur j2,Jeton jeton)
    {
        int nb;
        if(j1.get_pile() < 58)
        {
            for(int i = 0;i<j1.get_nb_elem();i++)
            {
                //Par rapport au jeton placer on compare si il existe un jeton a 2 d'espace a gauche.
                if(jeton.get_x()-j1.ecart*3 == j1.get_tab()[i].get_x()&  j1.get_tab()[i].get_y() == jeton.get_y())
                {   
                    nb = 1;
                    compare_capture(j1, j2, nb);
                }
                //Par rapport au jeton placer on compare si il existe un jeton a 2 d'espace a droite.
                else if(jeton.get_x()+j1.ecart*3 == j1.get_tab()[i].get_x()&  j1.get_tab()[i].get_y() == jeton.get_y())
                { 
                    nb = 2;
                    compare_capture(j1, j2, nb);
                }
                //Par rapport au jeton placer on compare si il existe un jeton a 2 d'espace en haut.
                else if(jeton.get_y()-j1.ecart_y*3 == j1.get_tab()[i].get_y() & j1.get_tab()[i].get_x() == jeton.get_x())
                {
                    nb = 3;
                    compare_capture(j1, j2, nb);
                }
                //Par rapport au jeton placer on compare si il existe un jeton a 2 d'espace en bas.
                else if(jeton.get_y()+j1.ecart_y*3 == j1.get_tab()[i].get_y() & j1.get_tab()[i].get_x() == jeton.get_x())
                {
                    nb = 4;
                    compare_capture(j1, j2, nb);
                }
                //Par rapport au jeton placer on compare si il existe un jeton a 2 d'espace en bas a gauche.
                else if(jeton.get_x()+j1.ecart*3 == j1.get_tab()[i].get_x() & jeton.get_y()-j1.ecart_y*3 == j1.get_tab()[i].get_y())
                {
                    nb = 5;
                    compare_capture(j1, j2, nb);
                }
                //Par rapport au jeton placer on compare si il existe un jeton a 2 d'espace en haut a gauche.
                else if(jeton.get_x()+j1.ecart*3 == j1.get_tab()[i].get_x() & jeton.get_y()+j1.ecart_y*3 == j1.get_tab()[i].get_y())
                {
                    nb = 6;
                    compare_capture(j1, j2, nb);
                }
                //Par rapport au jeton placer on compare si il existe un jeton a 2 d'espace en bas a droite.
                else if(jeton.get_x()-j1.ecart*3 == j1.get_tab()[i].get_x() & jeton.get_y()+j1.ecart_y*3 == j1.get_tab()[i].get_y())
                {
                    nb = 7;
                    compare_capture(j1, j2, nb);
                }
                //Par rapport au jeton placer on compare si il existe un jeton a 2 d'espace en haut a droite.
                else if(jeton.get_x()-j1.ecart*3 == j1.get_tab()[i].get_x() & jeton.get_y()-j1.ecart_y*3 == j1.get_tab()[i].get_y())
                {
                    nb = 8;
                    compare_capture(j1, j2, nb);
                }
            }
        }
    }
    /**
     * Compare si il existe bien 2 jetons adverses entre les 2 jetons trouver 
     * @param j1 Joueur a qui appartient le jeton
     * @param j2 Joueur a retirer les jetons
     * @param nb_case   Le nombre qui permet de déterminer sur quels cas il y a les 2 jetons
     */
    public void compare_capture(Joueur j1,Joueur j2,int nb_case)
    {
        boolean loin=false,pres=false;
        int nb1 = 0,nb2 = 0;
        
        switch(nb_case){
            //On vérifie si il existe bien les 2 jetons adverses entre le jeton comparer et le jeton a 2 d'espace a gauche.
            case 1:{
                for(int k = 0;k<j2.get_nb_elem();k++)
                {
                    if(j2.get_tab()[k].get_x() == jeton.get_x()-j1.ecart & j2.get_tab()[k].get_y() == jeton.get_y())
                    {
                        pres = true;
                        nb1 = k;
                        
                    }
                    if(j2.get_tab()[k].get_x() == jeton.get_x()-j1.ecart*2 & j2.get_tab()[k].get_y() == jeton.get_y())
                    {
                        loin = true;
                        nb2 = k;
                    }
                    if(loin & pres)
                    {
                        jeton_pris(j1, j2, nb1, nb2);
                        break;
                    }
                }
                break;
            }
            //On vérifie si il existe bien les 2 jetons adverses entre le jeton comparer et le jeton a 2 d'espace a droite.
            case 2:{
                for(int k = 0;k<j2.get_nb_elem();k++)
                {
                    if(j2.get_tab()[k].get_x() == jeton.get_x()+j1.ecart & j2.get_tab()[k].get_y() == jeton.get_y() )
                    {
                        pres = true;
                        nb1 = k;
                    }
                    if(j2.get_tab()[k].get_x() == jeton.get_x()+j1.ecart*2& j2.get_tab()[k].get_y() == jeton.get_y() )
                    {
                        loin = true;
                        nb2 = k;
                    }
                    if(loin & pres)
                    {
                        jeton_pris(j1, j2, nb1, nb2);
                        break;
                    }
                }
                break;
            }
            //On vérifie si il existe bien les 2 jetons adverses entre le jeton comparer et le jeton a 2 d'espace en haut.
            case 3:{

                for(int k = 0;k<j2.get_nb_elem();k++)
                {
                    if(j2.get_tab()[k].get_y() == jeton.get_y()-j1.ecart_y & j2.get_tab()[k].get_x() == jeton.get_x() )
                    {
                        pres = true;
                        nb1 = k;
                    }
                    if(j2.get_tab()[k].get_y() == jeton.get_y()-j1.ecart_y*2 & j2.get_tab()[k].get_x() == jeton.get_x() )
                    {
                        loin = true;
                        nb2 = k;
                    }
                    if(loin & pres)
                    {
                        jeton_pris(j1, j2, nb1, nb2);
                        break;
                    }
                }
                break;
            }
            //On vérifie si il existe bien les 2 jetons adverses entre le jeton comparer et le jeton a 2 d'espace en bas.
            case 4:{

                for(int k = 0;k<j2.get_nb_elem();k++)
                {
                    if(j2.get_tab()[k].get_y() == jeton.get_y()+j1.ecart_y & j2.get_tab()[k].get_x() == jeton.get_x() )
                    {
                        pres = true;
                        nb1 = k;
                    }
                    if(j2.get_tab()[k].get_y() == jeton.get_y()+j1.ecart_y*2 & j2.get_tab()[k].get_x() == jeton.get_x() )
                    {
                        loin = true;
                        nb2 = k;
                    }
                    if(loin & pres)
                    {
                        jeton_pris(j1, j2, nb1, nb2);
                        break;
                    }
                }
                break;
            }
            //On vérifie si il existe bien les 2 jetons adverses entre le jeton comparer et le jeton a 2 d'espace en bas a gauche.
            case 5:{

                for(int k = 0;k<j2.get_nb_elem();k++)
                {
                    if(j2.get_tab()[k].get_x() == jeton.get_x()+j1.ecart & j2.get_tab()[k].get_y() == jeton.get_y()-j1.ecart_y)
                    {
                        pres = true;
                        nb1 = k;
                    }
                    if(j2.get_tab()[k].get_x() == jeton.get_x()+j1.ecart*2 & j2.get_tab()[k].get_y() == jeton.get_y()-j1.ecart_y*2)
                    {
                        loin = true;
                        nb2 = k;
                    }
                    if(loin & pres)
                    {
                        jeton_pris(j1, j2, nb1, nb2);
                        break;
                    }
                }
                break;
            }
            //On vérifie si il existe bien les 2 jetons adverses entre le jeton comparer et le jeton a 2 d'espace en haut a gauche.
            case 6:{
                for(int k = 0;k<j2.get_nb_elem();k++)
                {
                    if(j2.get_tab()[k].get_x() == jeton.get_x()+j1.ecart & j2.get_tab()[k].get_y() == jeton.get_y()+j1.ecart_y)
                    {
                        pres = true;
                        nb1 = k;
                    }
                    if(j2.get_tab()[k].get_x() == jeton.get_x()+j1.ecart*2 & j2.get_tab()[k].get_y() == jeton.get_y()+j1.ecart_y*2)
                    {
                         
                        loin = true;
                        nb2 = k;
                    }
                    if(loin & pres)
                    {
                        jeton_pris(j1, j2, nb1, nb2);
                        break;
                    }
                }
                break;
            }
            //On vérifie si il existe bien les 2 jetons adverses entre le jeton comparer et le jeton a 2 d'espace en bas a droite.
            case 7:{

                for(int k = 0;k<j2.get_nb_elem();k++)
                {
                    if(j2.get_tab()[k].get_x() == jeton.get_x()-j1.ecart & j2.get_tab()[k].get_y() == jeton.get_y()+j1.ecart_y)
                    {
                        pres = true;
                        nb1 = k;
                    }
                    if(j2.get_tab()[k].get_x() == jeton.get_x()-j1.ecart*2 & j2.get_tab()[k].get_y() == jeton.get_y()+j1.ecart_y*2)
                    {
                        loin = true;
                        nb2 = k;
                    }
                    if(loin & pres)
                    {
                        jeton_pris(j1, j2, nb1, nb2);
                        break;
                    }
                }
                break;
            }
            //On vérifie si il existe bien les 2 jetons adverses entre le jeton comparer et le jeton a 2 d'espace en haut a droite.
            case 8:{

                for(int k = 0;k<j2.get_nb_elem();k++)
                {
                    if(j2.get_tab()[k].get_x() == jeton.get_x()-j1.ecart & j2.get_tab()[k].get_y() == jeton.get_y()-j1.ecart_y)
                    {
                        pres = true;
                        nb1 = k;
                    }
                    if(j2.get_tab()[k].get_x() == jeton.get_x()-j1.ecart*2 & j2.get_tab()[k].get_y() == jeton.get_y()-j1.ecart_y*2)
                    {
                        loin = true;
                        nb2 = k;
                    }
                    if(loin & pres)
                    {
                        jeton_pris(j1, j2, nb1, nb2);
                        break;
                    }
                }
                break;
            }
            }
    }
    /**
     * Gestion des jetons si il sont bien pris.
     * @param j1 Joueur recevant les jetons
     * @param j2 Joueur donnant les jetons
     * @param nb1 Emplacement du jeton 1 dans le tableau de jeton de j2
     * @param nb2 Emplacement du jeton 2 dans le tableau de jeton de j2
     */
    public void jeton_pris(Joueur j1,Joueur j2,int nb1,int nb2)
    {
        ajout_bouton(j2.get_tab()[nb1]);
        ajout_bouton(j2.get_tab()[nb2]);
        j2.enlever(nb1);
        j2.enlever(nb2);
        j1.add_prise();
        j1.test_jeton();
        j1.alligner();
    }
}

