import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent {
    private final BufferedImage displayImage;
    //Класс BufferedImage управляет изображением, содержимое которого можно записать
    public JImageDisplay(int width, int height) {
        displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension imageDimension = new Dimension(width, height);
        super.setPreferredSize(imageDimension);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(displayImage, 0, 0, getWidth(), getHeight(), null);
    }

    public void clearImage()
    {
        Graphics g = displayImage.getGraphics();
        ((Graphics) g).clearRect(0, 0, getWidth(), getHeight());
    }

    public void drawPixel(int x, int y, int rgbColor)
    {
        displayImage.setRGB(x, y, rgbColor);
    }

    public BufferedImage getImage() {
        return displayImage;
    }
}
