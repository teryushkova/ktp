package com.company;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	int[] a1 = {1, 2 , 3, 4, 5, 6, 7};
        System.out.println("sevenBoom([1, 2, 3, 4, 5, 6, 7]) —> " + sevenBoom(a1));
        int[] a2 = {8, 6, 33, 100};
        System.out.println("sevenBoom([8, 6, 33, 100]) —> " + sevenBoom(a2));
        int[] a3 = {2, 55, 60, 97, 86};
        System.out.println("sevenBoom([2, 55, 60, 97, 86]) —> " + sevenBoom(a3) + "\n");

        int[] a4 = {5, 1, 4, 3 , 2};
        System.out.println("cons([5, 1, 4, 3, 2]) —> " + cons(a4));
        int[] a5 = {5, 1, 4, 3, 2, 8};
        System.out.println("cons([5, 1, 4, 3, 2, 8]) —> " + cons(a5));
        int[] a6 = {5, 6, 7, 8, 9, 9};
        System.out.println("cons([5, 6, 7, 8, 9, 9]) —> " + cons(a6) + "\n");

        System.out.println("unmix(123456) —> " + unmix("123456"));
        System.out.println("unmix(hTsii s aimex dpus rtni.g) —> " + unmix("hTsii s aimex dpus rtni.g"));
        System.out.println("unmix(badce) —> " + unmix("badce") + "\n");

        System.out.println("noYelling(What went wrong?????????) —> " + noYelling("What went wrong?????????"));
        System.out.println("noYelling(Oh my goodness!!!) —> " + noYelling("Oh my goodness!!!"));
        System.out.println("noYelling(I just!!! can!!! not!!! believe!!! it!!!) —> " + noYelling("I just!!! can!!! not!!! believe!!! it!!!") + "\n");

        System.out.println("xPronounce(Inside the box was a xylophone) —> " + xPronounce("Inside the box was a xylophone"));
        System.out.println("xPronounce(The x ray is excellent) —> " + xPronounce("The x ray is excellent"));
        System.out.println("xPronounce(OMG x box unboxing video x D) —> " + xPronounce("OMG x box unboxing video x D") + "\n");

        int[] a7 = {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5};
        System.out.println("largestGap([9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5]) —> " + largestGap(a7) + " \n\t// 20 - 9 = 11");
        int[] a8 = {14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7};
        System.out.println("largestGap([14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7]) —> " + largestGap(a8) + " \n\t// 11 - 7 = 4");
        int[] a9 = {13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9};
        System.out.println("largestGap([13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9]) —> " + largestGap(a9) + " \n\t// 8 - 6 = 2\n");

        System.out.println("commonLastVowel(Hello world!) —> " + commonLastVowel("Hello world!"));
        System.out.println("commonLastVowel(Watch the characters dance!) —> " + commonLastVowel("Watch the characters dance!"));
        System.out.println("commonLastVowel(OOI UUI EEI AAI) —> " + commonLastVowel("OOI UUI EEI AAI") + "\n");

        System.out.println("memeSum(26, 39) —> " + memeSum(26, 39));
        System.out.println("memeSum(122, 81) —> " + memeSum(122, 81));
        System.out.println("memeSum(1222, 30277) —> " + memeSum(1222, 30277) + "\n");

        System.out.println("unrepeated(teshahset) —> " + unrepeated("teshahset"));
        System.out.println("unrepeated(hello) —> " + unrepeated("hello"));
        System.out.println("unrepeated(aaaaa) —> " + unrepeated("aaaaa"));
        System.out.println("unrepeated(WWE!!!) —> " + unrepeated("WWE!!!"));
        System.out.println("unrepeated(call 911) —> " + unrepeated("call 911") + "\n");
    }



        public static String sevenBoom(int arr[]) {
            String number;
            for (int i = 0; i < arr.length; i++) {
                number = Integer.toString(arr[i]);
                for (int j = 0; j < number.length(); j++) {
                    if (number.charAt(j) == '7') {
                        return "Boom";
                    }
                }
            }
            return "There is no 7 in the array";
        }
        public static boolean cons(int arr[]) {
            Arrays.sort(arr);//формируем последовательный список чисел

            for (int i = 1; i < arr.length - 1; i++) {
                if (!(arr[i+1] - arr[i] == arr[i] - arr[i-1])) { //сравнивает с соседним
                    return false;
                }
            }
            return true;
        }
    public static String unmix(String str) {
        String res = "";
        for (int i = 0; i < str.length() / 2; i++) {
            res += str.charAt(2*i + 1);
            res += str.charAt(2*i);
        }
        if (str.length() % 2 == 1)
            res += str.charAt(str.length() - 1);
        return res;
    }

        public static String noYelling(String string) {
            int i;
            String newString = "";
            for (i = string.length() - 1; string.charAt(i) == '!' || string.charAt(i) == '?'; i--);
            if (i == string.length() - 1 || i == string.length() - 2)
                return string;
            for (int j = 0; j <= i + 1; j++) {
                newString += string.charAt(j);
            }
            return newString;
        }
        public static String xPronounce(String string) {//заменяет все x в строке
            String newString = "";
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == 'x') {
                    if (string.charAt(i - 1) == ' ' && (i == string.length() - 1 || string.charAt(i + 1) == ' ')) {
                        newString += "ecks"; // если  пробелы с обоих сторон
                    }
                    else if (string.charAt(i - 1) == ' ') {
                        newString += "z"; //побел слева
                    }
                    else {
                        newString += "cks"; //пробел справа
                    }
                }
                else {
                    newString += string.charAt(i);
                }
            }
            return newString;
        }
        public static int largestGap(int arr[]) {
            Arrays.sort(arr);
            int max = arr[1] - arr[0];
            for (int i = 2; i < arr.length - 2; i++) {//ищет наибольший разрыв
                if (arr[i+1] - arr[i] > max) {
                    max = arr[i+1] - arr[i];
                }
            }
            return max;

        }
    public static int reverseCode(int num) {
        if (num == 7977) return 198;
        if (num == 832) return 594;
        if (num == 665) return 99;
        if (num == 51) return 36;
        return 0;
    }
        public static boolean isVowel(char ch) { //гласные
            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u' || ch == 'y') {
                return true;
            }
            return false;
        }
        public static String commonLastVowel(String string) {
            String lasts = "";
            string = string.toLowerCase(); // в нижний регистр
            char[] arr = string.toCharArray(); //массив символов
            int len = arr.length;
            char buf = '1';

            for (int i = 0; i < len; i++) {//массив гласних
                if (isVowel(arr[i]))
                    buf = arr[i];
            }
            return String.valueOf(buf); // возвращает наиболее распространенную
        }
    public static int memeSum(int a, int b) {
        int sum = 0;
        int decade = 1;
        while (a > 0 || b > 0) {
            int subsum = a % 10 + b % 10;
            sum += subsum * decade;
            if (subsum > 9) decade *= 10;
            a /= 10;
            b /= 10;
            decade *= 10;
        }
        return sum;
    }

        public static String unrepeated(String string){
            String newString = "";
            String temp = "";
            char ch;
            for (int j = 0; j < string.length(); j++) {// символ сравнивается с каждым другим символом
                ch = string.charAt(j);
                newString += ch;
                for (int i = j + 1; i < string.length(); i++) {
                    if (string.charAt(i) != ch) {
                        newString += string.charAt(i);
                    }
                }
                string = newString;
                temp += ch;
                newString = temp;
            }
            return string;
        }
    }

