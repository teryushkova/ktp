package com.company;
import java.util.*;

public class task5 {
/*1     Создайте функцию, которая возвращает true, если две строки имеют один и тот же
буквенный шаблон, и false в противном случае.*/
    public static boolean sameLetterPattern(String a, String b) {
        if (a.length() != b.length())
            return false;
        HashMap<Character, Character> match = new HashMap<>(); //2 символа
        //реализует интерфейс Map (что подразумевает хранение данных в виде пар ключ/значение). Ключи и значения могут быть любых типов, в том числе и null.
        for (int i = 0; i < a.length(); i++) {
            if (!match.containsKey(a.charAt(i))) //проверка того, отображается ли конкретный ключ в HashMap или нет
                //Hash_Map.containsKey ( элемент_ключа )
                match.put(a.charAt(i), b.charAt(i)); //вставка сопоставления в карту
            if (b.charAt(i) != match.get(a.charAt(i))) //если не = возврату значения, которому сопоставлен указанный ключ
                return false;
        }
        return true;
    }

/*2     Паутина определяется кольцами, пронумерованными от 0 до 4 от центра, и
радиалами, помеченными по часовой стрелке сверху как A-H.
Создайте функцию, которая принимает координаты паука и мухи и возвращает
кратчайший путь для паука, чтобы добраться до мухи.*/
     public static String spiderVsFly(String spider, String fly) {
	    /*

	       1. спуститься в центр и пойти по нужной ветке
	          это просто сумма номеров колец мухи и паука

	       2. спуститься/подняться до нужного кольца и пойти по кольцу
	          разница между кольцами паука и мухи + (разница между веток) * длина пути на кольце

	          длина пути на кольце = 2 * x * sin(45 / 2) = x * 0.76536686473
	    */

        int sx = spider.charAt(0) - 65; //перемещение символа?
        int sy = spider.charAt(1) - 48;
        int fx = fly.charAt(0) - 65;
        int fy = fly.charAt(1) - 48;

        double strategyDist1 = sy + fy; //через центр
        double strategyDist2 = Math.abs(sy - fy) + ((sx + fx) % 8) * fy * 0.76536686473;
        //спуститься до нужного кольца + (длина по кольцу * кол-во колец)

        String path = "";

        if (strategyDist1 <= strategyDist2) {
            for (int i = 0; i < sy; i++) {
                path += spider.charAt(0); //то же, что a = a + b
                path += sy - i;
                path += '-'; //при переходе на другую ветку, изменение у
            }
            path += "A0-"; //до центра
            for (int i = 0; i < fy; i++) {
                path += fly.charAt(0);
                path += i + 1;
                path += '-'; //1ая стратегия выполнена
            }
        } else {
            for (int i = 0; i < Math.abs(sy - fy); i++) {
                path += spider.charAt(0);
                if (sy > fy) path += sy - i; //смещение на один и тот же уровень
                else path += sy + i;
                path += '-';
            }
            for (int i = 0; i <= (sx + fx) % 8; i++) {
                path += (char)(65 + (sx + i) % 8); //движение по кольцу
                path += fly.charAt(1);
                path += '-';
            }
        }

        return path.substring(0, path.length() - 1);
        //возвращает новую общую строку, в ней 1й и крайний символы с заданными индексами
    }

/*3     Создайте функцию, которая будет рекурсивно подсчитывать количество цифр
числа. Преобразование числа в строку не допускается, поэтому подход является
рекурсивным.*/
    public static int _digitsCount(long number) { //рекурсивная - функция, которая вызывает саму себя
        if (number == 0) return 0;
        return 1 + _digitsCount(number / 10); //1 + 0
    }
    public static int digitsCount(long number)
    {
        return 1 + _digitsCount(number / 10); //1 + (кол-во знаков не включая крайний)
    }

/*4     Создайте функцию, которая принимает в массив уже угаданных слов расшифрованное 6-
буквенное слово и возвращает общее количество очков, набранных игроком в
определенном раунде, используя следующую рубрику:
3-буквенные слова-это 1 очко
4-буквенные слова-это 2 очка
5-буквенные слова-это 3 очка
6-буквенные слова-это 4 очка + 50 пт бонуса (за расшифровку слова)
Помните, что недопустимые слова (слова, которые не могут быть сформированы из 6-
буквенных расшифрованных слов) считаются 0 очками.*/
    public static int[] getCharset(String word) {
        int[] charset = new int[127]; //набор символов, 7-битовая кодировка?
        for (char c : word.toCharArray()) charset[c]++;
        //Копирует знаки данного экземпляра в массив знаков Юникода.
        return charset;
    }

    public static int totalPoints(String[] words, String scramble) {
        int points = 0;
        int[] scrambleCharset = getCharset(scramble); // расшифровка результирующего набора символов?
        for (int i = 0; i < words.length; i++) {
            int[] wordCharset = getCharset(words[i]);
            boolean good = true;
            for (int j = 0; j < 127; j++)
                if (wordCharset[j] > scrambleCharset[j]) {
                    good = false;
                    break;
                }
            if (good) {
                points += words[i].length() - 2;
                if (words[i].length() == 6) points += 50;
            }
        }
        return points;
    }

/*5     Последовательный прогон-это список соседних последовательных целых чисел.
Этот список может быть как увеличивающимся, так и уменьшающимся. Создайте
функцию, которая принимает массив чисел и возвращает длину самого длинного
последовательного запуска.*/
    public static int longestRun(int[] arr) {
        int max = 1;
        int c = 1;
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i+1] - arr[i] == 1 || arr[i+1] - arr[i] == -1) {
                c++;
                if (max < c) max = c;
            } else
                c = 1;
        return max;
    }

/*6     Какой процент вы можете набрать на тесте, который в одиночку снижает средний
балл по классу на 5%? Учитывая массив оценок ваших одноклассников, создайте
функцию, которая возвращает ответ. Округлите до ближайшего процента.*/
    public static String takeDownAverage(String[] percents) {
        int avg = 0;
        for (String s : percents)
            avg += Integer.parseInt(s.substring(0, s.length() - 1));
        //строка в число; получение символов из строки
        return (avg / percents.length - percents.length*5 - 5) + "%";
        //% класса / кол-во - кол-во*5 - 5
    }

/*7     Учитывая предложение с числами, представляющими расположение слова,
встроенного в каждое слово, верните отсортированное предложение.*/
    public static String rearrange(String str) {
        String[] words = str.split(" ");
        String[] res = new String[words.length];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (Character.isDigit(word.charAt(i))) {
                    //определяет, является ли указанное значение типа char цифрой
                    res[word.charAt(i) - 48 - 1] = word.substring(0, i) + word.substring(i + 1);//?????
                    break;
                }
            }
        }
        return String.join(" ", res); //приостанавливает выполнение
    }

/*8     Напишите функцию, которая делает первое число как можно больше, меняя его
цифры на цифры во втором числе.*/
        public static Integer[] splitNumber(int n) {
            ArrayList<Integer> res = new ArrayList<>(); //список массивов
            while (n > 0) {
                res.add(n % 10); //добавляет цифры числа по отдельности
                n /= 10;
            }
            return res.toArray(new Integer[res.size()]); //генерирует массив цифр
        }
        public static int maxPossible(int n, int r) {
            Integer[] num = splitNumber(n); //части числа
            Integer[] rnum = splitNumber(r);
            Arrays.sort(rnum, Collections.reverseOrder()); //сортирует по возрастанию, меняя изначальный порядок
            int rnumindex = 0;
            for (int i = num.length - 1; i >= 0; i--) {
                if (num[i] < rnum[rnumindex]) {
                    num[i] = rnum[rnumindex];
                    rnumindex++;
                }
                if (rnumindex == rnum.length)
                    break;
            }
            n = 0;
            int dec = 1;
            for (int i : num) {
                n += i * dec;
                dec *= 10;
            }
            return n;
        }
//9
/*10        Напишите функцию, которая принимает неотрицательное целое число и возвращает true,
если целое число является новым числом, и false, если это не так.*/
    public static boolean isNew(int n) {
        Integer[] num = splitNumber(n); //8 задача
        for (int i = 0; i < num.length - 1; i++)
            if (num[i] > 0 && num[i] < num[num.length - 1])
                return false;
        return true;
    }

    }



