package ru.nsu.medvedev.v;

import java.util.Scanner;

public class Calculator {

    public double startCalculate(String expression) {
        Scanner expr = new Scanner(expression);
        String action = expr.next();
        Actions actions = new Actions();

        return switch (action) {
            case "+" -> actions.sum(Double.parseDouble(expr.next()), Double.parseDouble(expr.next()));
            case "-" -> actions.subtraction(Double.parseDouble(expr.next()), Double.parseDouble(expr.next()));
            case "/" -> actions.division(Double.parseDouble(expr.next()), Double.parseDouble(expr.next()));
            case "*" -> actions.multiplication(Double.parseDouble(expr.next()), Double.parseDouble(expr.next()));
            case "log" -> actions.log(Double.parseDouble(expr.next()));
            case "pow" -> actions.pow(Double.parseDouble(expr.next()), Double.parseDouble(expr.next()));
            case "sqrt" -> actions.sqrt(Double.parseDouble(expr.next()));
            case "sin" -> actions.sin(Double.parseDouble(expr.next()));
            case "cos" -> actions.cos(Double.parseDouble(expr.next()));
            default -> 0;
        };
    }

}