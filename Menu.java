import java.util.*;
import javax.swing.*;
import java.util.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import java.io.File;

public class Menu extends JPanel{
    
    BufferedImage img;

    Menu()
    {
        try
        {
            img = ImageIO.read(new File("image.jfif"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
