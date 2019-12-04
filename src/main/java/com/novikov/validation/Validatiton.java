package com.novikov.validation;

public class Validatiton {

    private String input;
    private int maxCount;

    public Validatiton(String algorithmName, String input) throws InputDataException
    {
        this.input = input;
        this.maxCount = getMaxValue(algorithmName);
    }

    public boolean isValid() throws InputDataException {

        if (input.isEmpty() && !tryParseInt(input))
        {
            throw new InputDataException("Введите число");
        }
        int inputNumber = Integer.parseInt(input);
        if (!(inputNumber >= 2 && inputNumber <= maxCount))
        {
            throw new InputDataException("Число точек - от " + 2 + " до " + maxCount);
        }
        return true;
    }


    private static boolean tryParseInt(String value)
    {
        try
        {
            Integer.parseInt(value);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    private int getMaxValue(String algorithmName) throws InputDataException
    {
        switch (algorithmName)
        {
            case "O(1) - Нахождение среднего элемента массива":
                return 1000;
            case "O(n) - Линейный поиск":
                return 1000;
            case "O(n^2) - Сортировка пузырьком":
                return 200;
            case "O(n^3) - Умножение матриц":
                return 30;
            case "O(Log n) - Бинарный поиск":
                return 400;
            case "O(n!) - Задача коммивояжера":
                return 10;
            default:
                throw new InputDataException("Выберите алгоритм");//Так не робит
        }
    }
}
