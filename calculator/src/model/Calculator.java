package model;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private final Map<String, model.Operation> operations;

    public Calculator() {
        operations = new HashMap<>();
        operations.put("+", new model.AdditionOperation());
        operations.put("-", new SubtractionOperation());
        operations.put("*", new MultiplicationOperation());
        operations.put("/", new DivisionOperation());
    }

    public double calculate(double num1, double num2, String operator) {
        model.Operation operation = operations.get(operator);
        if (operation != null) {
            return operation.operate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid operator");
        }
    }
}