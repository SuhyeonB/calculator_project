package com.example.calculator3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ArithmeticCalculator<T extends Number> {
    private ArrayList<T> nums = new ArrayList<>();
    private Operator op;
    private List<String> results = new ArrayList<>();

    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    public ArithmeticCalculator() {
    }

    public ArithmeticCalculator(ArrayList<T> nums, Operator op) {
        this.nums = nums;
        this.op = op;
    }

    public ArrayList<T> getNums() {
        return nums;
    }

    public void setNums(ArrayList<T> nums) {
        this.nums = nums;
    }

    public Operator getOp() {
        return op;
    }

    public void setOp(Operator op) {
        this.op = op;
    }

    public List<String> getResults() {
        return results;
    }

    // operations
    public void calculate(String str) {
        seperate(str);
        if (nums.size() < 2) {   // operands are not enough
            throw new IllegalArgumentException("At least two numbers are required");
        }

        // 계산
        double n = nums.get(0).doubleValue();
        double m = nums.get(1).doubleValue();
        String operation = "";
        switch (op) {
            case ADD:
                operation = (n + " + " + m + " = " + (n+m));
                System.out.println(operation);
                break;
            case SUB:
                operation = (n + " - " + m + " = " + (n-m));
                System.out.println(operation);
                break;
            case MUL:
                operation = (n + " * " + m + " = " + (n*m));
                System.out.println(operation);
                break;
            case DIV:
                if (m == 0) throw new ArithmeticException("Cannot divided by zero");
                operation = (n + " / " + m + " = " + (n/m));
                System.out.println(operation);
                break;
            default:
                System.out.println("wrong operation");
                break;
        }
        op = null; nums.clear();
        results.add(operation);
    }

    public void seperate(String str) {
        // 문자열을 분해 -> 숫자와 연산자로 구분 후 넣기
        str = str.replaceAll("\\s+", ""); // 모든 공백 제거
        String[] arr = str.split("(?<=[-+*/])|(?=[-+*/])"); // 연산자 앞뒤로 분리

        for (String e : arr) {
            if (e.isBlank()) continue;
            if (Pattern.matches(NUMBER_REG, e)) {
                T numVal = (T) Double.valueOf(e);
                nums.add(numVal);
            } else if (Pattern.matches(OPERATION_REG, e)) {
                if (op == null) { // 연산자가 설정되지 않았는지 확인
                    switch (e) {
                        case "+" -> op = Operator.ADD;
                        case "-" -> op = Operator.SUB;
                        case "*" -> op = Operator.MUL;
                        case "/" -> op = Operator.DIV;
                        default -> throw new IllegalArgumentException("Invalid operator: " + e);
                    }
                } else {
                    throw new IllegalArgumentException("Only one operator is allowed in the expression.");
                }
            } else {
                throw new IllegalArgumentException("Invalid input: " + e);
            }
        }
    }

    // result function

    public void removeResult() {
        results.clear();
        System.out.println("**** Results cleared! ****\\n");
    }

    public void showResults() {
        System.out.println("**** results ****");
        results.stream().forEach(r -> System.out.println(r));
        System.out.print("\n [R (REMOVE ALL RESULTS) | C (BACK TO CALCULATOR) | Q (QUIT)]\n:");
    }
}
