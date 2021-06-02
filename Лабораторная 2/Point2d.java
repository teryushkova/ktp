public class Point2d {
    private double CrdX; // Объявление локальной переменной, координата X
    private double CrdY; // Объявление локальной переменной, координата Y
    public static void main(String[] args)
    {
        Point2d point = new Point2d(Double.valueOf(args[0]), Double.valueOf(args[1]));
        System.out.println(point.getX()); // Вывод результатов выполнения метода
    }
    public Point2d (double x, double y) //Конструктор инициализации
    {
        CrdX = x; // Присвоение переменной значения x
        CrdY = y; // Присвоение переменной значения y
    }
    public Point2d () //Конструктор по умолчанию
    {

        this(0, 0); // Конструктор с двумя параметрами и определение источника.
    }
    public double getX ()
    {
        return CrdX; //Возвращение координаты X
    }
    public double getY ()
    {
        return CrdY; //Возвращение координаты Y
    }
    public void setX (double value)
    {
        CrdX = value; //Присвоение значения координаты X
    }
    public void setY (double value)
    {
        CrdY = value; //Присвоение значения координаты Y
    }
}
