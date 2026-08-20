import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorLogic calculatorLogic;
    private CalculatorView calculatorView;
    private String currentOperator;
    private double firstOperand;
    private boolean startNewNumber;

    public CalculatorController(CalculatorLogic calculatorLogic, CalculatorView calculatorView) {
        this.calculatorLogic = calculatorLogic;
        this.calculatorView = calculatorView;

        this.calculatorView.buttonActionListener(new ButtonListener());
    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonText = e.getActionCommand();
            if (buttonText.equals("=")) {
                handleEqualsOperator();
            }
            if (buttonText.equals("delete")) {
                if(calculatorView.getCalcScreen().length() > 1){
                    //remove last char
                    String newString = calculatorView.getCalcScreen().substring(0, calculatorView.getCalcScreen().length() - 1);
                    calculatorView.setCalcScreen(newString);
                }
            }
            if (buttonText.equals("C")) {
                calculatorView.setCalcScreen("0");
            }
            if (buttonText.matches("[0-9]")) {
                numbers(buttonText);
            }
            if (buttonText.equals(".")) {
                decimalPoint();
            }
            if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/") || buttonText.equals("%") || buttonText.equals("+/-")) {
                handleOperator(buttonText);
            }
        }

        private void numbers(String num) {
            if(startNewNumber){
                calculatorView.setCalcScreen(num);
                startNewNumber = false;
            }
            else
                calculatorView.setCalcScreen(calculatorView.getCalcScreen() + num);
        }

        private void decimalPoint(){
            if(startNewNumber){
                calculatorView.setCalcScreen("0.");
                startNewNumber = false;
            }
            if(!currentOperator.equals(".")) {
                calculatorView.setCalcScreen(calculatorView.getCalcScreen() + ".");
            }
        }

        private void handleOperator(String operator){
            firstOperand = Double.parseDouble(calculatorView.getCalcScreen());
            currentOperator = operator;
            startNewNumber = true;
        }
    }

    private void handleEqualsOperator(){
        double secondOperand = Double.parseDouble(calculatorView.getCalcScreen());
        double result = calculatorLogic.getCalculation(firstOperand, secondOperand, currentOperator);
        calculatorView.setCalcScreen(String.valueOf(result));
    }
}
