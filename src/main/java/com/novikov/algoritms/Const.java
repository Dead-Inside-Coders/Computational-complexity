package com.novikov.algoritms;

public class Const
{
    private int array[];

    public Const(int[] array)
    {
        this.array = array;
    }
    public int getMidNumber()
    {
        return array[array.length/2];
    }
}
