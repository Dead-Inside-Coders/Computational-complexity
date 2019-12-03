package com.novikov.algoritms.np;

public class TravellingSalesmanProblem
{
    private int N; //число городов
    private int[][] dists; // матрица расстояний
    private int[] cities;

    public TravellingSalesmanProblem(int[][] dists)
    {
        this.N = dists[0].length;
        cities = new int[N];
        this.dists = dists;
        for (int i = 0; i < cities.length; i++)
        {
            cities[i] = i;
        }
    }

    private void permutation( int lf) {
        if(lf >= cities.length)
        {                           // перестановки окончены
            print(calculateDistance(dists));                 // выводим перестановку
            return;
        }

        permutation( lf+1);                                // перестановки элементов справа от lf
        for(int i=lf+1; i < cities.length; i++){           // теперь каждый элемент ar[i], i > lf
            swap( lf, i);                            // меняем местами с ar[lf]
            permutation( lf+1 );                            // и снова переставляем всё справа
            swap(lf, i);                            // возвращаем элемент ar[i] назад
        }
    }

    private void swap( int i, int j)
    {
        int temp = cities[i];
        cities[i] = cities[j];
        cities[j] = temp;
    }

    private void print( int d) {
        for (int item : cities) {
            System.out.print(item);
        }
        System.out.print(" dist = " + d);
        System.out.print('\n');
    }

    private  int calculateDistance(int[][] dists)
    {
        int d = dists[0][cities[0]] + dists[cities[cities.length-1]][0]; // начало и конец
        for(int i=1; i < cities.length; i++)
            d += dists[cities[i-1]][cities[i]];                 // между ar[i-1] и ar[i]
        return d;                                      // длина пути перестановки ar
    }


    public static void main(String[] args) {
        int[][] dists = new int[][] {
                {0,20,42,35},
                {20,0,30,34},
                {42,30,0,12},
                {35,34,12,0},
        };
        TravellingSalesmanProblem travellingSalesmanProblem = new TravellingSalesmanProblem(dists);

        travellingSalesmanProblem.permutation(1);
        //permutation(cities,1);

    }
}
