import java.awt.*;
import java.io.File;
import javax.swing.JButton;

public class Bouton extends JButton {

    private int x, y;

    /**
     * Création d'un bouton
     * 
     * @param x,      l'abscisse
     * @param y,      l'odonné
     * @param width,  la largeur
     * @param height, la hauteur
     * @param name,   le texte
     */
    Bouton(int x, int y, int width, int height, String name) {
        super(name);
        Color myColor = new Color(1, 131, 148);
        Font font;
        File file;
        this.x = x;
        this.y = y;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        try { // Importation d'une police d'écriture
            file = new File("graphics/font/WIldrock.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, file);
            font = font.deriveFont(110.f);
            setFont(font);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        setForeground(myColor);
        setSize(width, height);
        setLocation(x, y);
    }

    /**
     * Création d'un bouton
     * 
     * @param x,      l'abscisse
     * @param y,      l'odonné
     * @param width,  la largeur
     * @param height, la hauteur
     * @param name,   le texte
     * @param size,   la taille
     */
    Bouton(int x, int y, int width, int height, String name, float size) {
        super(name);
        Color myColor = new Color(1, 131, 148);
        Font font;
        File file;
        this.x = x;
        this.y = y;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        try { // Importation d'une police d'écriture
            file = new File("graphics/font/WIldrock.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, file);
            font = font.deriveFont(size);
            setFont(font);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        setForeground(myColor);
        setSize(width, height);
        setLocation(x, y);
    }

    // Donne les coordonnées de l'abscisse du bouton
    public int get_x() {
        return x;
    }

    // Donne les coordonnées de l'ordonné du bouton
    public int get_y() {
        return y;
    }

}
