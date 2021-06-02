
public class Primes
{
    public static void main(String[] args) // Нахождение простых чисел в пределах от 2 до 100
    {
        for (int i = 2; i <= 100; i++)
            if (isPrime(i))
                System.out.println(i + " - простое число.");
        System.out.println("");
    }
    public static boolean isPrime (int n) //Метод, проверяющий условие задачи
    {
        for (int i = 2; i < n; i++)
            if (n%i == 0) //операция остатка от деления n на значение i
                return false;
        return true;
    }
}