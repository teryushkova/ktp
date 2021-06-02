public class Point3d extends Point2d {
    private double CrdZ; // Объявление локальной переменной, координата Z
    Point3d(double x, double y, double z) // Конструктор инициализации
    {
        super(x, y);
        CrdZ = z; // Присвоение переменной значения z
    }
    Point3d() //конструктор по умочанию
    {
        this(0.0, 0.0, 0.0); // Конструктор с тремя параметрами и определение источника.
    }
    public double getZ()
    {
        return CrdZ; // Возвращение координаты Z
    }
    public boolean comparison(Point3d o) // Метод для сравнения двух объектов
    {
        return ((this.getX() == o.getX()) && (this.getY() == o.getY()) && (this.CrdZ == o.CrdZ)) ? true : false;
    }
    public double distanceTo(Point3d o)
    {
// Вычисление расстояния между точками
        return Math.ceil(Math.sqrt(Math.pow((o.getX()-this.getX()), 2)+Math.pow((o.getY()-this.getY()), 2)+Math.pow((o.CrdZ-this.CrdZ), 2))*100)/100;
    }
    public void setZ(double value)
    {
        this.CrdZ = value;
    }
}

