package com.novikov.algoritms.P;

public class BubbleSort
{
    private int array[];

    public BubbleSort(int array[])
    {
        this.array = array;
    }

    public int[] sort()
    {
        for (int i = 0; i < array.length -1;i++)
        {
            for (int j = array.length - 1; j > i; j--)
            {
                if (array[j] < array[j-1])
                {
                    int temp;
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        return array;
    }
}
