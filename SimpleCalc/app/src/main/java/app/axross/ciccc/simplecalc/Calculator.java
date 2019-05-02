package app.axross.ciccc.simplecalc;

class Calculator {
    public double calculate(double firstOperand, double secondOperand, Operator operator) throws CalculationException {
        switch (operator) {
            case ADD:
                return add(firstOperand, secondOperand);
            case SUB:
                return sub(firstOperand, secondOperand);
            case DIV:
                return div(firstOperand, secondOperand);
            case MUL:
                return mul(firstOperand, secondOperand);
        }

        throw new CalculationException(firstOperand, secondOperand, "there's no operator");
    }

    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    public double sub(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    public double div(double firstOperand, double secondOperand) throws CalculationException {
        if (secondOperand == 0) {
            throw new CalculationException(firstOperand, secondOperand, "firstOperand is tried dividing by zero");
        }

        return firstOperand / secondOperand;
    }

    public double mul(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    public enum Operator {ADD, SUB, DIV, MUL}

    public class CalculationException extends Exception {
        private static final long serialVersionUID = 1L;

        CalculationException(double firstOperand, double secondOperand, String reason) {
            super(String.format("Calculation for %f and %f has failed. Because: %s.", firstOperand, secondOperand, reason));
        }
    }
}
