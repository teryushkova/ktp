import java.util.Scanner; // сылка на класс Сканер

public class Palindrome
{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);// Создается новый объект класса Scanner и сохраняется его в переменной.
                                              // Вызывается конструктор класса с параметром System.in.
                                              // Считывание идет с потока программы
        String s=scan.next(); // Считывает

        isPalindrome(s);
    }
    public static String reverseString(String s){
        String r = "";
        for (int i = s.length() - 1; i >= 0; --i)
            r += s.charAt(i);
        return r;

    }
    public static Boolean isPalindrome(String s) {

        if(s.equals(reverseString(s))){ // Проверка значения равенства слова и его обратной версии
            System.out.println("Слово является палиндромом");
        }else{
            System.out.println("Слово не является палиндромом");
        }
        return s.equals(reverseString(s));

    }
}
