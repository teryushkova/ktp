package com.company;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Main {
    public static String[][] millionsRounding(String[]... a)
    {   //массив городов и населения,
        for(int i=0; i<a.length; i++)
        {
            BigDecimal r=new BigDecimal(a[i][1]);
            r=r.divide(new BigDecimal("1000000"))   //devide - деление на миллион
                    .setScale(0, RoundingMode.HALF_UP);   //roundingmode - округление
            a[i][1]=r.toString()+"000000";    //half up округление в большую сторону, если цифра 5
        }   //округлено до ближайшего миллиона
        return a;
    }

        public static double[] otherSides(double side) {
            double otherSides[] = new double[2];
            otherSides[0] = side * 2; // гипотенуза
            otherSides[1] = Math.sqrt(otherSides[0] * otherSides[0] - side * side);
            return otherSides;
        }
        public static String rps(String player1, String player2) {//камень, ножницы, бумага
            if (player1 == player2) return "TIE";
            else if (player1 == "К" && player2 == "Н" || player1 == "Н" && player2 == "Б" || player1 == "Б" && player2 == "К") {
                return "Player 1 wins";
            }
            return "Player 2 wins";
        }
        public static int warOfNumbers(int[] arr) {
            int sumEven = 0; //четные
            int sumOdd = 0; //нечетные
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) sumEven += arr[i]; //суммирует четные и нечетные числа отдельно
                else sumOdd += arr[i];
            }   // возвращает разницу между суммой четных и нечетных чисел
            return Math.abs(sumEven - sumOdd);
        }
    public static String reverseCase(String str){
        char[] chars = str.toCharArray(); // Преобразование в символьный массив
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if (Character.isUpperCase(c)) // Если символ в нижнем регистре то переводим его в верхний и наоборот
                chars[i] = Character.toLowerCase(c);
            else if (Character.isLowerCase(c))
                chars[i] = Character.toUpperCase(c);
        }
        return new String(chars);
    }
        public static String inatorInator(String string) {
            char last = string.charAt(string.length() - 1);
            if (last == 'O' || last == 'o' || last == 'e' || last == 'E' || last == 'i' || last == 'I'
                    || last == 'a' || last == 'A' || last == 'u' || last == 'U' || last == 'Y' || last == 'y') {
                string += "-inator" + " " + string.length() + "000";
            }
            else {
                string += "inator" + " " + string.length() + "000";
            }
            return string;
        }
        public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
            if (a <= w && b <= h || b <= w && a <= h || a <= w && c <= h || c <= w && a <= w || b <= w && c <= h || c <= w && b <= h) {
                return true;
            }
            return false;
        }
        public static double totalDistance(double fuel, double fuelKm, int count, boolean kond) {
            double multi = fuelKm * (1 + 5 * (double)count / 100); //расход*(5%*число пассажиров/10км+водитель)
            if (kond) {
                multi = multi * 1.1;
            }
            return fuel / multi * 100;
        }
        public static double mean(int[] arr) {
            int sum = 0;//принимает массив чисел
            for (int i = 0; i < arr.length; i++) { //находит сумму чисел
                sum += arr[i];
            }
            return (double)sum / arr.length; // делит на длинну массива
        }
        public static boolean parityAnalysis(int number) {
        // принимает число
            int sum = 0;
            for (int i = 1; number / i > 0; i *= 10) { // разделяет число на цифры
                sum += (number / i % 10);  // складывает цифры
            }
            if (sum % 2 == number % 2) return true;//сумма его цифр имеет ту же четность
            return false;
        }

        public static void main(String[] args){
            System.out.println("Париж, 2148327 —> " +Arrays.deepToString(millionsRounding(new String[] {"Париж", "2148327"})));
            System.out.println("Лондон, 8908081 —> " +Arrays.deepToString(millionsRounding(new String[] {"Лондон", "8908081"}))+ "\n");

            System.out.println("otherSides(1) —> " + Arrays.toString(otherSides(1)));
            System.out.println("otherSides(12) —> " + Arrays.toString(otherSides(12)));
            System.out.println("otherSides(2) —> " + Arrays.toString(otherSides(2)));
            System.out.println("otherSides(3) —> " + Arrays.toString(otherSides(3)) + "\n");

            System.out.println("rps('К', 'Б') —> " + rps("К", "Б"));
            System.out.println("rps('Б', 'К') —> " + rps("Б", "К"));
            System.out.println("rps('Б', 'Н') —> " + rps("Б", "Н"));
            System.out.println("rps('Н', 'Б') —> " + rps("Н", "Б"));
            System.out.println("rps('К', 'К') —> " + rps("К", "К") + "\n");

            int[] arr = {12, 90, 75};
            System.out.println("warOfNumbers([12, 90, 75]) —> " + warOfNumbers(arr));
            int[] arr1 = {5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243};
            System.out.println("warOfNumbers([12, 90, 75]) —> " + warOfNumbers(arr1) + "\n");

            System.out.println("reverseCase(Apple) —> " + reverseCase("Apple"));
            System.out.println("reverseCase(abc) —> " + reverseCase("abc"));
            System.out.println("reverseCase(Happy Birthday) —> " + reverseCase("Happy Birthday") + "\n");

            System.out.println("inatorInator(Shrink) —> " + inatorInator("Shrink"));
            System.out.println("inatorInator(Doom) —> " + inatorInator("Doom"));
            System.out.println("inatorInator(EvilClone) —> " + inatorInator("EvilClone") + "\n");

            System.out.println("doesBrickFit(1, 1, 1, 1, 1) —> " + doesBrickFit(1, 1, 1, 1 ,1));
            System.out.println("doesBrickFit(1, 2, 1, 1, 1) —> " + doesBrickFit(1, 2, 1, 1 ,1));
            System.out.println("doesBrickFit(1, 2, 2, 1, 1) —> " + doesBrickFit(1, 2, 2, 1 ,1) + "\n");

            System.out.println("totalDistance(70.0, 7.0, 0, false) —> " + totalDistance(70.0, 7.0, 0, false));
            System.out.println("totalDistance(36.1, 8.6, 3, true) —> " + totalDistance(36.1, 8.6, 3, true));
            System.out.println("totalDistance(55.5, 5.5, 5, false) —> " + totalDistance(55.5, 5.5, 5, false) + "\n");

            int[] ar = {1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3};
            System.out.println("mean([1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3]) —> " + mean(ar));
            int[] ar1 = {2, 3, 2, 3};
            System.out.println("mean([2, 3, 2, 3]) —> " + mean(ar1));
            int[] ar2 = {3, 3, 3, 3, 3};
            System.out.println("mean([3, 3, 3, 3, 3]) —> " + mean(ar2) + "\n");

            System.out.println("parityAnalysis(243) —> " + parityAnalysis(243));
            System.out.println("parityAnalysis(12) —> " + parityAnalysis(12));
            System.out.println("parityAnalysis(3) —> " + parityAnalysis(3));
        }
    }


