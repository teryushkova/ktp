import java.util.Arrays;

public class zadachi {
    public static String[][] millionsRounding(String[][] arr){
        double round;
        for (int i = 0; i < arr.length; i++){
            round = Math.round(Integer.parseInt(arr[i][1])/Math.pow(10,6))*Math.pow(10,6);
            arr[i][1]=Double.toString(round);
        }
        return (arr);
    }
    public static double[] otherSides(double side) {
        double otherSides[] = new double[2];
        otherSides[0] = side * 2;
        otherSides[1] = Math.sqrt(otherSides[0] * otherSides[0] - side * side);
        return otherSides;
    }
    public static String rps(String player1, String player2) {
        if (player1 == player2) return "TIE";
        else if (player1 == "rock" && player2 == "scissors" || player1 == "scissors" && player2 == "paper" || player1 == "paper" && player2 == "rock") {
            return "Player 1 wins";
        }
        return "Player 2 wins";
    }
    public static int warOfNumbers(int[] arr) {
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) sumEven += arr[i];
            else sumOdd += arr[i];
        }
        return Math.abs(sumEven - sumOdd);
    }
    public static String reverseCase(String string) {
        String newString = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') newString += ' ';
            else if ((int)string.charAt(i) < 97) {
                newString += (char)((int)string.charAt(i) + 32);
            }
            else {
                newString += (char)((int)string.charAt(i) - 32);
            }
        }
        return newString;
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
        double multi = fuelKm * (1 + 5 * (double)count / 100);
        if (kond) {
            multi = multi * 1.1;
        }
        return fuel / multi * 100;
    }
    public static double mean(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double)sum / arr.length;
    }
    public static boolean parityAnalysis(int number) {
        int sum = 0;
        for (int i = 1; number / i > 0; i *= 10) {
            sum += (number / i % 10);
        }
        if (sum % 2 == number % 2) return true;
        return false;
    }

    public static void main(String[] args){
        String[][] str = {{"Nice", "942208"}, {"Abu Dhabi", "1482816"}, {"Naples", "2186853"}, {"Vatican City", "572"}};
        System.out.println("millionsRounding(" + Arrays.deepToString(str)+ ") —> " + Arrays.deepToString(millionsRounding(str)) + "\n");

        System.out.println("otherSides(1) —> " + Arrays.toString(otherSides(1)));
        System.out.println("otherSides(1) —> " + Arrays.toString(otherSides(12)));
        System.out.println("otherSides(1) —> " + Arrays.toString(otherSides(2)));
        System.out.println("otherSides(1) —> " + Arrays.toString(otherSides(3)) + "\n");

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
