package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // lv1; simple calculator without class
        Scanner sc = new Scanner(System.in);

        while (true) {
            // number
            System.out.println("INPUT TWO NUMBER!");
            System.out.println("** Only positive integers or 0 are allowed. **");
            System.out.print("First: ");
            int n1 = sc.nextInt();
            System.out.print("Second: ");
            int n2 = sc.nextInt();

            // operator
            System.out.println("INPUT THE OPERATOR [ + (ADD) | - (SUB) | * (MUL) | / (DIV) ]");
            char op = sc.next().charAt(0);
            sc.nextLine();

            if (n1<0 || n2<0) {
                System.out.println("INVALID INPUT!!!!");
                break;
            }
            switch(op) {
                case '+':
                    System.out.println(n1 + " " + op + " " + n2 + " = " + (n1+n2));
                    break;
                case '-':
                    System.out.println(n1 + " " + op + " " + n2 + " = " + (n1-n2));
                    break;
                case '*':
                    System.out.println(n1 + " " + op + " " + n2 + " = " + (n1*n2));
                    break;
                case '/':
                    System.out.println(n1 + " " + op + " " + n2 + " = " + (n1/n2));
                    break;
                default:
                    System.out.println("INVALID INPUT!!!!");
                    break;
            }

            System.out.print("EXIT? (yes/no): ");
            String cont = sc.nextLine();

            if (cont.toLowerCase().equals("yes") || cont.toLowerCase().equals("y")) break;
            System.out.println("\n************************\n");
        }

        System.out.println("\ncalculator closed");
    }
}
