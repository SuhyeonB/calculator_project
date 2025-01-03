package com.example.calculator2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            // number
            System.out.println("INPUT TWO NUMBER!");
            System.out.println("** Only positive integers or 0 are allowed. **");

            System.out.print("First: ");
            calculator.setNum1(sc.nextInt());

            System.out.print("Second: ");
            calculator.setNum2(sc.nextInt());

            // operator
            System.out.println("INPUT THE OPERATOR [ + (ADD) | - (SUB) | * (MUL) | / (DIV) ]");
            calculator.setOp(sc.next().charAt(0));
            sc.nextLine();

            // calculate
            calculator.calculate();

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
