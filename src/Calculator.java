import java.util.Scanner;

public class Calculator {
    private static final char ADDITION_OPERATOR = '+';
    private static final char SUBTRACTION_OPERATOR = '-';
    private static final char MULTIPLICATION_OPERATOR = '*';
    private static final char DIVISION_OPERATOR = '/';
    private final Scanner scanner = new Scanner(System.in);
    private double result = 0;


    public void start() {
        while (true) {
            calculate();
        }
    }

    private void calculateLoop() {
        String scanner.nextLine();
    }

    private double calculate(double a, char operator, double b) {
        return switch (operator) {
            case ADDITION_OPERATOR -> add(a, b);
            case SUBTRACTION_OPERATOR -> subtract(a, b);
            case MULTIPLICATION_OPERATOR -> multiply(a, b);
            case DIVISION_OPERATOR -> divide(a, b);
            default -> result;
        };
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double subtract(double a, double b) {
        return a - b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double divide(double a, double b) {
        return a / b;
    }
}
