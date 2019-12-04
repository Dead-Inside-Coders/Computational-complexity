package com.novikov.validation;

public class Validatiton {

    private String input;
    private int inputNumber;
    private int maxCount;
    private final int minCount = 2;
    private String message;

    public Validatiton(String input, int maxCount) {
        this.input = input;
        this.maxCount = maxCount;
        message = "";
        inputNumber = -1;
    }

    public boolean isValid() {

        if (!input.isEmpty() && tryParseInt(input)) {
            inputNumber = Integer.parseInt(input);
        }
        else {
            message = "Введите число";
            return false;
        }

        if (inputNumber >= minCount && inputNumber <= maxCount) {
            return true;
        }
        else {
            message = "Число точек - от " + minCount + " до " + maxCount;
            return false;
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
}
