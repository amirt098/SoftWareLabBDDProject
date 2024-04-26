package calculator;

public class Calculator {
    public double calculate(int first, int second, char operator) {
        switch (operator) {
            case '*':
                return first * second;
            case '/':
                if (second == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero.");
                }
                return first / second;
            case '^':
                return Math.pow(first, second);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}