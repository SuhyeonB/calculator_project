package com.example.calculator3;

import com.example.calculator2.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {
            // number
            System.out.println("**** CALCULATOR ****");
            String operation = sc.nextLine();

            // calculate
            calculator.calculate(operation);

            System.out.print("[BACK | EXIT | RESULTS ]\n: ");
            String cont = sc.nextLine();

            if (cont.toLowerCase().equals("exit")) break;
            else if (cont.toLowerCase().equals("results")) {
                calculator.showResults();
                char c = sc.next().charAt(0);
                sc.nextLine();
                if (c=='q' || c=='Q') break;
                else if (c=='r' || c=='R') calculator.removeResult();
                else continue;
            }
            System.out.println("\n************************\n");
        }

        System.out.println("\ncalculator closed");
    }
}
