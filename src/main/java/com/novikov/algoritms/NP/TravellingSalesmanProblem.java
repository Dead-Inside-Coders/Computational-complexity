package com.novikov.algoritms.NP;

public class TravellingSalesmanProblem {
    private int N; //число городов
    private int[] minWay = new int[N]; // лучший путь(массив номеров городов)
    private int minLen = Integer.MAX_VALUE; // лучшее расстояние
   // private int[][] dists = new int[N][N]; // матрица расстояний
    private static int[][] dists = new int[][] {
           {-1,20,42,35},
           {20,-1,30,34},
           {42,30,-1,12},
           {35,34,12,-1},
    };

    public void bruteForceTSP() {

    }

    private static void permutation(int[] array, int lf) {
        if(lf >= array.length){                           // перестановки окончены
            print(array,calculateDistance(array,dists));                 // выводим перестановку
            return;
        }

        permutation(array, lf+1);                                // перестановки элементов справа от lf
        for(int i=lf+1; i < array.length; i++){           // теперь каждый элемент ar[i], i > lf
            swap(array, lf, i);                            // меняем местами с ar[lf]
            permutation(array, lf+1 );                            // и снова переставляем всё справа
            swap(array, lf, i);                            // возвращаем элемент ar[i] назад
        }
    }

    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j]=temp;
    }

    private static void print(int[] array, int d) {
        for (int item : array) {
            System.out.print(item);
        }
        System.out.print(" dist = " + d);
        System.out.print('\n');
    }

    private static int calculateDistance(int[] array,int[][] dists)
    {
        int d = dists[0][array[0]] + dists[array[array.length-1]][0]; // начало и конец
        for(int i=1; i < array.length; i++)
            d += dists[array[i-1]][array[i]];                 // между ar[i-1] и ar[i]
        return d;                                      // длина пути перестановки ar
    }


    public static void main(String[] args) {
        int[] cities = new int[4];

        for (int i = 0; i < 4; i++) {
            cities[i] = i;
        }

        permutation(cities,1);

    }
}
