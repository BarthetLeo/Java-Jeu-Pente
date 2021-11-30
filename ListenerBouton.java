import java.awt.event.*;

public class ListenerBouton implements ActionListener {
    private Pente pente;
    private Bouton bouton;
    private Jeton jeton;
    
    public ListenerBouton(Pente pente,Bouton bouton)
    {
        this.bouton = bouton;
        this.pente = pente;
        jeton = new Jeton(1, bouton);
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getActionCommand().equals("Cliquez")) {
            {bouton.position();
             pente.ajout_jeton(bouton);
             pente.supprimer(bouton);
            }
        }
    }
}
