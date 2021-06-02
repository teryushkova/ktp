import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    public static final int MAX_ITERATIONS = 4000;
    // Константфа с максимальным количеством итераций
    public void getInitialRange(Rectangle2D.Double range)
    {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }
    public int numIterations(double x, double y)
    {
        int countIteration = 0;
        double a = 0;  // действительная часть
        double b = 0;   // мнимая часть
        double a1, b1;
        while (a * a + b * b < 4 && countIteration < MAX_ITERATIONS)
        {
            a1 = a * a - b * b + x;
            b1 = -2 * a * b + y;
            a = a1;
            b = b1;
            countIteration ++;
        }
        if (countIteration == MAX_ITERATIONS)
        {
            return -1;
        }
        return countIteration;
    }
    public String toString(){
        return "Mandelbrot";
    }

}
