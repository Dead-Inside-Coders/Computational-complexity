package com.novikov.graphical;

import com.novikov.algoritms.p.BinarySearch;
import com.novikov.algoritms.p.BubbleSort;

import java.util.Random;

public class Graphic
{
    public long[][] getGraphic(int elements, String complexity)
    {
        switch (complexity)
        {
            case "O(1)":
                return new long[0][0];
            case "O(n)":
                return new long[0][0];
            case "O(n^2)":
                return new long[0][0];
            case "O(n^3)":
                return new long[0][0];
            case "O(Log n)":
                return OLOGN(elements);
            default:
                return new long[0][0];
        }
    }


    private long[][] OLOGN(int elements)
    {
        long[][] array = new long[elements/2][2];
        BinarySearch binarySearch = new BinarySearch();
        for (int i = 0, n = 0; n < elements ; i++)
        {
           n = n+2;
           int[] tempArray = new BubbleSort(shuffleArray(n)).sort();
           long startTime = System.nanoTime();//System.currentTimeMillis();

           binarySearch.binarySearchIterational(tempArray,tempArray[0]);

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



}
