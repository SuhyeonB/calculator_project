package com.example.calculator3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            // number
            System.out.println("**** CALCULATOR ****");
            System.out.print("Enter operation (e.g., 2 + 3)\n: ");
            String operation = sc.nextLine();

            // calculate
            try {
                calculator.start(operation);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                continue; // Retry on invalid input
            }

            // options
            System.out.print("[ BACK | EXIT | RESULTS ]\n: ");
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
