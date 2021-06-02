import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class FractalExplorer {
    private final int displaySize;
    private final JImageDisplay display;
    private FractalGenerator fractal;
    private final Rectangle2D.Double range;

    public FractalExplorer(int size) {
        displaySize = size;
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractal.getInitialRange(range);
        display = new JImageDisplay(displaySize, displaySize);

    }

    public void createAndShowGUI() {
        display.setLayout(new BorderLayout());
        JFrame frame = new JFrame("Fractal");
        frame.add(display, BorderLayout.CENTER);
        JButton resetButton = new JButton("reset");
        ResetHandler handler = new ResetHandler();
        resetButton.addActionListener(handler);


        frame.add(resetButton, BorderLayout.SOUTH);
        MouseHandler click = new MouseHandler();
        display.addMouseListener((MouseListener) click);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void drawFractal() {
        for (int x = 0; x < displaySize; x++) {
            for (int y = 0; y < displaySize; y++) {
                double xCoord = FractalGenerator.getCoord(
                        range.x, range.x + range.width, displaySize, x);
                double yCoord = FractalGenerator.getCoord(
                        range.y, range.y + range.height, displaySize, y);
                int iteration = fractal.numIterations(xCoord, yCoord);
                if (iteration == -1) {
                    display.drawPixel(x, y, 0);
                } else {
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    display.drawPixel(x, y, rgbColor);
                }
            }
        }
        display.repaint();
    }

    /**
     * внутренний класс для обработки событий java.awt.event.ActionListener от кнопки сброса
     **/
    private class ResetHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fractal.getInitialRange(range);
            drawFractal();
        }
    }

    private class MouseHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            double xCoord = FractalGenerator.getCoord(
                    range.x, range.x + range.width, displaySize, x);
            int y = e.getY();
            double yCoord = FractalGenerator.getCoord(
                    range.y, range.y + range.height, displaySize, y);
            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }



    /**
     * Класс для обработки combo
     * <p>
     * Box
     **/
    private class ComboBoxHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JComboBox comboBox = (JComboBox) event.getSource();
            fractal = (FractalGenerator) comboBox.getSelectedItem();
            fractal.getInitialRange(range);
            drawFractal();
        }
    }

    /**
     * Класс для обработки кнопки "Сохранить"
     **/
    private class SaveHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
// Отвечает за сохранение файлов в png
            JFileChooser chooser = new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
            chooser.setFileFilter(filter);
            chooser.setAcceptAllFileFilterUsed(false);

// Вывод экрана сохранения
            int userSelection = chooser.showSaveDialog(display);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                java.io.File file = chooser.getSelectedFile();
                String file_name = file.toString();

                try {
                    BufferedImage displayImage = display.getImage();
                    ImageIO.write(displayImage, "png", file);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(
                            display, exception.getMessage(),
                            "Невозможно сохранить изображение", JOptionPane.ERROR_MESSAGE);
                }
            }
        }


        private class MouseHandler extends MouseAdapter {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);

                int y = e.getY();
                double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y);

                fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

                 drawFractal();
            }
        }


        public void main(String[] args) {
            FractalExplorer fractalExplorer = new FractalExplorer(800);
            fractalExplorer.createAndShowGUI();
            fractalExplorer.drawFractal();
        }
    }
}