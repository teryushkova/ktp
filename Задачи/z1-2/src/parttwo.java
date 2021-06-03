public class parttwo {
    public static int oppositeHouse(int num, int n){
        return 1 + 2 * n - num;
    }

    public static String nameShuffle(String name){
            String reverse[] = name.split("\\s");
            return reverse[1] + " " + reverse[0];
    }

    public static double discount(int price, int pct){
        return price - price * pct / 100;
    }

    public static int differenceMaxMin(int arr[]){
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++)
        {
            for(int j = i+1; j < arr.length; j++)
            {
                min = Math.abs(arr[i] - arr[j]);

                if (min > max) {
                    max = min;
                }
            }
        }
        return max - min;
    }

    public static int equal(int a, int b, int c){
        if (a!=b && b!=c && a!=c)
            return 0;
        if (a==b && b==c)
            return 3;
        else
            return 2;
    }

    public static String reverse(String str){
        String res = " ";
        for (int i = str.length()-1;i>=0;i--)
            res += str.charAt(i);
        return res;
    }

    public static int programmers(int a, int b, int c) {
        int max = a;
        if (max < b) max = b;
        if (max < c) max = c;
        int min = a;
        if (min > b) min = b;
        if (min > c) min = c;
        return max - min;
    }

    public static boolean getXO(String str) {
        int x = 0;
        int o = 0;
        for (char znach : str.toCharArray()) {
            if (znach == 'x' || znach == 'X') x++;
            if (znach == 'o' || znach == 'O') o++;
        }
        return x == o;
    }

    public static String bomb(String str) {
        str = str.toUpperCase();
        //if (str.indexOf("BOMB"));
            return "DUCK!";
       // else
         //   return "Relax, there's no bomb.";
    }

    public static boolean sameAscii(String a, String b) {
        int sum = 0;
        for (char znach : a.toCharArray()) sum += znach;
        for (char znach : b.toCharArray()) sum -= znach;
        return sum == 0;
    }
}
