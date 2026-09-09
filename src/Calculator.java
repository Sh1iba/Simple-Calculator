public class Calculator {
    private static final char ADDITION_OPERATOR = '+';
    private static final char SUBTRACTION_OPERATOR = '-';
    private static final char MULTIPLICATION_OPERATOR = '*';
    private static final char DIVISION_OPERATOR = '/';
    private static final char EXIT_SYMBOL = 'S';
    private static final char CLEAR_SYMBOL = 'C';
    private final ConsoleInput consoleInput = new ConsoleInput();
    private AppState appState;
    private CalculationsState calculationsState;
    private double result;


    public void start() {
        init();
        while (appState == AppState.START) {
            calculationsLoop();
        }
    }

    private void calculationsLoop() {
        double a;
        if (calculationsState == CalculationsState.CLEARED) {
            System.out.println("Введите число");
            a = consoleInput.readOperand();
        } else {
            a = result;
        }
        System.out.println("Введите операцию");
        char operator = consoleInput.readOperator();
        if (operator == EXIT_SYMBOL) {
            appState = AppState.EXIT;
            return;
        }
        if (operator == CLEAR_SYMBOL) {
            calculationsState = CalculationsState.CLEARED;
            result = 0;
            System.out.printf("----- Результат сброшен -----%n%n");
            return;
        }
        System.out.println("Введите число");
        double b = consoleInput.readOperand();
        try {
            result = calculate(a, operator, b);
            calculationsState = CalculationsState.CALCULATED;
            System.out.printf("Результат: %s%n%n", result);
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }

    private double calculate(double a, char operator, double b) {
        return switch (operator) {
            case ADDITION_OPERATOR -> add(a, b);
            case SUBTRACTION_OPERATOR -> subtract(a, b);
            case MULTIPLICATION_OPERATOR -> multiply(a, b);
            case DIVISION_OPERATOR -> divide(a, b);
            default -> throw new IllegalStateException("Unexpected value: " + operator);
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
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        return a / b;
    }

    private void init() {
        appState = AppState.START;
        calculationsState = CalculationsState.CLEARED;
        System.out.println("""
                ╔═══════════════════╗
                ║  Калькулятор 🔢🧮 ║
                ╚═══════════════════╝
                """);
    }
}
