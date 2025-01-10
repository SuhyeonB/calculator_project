package com.example.calculator3;

public class ArithmeticCalculator<T extends Number> {

    public String calculate(T n, T m, Operator op) {
        double num1 = n.doubleValue();
        double num2 = m.doubleValue();
        double result;

        // Perform calculation based on the operator
        switch (op) {
            case ADD -> result = num1 + num2;
            case SUB -> result = num1 - num2;
            case MUL -> result = num1 * num2;
            case DIV -> {
                if (num2 == 0) throw new ArithmeticException("Cannot divide by zero");
                result = num1 / num2;
            }
            default -> throw new IllegalStateException("Unexpected operator: " + op);
        }

        // Check if both inputs and the result are integers
        if (isInteger(num1) && isInteger(num2) && isInteger(result)) {
            int intNum1 = (int) num1;
            int intNum2 = (int) num2;
            int intResult = (int) result;
            return intNum1 + " " + op.getSymbol() + " " + intNum2 + " = " + intResult;
        }

        // Return result as double if not all are integers
        return num1 + " " + op.getSymbol() + " " + num2 + " = " + result;
    }

    // Helper method to check if a number is an integer
    private boolean isInteger(double num) {
        return num == Math.floor(num) && !Double.isInfinite(num);
    }
}