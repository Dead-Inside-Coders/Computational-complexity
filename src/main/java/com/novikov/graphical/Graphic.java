package com.novikov.graphical;

import com.novikov.algoritms.BinarySearch;
import com.novikov.algoritms.BubbleSort;

import java.util.Random;

public class Graphic
{

    public long[][] getGraphic(int elements, String complexity)
    {
        switch (complexity)
        {
            case "O(1)":
                break;
            case "O(n)":
                break;
            case "O(n^2)":
                return OLOGN(elements);
            case "O(n^3)":
                break;
            case "O(Log n)":
                break;
        }
        return new long[0][0];
    }


    private long[][] OLOGN(int elements)
    {
        long[][] array = new long[elements/2][2];
        BinarySearch binarySearch = new BinarySearch();
        for (int i = 0, n = 0; n < elements/2 ; i++)
        {
           n = n+2;
           int[] tempArray = new BubbleSort(shuffleArray(n)).sort();
           long startTime = System.currentTimeMillis();

           binarySearch.binarySearchIterational(tempArray,tempArray[0]);

           long elapsedTime  = System.currentTimeMillis()- startTime;
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
