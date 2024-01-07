import controller.CalculatorController;
import model.Calculator;
import view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        Calculator model = new Calculator();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        controller.processUserInput();
    }
}
