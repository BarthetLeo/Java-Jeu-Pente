import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import java.io.File;
import javax.swing.*;

public class Options extends JPanel {
    
    BufferedImage img;

    Options()
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
