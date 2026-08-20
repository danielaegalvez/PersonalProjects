import javax.swing.*;

public class CalculatorMVC {
    public static void main (String[]args){

        SwingUtilities.invokeLater(() -> {
            CalculatorView view = new CalculatorView();
            CalculatorLogic logic = new CalculatorLogic();
            CalculatorController controller = new CalculatorController(logic, view);
        });

    }
}
