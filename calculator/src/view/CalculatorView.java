package view;

import java.util.Scanner;

public class CalculatorView {
    private final Scanner scanner;
    String prompt = "Введите число";
    public CalculatorView() {
        scanner = new Scanner(System.in);
    }

    public double getNumberInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextDouble();
    }

    public String getOperatorInput() {
        System.out.print("Enter the operator (+, -,  *, /): ");
        return scanner.next();
    }

    public void displayResult(double result) {
        System.out.println("Result: " + result);
    }

    public void displayError(String errorMessage) {
        System.err.println("Error: " + errorMessage);
    }
}

