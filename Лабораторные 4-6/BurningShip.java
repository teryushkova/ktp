import java.awt.geom.Rectangle2D;

public class BurningShip extends FractalGenerator{

    public static final int MAX_ITERATIONS = 2000;

    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2.5;
        range.width = 4;
        range.height = 4;
    }

    public int numIterations(double x, double y) {
        int countIterations = 0;
        double a = 0;
        double b = 0;
        double a1, b1;
        while (countIterations < MAX_ITERATIONS && a * a + b * b < 4) {
            a1 = a * a - b * b + x;
            b1 = Math.abs(2 * a * b) + y;
            a = a1;
            b = b1;
            countIterations++;
        }
        if (countIterations == MAX_ITERATIONS) return -1;
        return countIterations;
    }

    public String toString() {
        return "BurningShip";
    }
}