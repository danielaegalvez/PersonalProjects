public class CalculatorLogic {

    private double result;

//    TODO: ADD LOGIC FOR '%'
    public double getCalculation( double a, double b, String operator) {
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "+/-":
                result = -a;
            case "/":
                if (b == 0){
                    throw new ArithmeticException("Division by zero");
                }
                else {
                    result = a / b;
                }
                break;
        }
        return result;
    }

    public double getResult() {
        return result;
    }
}
