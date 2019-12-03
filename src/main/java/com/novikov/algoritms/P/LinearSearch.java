package com.novikov.algoritms.p;

public class LinearSearch
{
    private int array[];

    public LinearSearch(int[] array)
    {
        this.array = array;
    }

    public Integer getKey(int number)
    {
        for (int i = 0; i < array.length; i++)
        {
            if(array[i]==number) return i;
        }
        return null;
    }
}
