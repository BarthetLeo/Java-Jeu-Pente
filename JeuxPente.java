import java.util.*;

public class JeuxPente
{
    static boolean close;
    public static void main(String [] args)
    {
        close = true;

        FenetreGraphique f = new FenetreGraphique("Jeux");

        if (!close) {
            f.dispose();
        }
    }

}