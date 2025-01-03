package com.example.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    int num1;
    int num2;
    char op;
    List<String> results = new ArrayList<>();

    public Calculator() {}

    public Calculator(int num1, int num2, char op) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public List<String> getResults() {
        return results;
    }

    // operations
    public void calculate(){
        if(!check(num1,num2, op)) {
            System.out.println("INVALID INPUT!!!!");
        }
        if (op=='+') add(num1,num2);
        if (op=='-') sub(num1,num2);
        if (op=='*') mul(num1,num2);
        if (op=='/') div(num1,num2);
    }
    void add(int n, int m) {
        String exp = n + " + " + m + " = " + (n+m);
        results.add(exp);
        System.out.println(exp);
    }
    void sub(int n, int m) {
        String exp = n + " - " + m + " = " + (n-m);
        results.add(exp);
        System.out.println(exp);
    }
    void mul(int n, int m) {
        String exp = n + " * " + m + " = " + (n*m);
        results.add(exp);
        System.out.println(exp);
    }
    void div(int n, int m) {
        String exp = n + " / " + m + " = " + (n/m);
        results.add(exp);
        System.out.println(exp);
    }

    // others
    boolean check(int n, int m, char op){
        if (!(op == '+' || op == '-' || op == '*' || op == '/')) return false;
        return (n>0 && m>0) ? true : false;
    }

    public void removeResult() {
        results.clear();
        System.out.println("**** results ****\n\n");
        for (String res : results) System.out.println(res);
    }

    public void showResults() {
        System.out.println("**** results ****");
        for (String res : results) System.out.println(res);
        System.out.print("\n [R (REMOVE ALL RESULTS) | C (BACK TO CALCULATOR) | Q (QUIT)]\n:");
    }
}
