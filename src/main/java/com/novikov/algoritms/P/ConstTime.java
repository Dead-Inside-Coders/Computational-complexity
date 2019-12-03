package com.novikov.algoritms.P;

public class ConstTime
{
    private int array[];

    public ConstTime(int[] array)
    {
        this.array = array;
    }

    public int getMidElement()
    {
        return array[array.length/2];
    }
}
