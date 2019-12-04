package com.novikov.validation;

public class Validatiton {

    private String input;
    private int inputNumber;
    private int maxCount;
    private final int minCount = 2;
    private String message;

    public Validatiton(String algorithmName, String input)
    {
        this.input = input;
        this.maxCount = getMaxValue(algorithmName);
        message = "";
        inputNumber = -1;
    }

    public boolean isValid() throws InputDataException {

        if (!input.isEmpty() && tryParseInt(input)) {
            inputNumber = Integer.parseInt(input);
        }
        else {
            throw new InputDataException("Введите число");
        }

        if (inputNumber >= minCount && inputNumber <= maxCount) {
            return true;
        }
        else {
            throw new InputDataException("Число точек - от " + minCount + " до " + maxCount);
        }
    }

    public int getInputNumber() {
        return inputNumber;
    }

    public String getMessage() {
        return message;
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

    private int getMaxValue(String algorithmName)
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
                return 9;
            default:
                return -1;
        }
    }
}
