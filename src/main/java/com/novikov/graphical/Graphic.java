package com.novikov.graphical;

public class Graphic
{

    public double[][] getGraphic(int elements, String complexity)
    {
        switch (complexity)
        {
            case "O(1)":
                break;
            case "O(n)":
                break;
            case "O(n^2)":
                break;
            case "O(n^3)":
                break;
            case "O(Log n)":
                break;
        }
    }


    private double[][] OLOGN(int elements)
    {
        double[][] array = new double[elements/2][2];
        for (int i = 0, n = 0; n < elements/2 ; i++)
        {
            n = n+2;

        }
    }




}
