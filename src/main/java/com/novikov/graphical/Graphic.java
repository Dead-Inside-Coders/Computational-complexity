package com.novikov.graphical;

import com.novikov.algoritms.np.TravellingSalesmanProblem;
import com.novikov.algoritms.p.*;

import java.util.Random;

public class Graphic
{
    public long[][] getGraphic(int elements, String complexity)
    {
        switch (complexity)
        {
            case "O(1) - Нахождение среднего элемента массива":
                return constantTime(elements);
            case "O(n) - Линейный поиск": 
                return linearTime(elements);
            case "O(n^2) - Сортировка пузырьком":
                return quadraticTime(elements);
            case "O(n^3) - Умножение матриц":
                return cubicTime(elements);
            case "O(Log n) - Бинарный поиск":
                return logarithmicTime(elements);
            case "O(n!) - Задача коммивояжера":
                return factorialTime(elements);
            default:
                return new long[0][0];
        }
    }

    private long[][] logarithmicTime(int elements)
    {
        long[][] array = new long[elements/10][2];
        BinarySearch binarySearch = new BinarySearch();
        for (int i = 0, n = 0; n < elements ; i++)
        {
           n = n+10;
           int[] tempArray = new BubbleSort(shuffleArray(n)).sort();
           long startTime = System.nanoTime();//System.currentTimeMillis();

           binarySearch.binarySearchIterational(tempArray,tempArray[0]);

           long elapsedTime  = System.nanoTime() - startTime;
           array[i][0] = n;
           array[i][1] = elapsedTime;
        }
        return array;
    }

    private long[][] quadraticTime(int elements)
    {
        long[][] array = new long[elements/10][2];

        for (int i = 0, n = 0; n < elements ; i++)
        {
            n = n+10;
            int[] tempArray = shuffleArray(n);
            long startTime = System.nanoTime();

            new BubbleSort(tempArray).sort();

            long elapsedTime  = System.nanoTime() - startTime;
            array[i][0] = n;
            array[i][1] = elapsedTime;
        }
        return array;
    }

    private long[][] constantTime(int elements)
    {
        long[][] array = new long[elements/10][2];
        for (int i = 0, n = 0; n < elements ; i++)
        {
            n = n + 10;
            int[] tempArray = shuffleArray(n);
            long startTime = System.nanoTime();

            new ConstTime(tempArray).getMidElement();

            long elapsedTime  = System.nanoTime() - startTime;
            array[i][0] = n;
            array[i][1] = elapsedTime;
        }
        return array;

    } 

    private long[][] linearTime(int elements)
    {
        long[][] array = new long[elements/10][2];
        for (int i = 0, n = 0; n < elements ; i++)
        {
            n = n+10;
            int[] tempArray = shuffleArray(n);
            long startTime = System.nanoTime();

            new LinearSearch(tempArray).getKey(tempArray[tempArray.length-1]);

            long elapsedTime  = System.nanoTime() - startTime;
            array[i][0] = n;
            array[i][1] = elapsedTime;
        }
        return array;
    }

    private long[][] cubicTime(int elements)
    {
        long[][] array = new long[elements/10][2];
        for (int i = 0, n = 0; n < elements ; i++)
        {
            n = n+10;
            int[][] tempArray = shuffleMatrix(n);
            long startTime = System.nanoTime();

            new MatrixMultiply().matrixMultiply(tempArray,tempArray,n);

            long elapsedTime  = System.nanoTime() - startTime;
            array[i][0] = n;
            array[i][1] = elapsedTime;
        }
        return array;
    }

    private long[][] factorialTime(int elements)
    {
        long[][] array = new long[elements/10][2];
        for (int i = 0, n = 0; n < elements/10; i++)
        {
            n++;
            int[][] tempArray = shuffleDistanceMatrix(n);
            long startTime = System.nanoTime();
            new TravellingSalesmanProblem(tempArray).permutation(1);
            long elapsedTime  = System.nanoTime() - startTime;
            array[i][0] = n;
            array[i][1] = elapsedTime;
        }
        return array;
    }

    private int[] shuffleArray(int length)
    {
        int[] array = new int[length];

        for (int i = 0; i <length ; i++)
        {
            Random random = new Random();
            array[i] = random.nextInt(length);
        }
        return array;
    }

    private int[][] shuffleMatrix(int length)
    {
        int[][] array = new int[length][length];
        for (int i = 0; i < length ; i++)
        {
            for (int j = 0; j < length; j++)
            {
                array[i][j] = new Random().nextInt(length) + 1;
            }
        }
            return array;
    }

    private int[][] shuffleDistanceMatrix(int length) {
        int[][] array = shuffleMatrix(length);
        for (int j=0; j < array.length; j++) {
            array[j][j] = 0;                                // диагональные элементы
            for (int i=j+1; i < array.length; i++) { //  заполняем справа от диагонали матрицу зеркально
                array[j][i]=array[i][j];
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] array = new Graphic().shuffleDistanceMatrix(5);
        for (int i = 0; i < array[0].length; i = i + 1) {
            for (int j = 0; j < array[0].length; j = j + 1) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }



}
