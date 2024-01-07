package model;

public class DivisionOperation implements model.Operation {
    @Override
    public double operate(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Cannot divide by zero.");
        }
    }
}
