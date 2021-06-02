
/**
 * Этот класс представляет определенное местоположение на
 * 2D-карте. Координаты-это целочисленные значения.
 **/
public class Location
{
    /** Координата X этого местоположения. **/
    public int xCoord;

    /** Координата У этого местоположения.**/
    public int yCoord;


    /** Создает новое местоположение с заданными целочисленными координатами. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Создает новое местоположение с координатами (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    /** Сравнивает это местоположение с другим. **/
    public boolean equals(Object obj) {

        // Является ли obj местоположением?
        if (obj instanceof Location) {

            // Приведем другой объект к типу местоположения,
            // а затем сравним. Возвращает true, если равно.
            Location other = (Location) obj;
            if (xCoord == other.xCoord && yCoord == other.yCoord) {
                return true;
            }
        }

        // Если мы добрались сюда, значит, они не равны. Верните false.
        return false;
    }

    /** Предоставляет хэш-код для каждого местоположения. **/
    public int hashCode() {
        int result = 17; // Некоторое первичное значение

        // Используем другое простое значение для объединения
        result = 37 * result + xCoord;
        result = 37 * result + yCoord;
        return result;
    }
}