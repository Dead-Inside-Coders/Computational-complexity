package com.novikov.graphical;

import com.novikov.algoritms.p.*;

import java.util.Random;

public class Graphic
{
    public long[][] getGraphic(int elements, String complexity)
    {
        switch (complexity)
        {
            case "O(1)":
                return constTime(elements);
            case "O(n)":
                return nTime(elements);
            case "O(n^2)":
                return npow2(elements);
            case "O(n^3)":
                return npow3(elements);
            case "O(Log n)":
                return ologn(elements);
            case "O(n!)":
                return new long[0][0];
            default:
                return new long[0][0];
        }
    }


    private long[][] ologn(int elements)
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

    private long[][] npow2(int elements)
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

    private long[][] constTime(int elements)
    {
        long[][] array = new long[elements/10][2];
        for (int i = 0, n = 0; n < elements ; i++)
        {
            n = n+10;
            int[] tempArray = shuffleArray(n);
            long startTime = System.nanoTime();

            new ConstTime(tempArray).getMidElement();

            long elapsedTime  = System.nanoTime() - startTime;
            array[i][0] = n;
            array[i][1] = elapsedTime;
        }
        return array;

    }

    private long[][] nTime(int elements)
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

    private long[][] npow3(int elements)
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
                array[i][j] = new Random().nextInt(length);
            }
        }
        return array;
    }



}
