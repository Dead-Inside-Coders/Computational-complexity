package com.novikov.application;

import com.novikov.algoritms.np.TravellingSalesmanProblem;
import com.novikov.algoritms.p.*;
import com.novikov.validation.InputDataException;
import com.novikov.validation.Validatiton;

import java.util.Random;

public class GraphicBuilder
{
    private final int INPUT_NUMBER_MULTIPLIER = 10;

    public long[][] buildGraphic(String elements, String complexity)  throws InputDataException
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
     // 2 - 400
    private long[][] logarithmicTime(String elements) throws InputDataException
    {
        Validatiton validatiton = new Validatiton(elements,400);
        if (!validatiton.isValid()) throw new InputDataException(validatiton.getMessage());

        int elementsCount = validatiton.getInputNumber() * INPUT_NUMBER_MULTIPLIER;

        long[][] array = new long[elementsCount/10][2];
        BinarySearch binarySearch = new BinarySearch();
        for (int i = 0, n = 0; n < elementsCount ; i++)
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

    // 2 - 200
    private long[][] quadraticTime(String elements) throws InputDataException
    {
        Validatiton validatiton = new Validatiton(elements,200);
        if (!validatiton.isValid()) throw new InputDataException(validatiton.getMessage());

        int elementsCount = validatiton.getInputNumber();

        long[][] array = new long[elementsCount/10][2];

        for (int i = 0, n = 0; n < elementsCount ; i++)
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

    //2 - 1000
    private long[][] constantTime(String elements) throws InputDataException
    {
        Validatiton validatiton = new Validatiton(elements,1000);
        if (!validatiton.isValid()) throw new InputDataException(validatiton.getMessage());

        int elementsCount = validatiton.getInputNumber() * INPUT_NUMBER_MULTIPLIER;

        long[][] array = new long[elementsCount/10][2];
        for (int i = 0, n = 0; n < elementsCount ; i++)
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

    // 2 - 1000 
    private long[][] linearTime(String elements) throws InputDataException
    {
        Validatiton validatiton = new Validatiton(elements,1000);
        if (!validatiton.isValid()) throw new InputDataException(validatiton.getMessage());

        int elementsCount = validatiton.getInputNumber() * INPUT_NUMBER_MULTIPLIER;

        long[][] array = new long[elementsCount/10][2];
        for (int i = 0, n = 0; n < elementsCount; i++)
        {
            n = n + 10;
            int[] tempArray = shuffleArray(n);
            long startTime = System.nanoTime();

            new LinearSearch(tempArray).getKey(tempArray[tempArray.length-1]);

            long elapsedTime  = System.nanoTime() - startTime;
            array[i][0] = n;
            array[i][1] = elapsedTime;
        }
        return array;
    }

    //2 - 30
    private long[][] cubicTime(String elements) throws InputDataException
    {
        Validatiton validatiton = new Validatiton(elements,30);
        if (!validatiton.isValid()) throw new InputDataException(validatiton.getMessage());

        int elementsCount = validatiton.getInputNumber() * INPUT_NUMBER_MULTIPLIER;

        long[][] array = new long[elementsCount/10][2];
        for (int i = 0, n = 0; n < elementsCount; i++)
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

    // 2 - 9
    private long[][] factorialTime(String elements) throws InputDataException
    {
        Validatiton validatiton = new Validatiton(elements,9);
        if (!validatiton.isValid()) throw new InputDataException(validatiton.getMessage());

        int elementsCount = validatiton.getInputNumber() * INPUT_NUMBER_MULTIPLIER;

        long[][] array = new long[elementsCount/10][2];
        for (int i = 0, n = 0; n < elementsCount/10; i++)
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
        int[][] array = new GraphicBuilder().shuffleDistanceMatrix(5);
        for (int i = 0; i < array[0].length; i = i + 1) {
            for (int j = 0; j < array[0].length; j = j + 1) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }



}
