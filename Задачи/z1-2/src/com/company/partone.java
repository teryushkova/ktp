package com.company;

public class partone {

    public static  int convert(int min) {
        return min * 60;
    }

    public static int points(int twoPoint, int threePoint){
        return twoPoint*2+threePoint*3;
    }

    public static int footballPoints(int win, int draws, int lose){
        return win * 3 + draws;
    }

    public static boolean divisibleByFive(int chislo){
        return chislo % 5 == 0;
    }

    public static boolean howManyWalls(boolean a, boolean b){
        return a && b;
    }

    public static int howManyWalls(int n, int w, int h){
        return n/(w * h);
    }

    public static int squaed(int a) {
        return a * a;
    }

    public static boolean profitableGamble(int prob, int prize, int pay){
        return prob * prize > pay ;
    }

    public static int frames(int min, int fps){
        return (min * 60) * fps;
    }

    public static int mod(int m, int n){
        return m - (m  / n) * n;
    }
}
