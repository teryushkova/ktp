package com.company;

import java.util.*;


public class task6 {

/*1     Создайте функцию, которая принимает две строки. Первая строка содержит
предложение, содержащее буквы второй строки в последовательной
последовательности, но в другом порядке. Скрытая анаграмма должна содержать
все буквы, включая дубликаты, из второй строки в любом порядке и не должна
содержать никаких других букв алфавита.
Напишите функцию, чтобы найти анаграмму второй строки, вложенную где-то в
первую строку. Вы должны игнорировать регистр символов, любые пробелы и
знаки препинания и возвращать анаграмму в виде строчной строки без пробелов
или знаков препинания.*/
    public static int[] getLetterSet(String str) {
        int[] set = new int[26]; //кол-во букв в алфавите
        for (char c : str.toCharArray())
            set[c - 97]++; //97=a
        return set;
    }
    public static String onlyLetters(String str) {
        str = str.toLowerCase(); //строчная буква
        String res = "";
        for (char c : str.toCharArray())
            if (97 <= c && c <= 122) //юникод для алфавита
                res += c;
        return res;
    }
    public static String hiddenAnagram(String a, String b) {
        a = onlyLetters(a);
        b = onlyLetters(b);
        int[] setB = getLetterSet(b);
        for (int i = 0; i <= a.length() - b.length(); i++) {
            String substr = a.substring(i, i+b.length()); //символы из строки
            int[] setA = getLetterSet(substr);
            if (Arrays.equals(setA, setB)) {
                String res = "";
                for (char c : substr.toCharArray())
                    if (97 <= c && c <= 122)
                        res += c;
                return res;
            }
        }
        return "notfound";
    }

/*2     Напишите функцию, которая возвращает массив строк, заполненных из срезов
символов n-длины данного слова (срез за другим, в то время как n-длина
применяется к слову).*/
    public static String[] collect(String s, int n) {
        if (s.length() < n)
            return new String[] {};
        String[] res = collect(s.substring(n), n);
        String head = s.substring(0, n);
        String[] newRes = new String[res.length+1];
        int index = 0;
        while (index < res.length && res[index].compareTo(head) < 0)
            //сравнивает вызывающий объект с объектом, переданным в качестве параметра, и возвращает число
            index++;
        System.arraycopy(res, 0, newRes, 0, index);
        //осуществляет копирование части массива в другой массив
        System.arraycopy(res, index, newRes, index+1, res.length - index);
        newRes[index] = head;
        return newRes;
    }

/*3     В шифре Nico кодирование осуществляется путем создания цифрового ключа и
присвоения каждой буквенной позиции сообщения с помощью предоставленного
ключа.
Создайте функцию, которая принимает два аргумента, message и key, и возвращает
закодированное сообщение.*/
    public static int[] getCharset(String word) {
        int[] charset = new int[127]; //набор символов, 7-битовая кодировка?
        for (char c : word.toCharArray()) charset[c]++;
        return charset;
    }
    public static String nicoCipher(String message, String key) {
        for (int i = 0; i < (message.length()+key.length()) % key.length(); i++)
            message += ' ';
        int[] set = getCharset(key);
        int[] setCount = set.clone();
        int counter = 1;
        for (int i = 0; i < set.length; i++)
            if (set[i] != 0) {
                if (set[i] > 1)
                    counter += set[i] - 1;
                set[i] = counter++;
            }
        int[] offsets = new int[key.length()];
        for (int i = 0; i < key.length(); i++)
            offsets[set[key.charAt(i)]-setCount[key.charAt(i)]--] = i;
        String res = "";
        for (int i = 0; i < message.length(); i++) {
            int index = (i / offsets.length) * offsets.length + offsets[i % offsets.length];
            res += message.charAt(index);
        }
        return res;
    }

 /*4        Создайте метод, который принимает массив arr и число n и возвращает массив из
двух целых чисел из arr, произведение которых равно числу n следующего вида:
[value_at_lower_index, value_at_higher_index]
Массив может иметь несколько решений (произведений n), поэтому возвращайте первое
найденное полное совпадение */
    public static int[] twoProduct(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        //HashSet представляет хеш-таблицу, реализует интерфейс Set
        //хеш-таблица - все объекты имеют уникальный ключ или хеш-код.
        //HashSet(): создает пустой список
        //интерфейс Set не может содержать повторяющиеся элементы.
        //interface используется для создания полностью абстрактных классов.
        //Создатель интерфейса определяет имена методов, списки аргументов и типы возвращаемых значений, но не тела методов.
        for (int m : arr) {
            if (n % m == 0 && set.contains(n / m))
                //метод проверки, содержит ли String указанную последовательность символов
                return new int[] {n/m, m};
            set.add(m); //используется для добавления определенного элемента в коллекцию Set.
        }
        return new int[] {};
    }

/*5     Создайте рекурсивную функцию, которая проверяет, является ли число точной
верхней границей факториала n. Если это так, верните массив точной
факториальной границы и n, или иначе, пустой массив.*/
    //на вход подаётся результат, на выход (число!), если оно есть
    public static int[] isExact(int f, int m, int n) {
        if (f < n)
            return isExact(f*(m+1), m+1, n);
        return new int[] {f, m};
    }

    public static int[] isExact(int n) {
        int[] res = isExact(1, 1, n);
        if (res[0] == n) return res;
        return new int[] {};
    }

/*6     Создайте функцию, которая принимает десятичную дробь в строковой форме с
повторяющейся частью в круглых скобках и возвращает эквивалентную дробь в
строковой форме и в наименьших членах.*/
    public static String fractions(String frac) {
        int startBracket = frac.indexOf('('); //поиск символа в строке
        if (startBracket != -1) {
            String f = frac.substring(startBracket+1, frac.length()-1);
            frac = frac.substring(0, startBracket);
            for (int i = 0; i < 9 - f.length(); i++)
                frac += f;
        }
        double a = Double.parseDouble(frac); //возвращает значение double
        int div = 2;
        while (Math.ceil(a * div) - a * div > 0.000001) div++; //округление в > сторону
        return "" + (int)Math.ceil(a * div) + "/" + div;
    }

/*7     В этой задаче преобразуйте строку в серию слов (или последовательности
символов), разделенных одним пробелом, причем каждое слово имеет одинаковую
длину, заданную первыми 15 цифрами десятичного представления числа Пи:*/
    public static String pilish_string(String str) {
        String res = "";
        String pi = String.valueOf(Math.PI).replace(".", "");
        // преобразует в нужный тип данных, заменяет . на ""
        int piIndex = 0;
        while (str.length() > 0) {
            int p = pi.charAt(piIndex) - 48;
            int n = Math.min(p, str.length()); //наименьшее из 2х
            res += str.substring(0, n);
            str = str.substring(n);
            piIndex++;
            if (str.length() > 0) res += ' ';
            else if (p > n)
                for (int i = 0; i < p - n; i++)
                    res += res.charAt(res.length() - 1);
        }
        return res;
    }

/*8     Создайте функцию для генерации всех непоследовательных двоичных строк, где
непоследовательные определяется как строка, в которой нет последовательных
строк, и где n определяет длину каждой двоичной строки.
Если n=4 - длина каждой части 4 символа
0 через 1 символ, прерывается при 1010*/
    public static String generateNonconsecutive(int n) {
        String res = "";
        String format = "%" + n + 's'; //строка символов?
        int count = 2 << (n-1); //побитовый оператор сдвига влево
        nextNumber:
        for (int i = 0; i < count; i++) {
            String num = String.format(format, Integer.toBinaryString(i)).replace(' ', '0');
            for (int j = 0; j < n - 1; j++)
                if (num.charAt(j) == '1' && num.charAt(j+1) == '1')
                    continue nextNumber;
            res += num + ' ';
        }
        return res.substring(0, res.length() - 1);
    }

 /*9        Шерлок считает строку действительной, если все символы строки встречаются
одинаковое количество раз. Также допустимо, если он может удалить только 1
символ из 1 индекса в строке, а остальные символы будут встречаться одинаковое
количество раз. Для данной строки str определите, действительна ли она. Если да,
верните «ДА», в противном случае верните «НЕТ».*/
    public static String isValid(String str) {
        int[] set = getLetterSet(str); //1 задача
        int[] medium = new int[str.length()];
        for (int i = 0; i < set.length; i++)
            if (set[i] != 0) medium[set[i]]++;
        int cur = 0;
        int max = 0;
        for (int i = 0; i < medium.length; i++)
            if (medium[i] > cur) {
                cur = medium[i];
                max = i;
            }
        boolean index = false;
        for (int i = 0; i < set.length; i++)
            if (set[i] != 0 && max - set[i] != 0) {
                if (index) return "NO";
                index = true;
            }
        return "YES";
    }

/*10        Создайте функцию, которая получает каждую пару чисел из массива, который
суммирует до восьми, и возвращает его как массив пар (отсортированный по
возрастанию). */
    public static int[][] sumsUp(int[] arr) {
        ArrayList<int[]> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(8 - arr[i])) {
                int a = arr[i];
                int b = 8 - a;
                if (a > b) {
                    b = a;
                    a = 8 - b;
                }
                res.add(new int[] {i - map.get(8-arr[i]), a, b});
            }
            map.put(arr[i], i);
        }
        Collections.sort(res, (o1, o2) -> o1[0]-o2[0]);
        int[][] newRes = new int[res.size()][];
        for (int i = 0; i < res.size(); i++)
            newRes[i] = new int[] {res.get(i)[1], res.get(i)[2]};
        return newRes;
    }

}
