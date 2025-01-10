package com.example.calculator3;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<String> results = new ArrayList<>();
    private final ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>();

    public Calculator(){};

    public void start(String str) {
        str = str.replaceAll("\\s+", ""); // 공백 제거
        String[] arr = str.split("(?<=[-+*/])|(?=[-+*/])"); // 연산자 기준으로 자르기

        if (arr.length != 3) {
            throw new IllegalArgumentException("Invalid input format. Use: number operator number (e.g., 2+3)");
        }

        // Parse numbers and operator
        double num1 = Double.parseDouble(arr[0]);
        double num2 = Double.parseDouble(arr[2]);
        String operator = arr[1];

        // Map operator string to Enum
        Operator op = switch (operator) {
            case "+" -> Operator.ADD;
            case "-" -> Operator.SUB;
            case "*" -> Operator.MUL;
            case "/" -> Operator.DIV;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };

        // Perform calculation
        String result = arithmeticCalculator.calculate(num1, num2, op);
        results.add(result); // Store result
        System.out.println(result); // Display result
    }
    // result functions
    public void removeResult() {
        results.clear();
        System.out.println("**** Results cleared! ****\n");
    }

    public void showResults() {
        System.out.println("**** results ****");
        results.stream().forEach(r -> System.out.println(r));
        System.out.print("\n [R (REMOVE ALL RESULTS) | C (BACK TO CALCULATOR) | Q (QUIT)]\n:");
    }
}
