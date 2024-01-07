package model;

public class AdditionOperation implements model.Operation {
    @Override
    public double operate(double num1, double num2) {
        return num1 + num2;
    }
}
