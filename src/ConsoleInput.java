import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleInput {
    private final Scanner scanner = new Scanner(System.in);
    private final Pattern OPERAND_PATTERN = Pattern.compile("^-?\\d+(\\.\\d+)?$");
    private final Pattern OPERATOR_PATTERN = Pattern.compile(("^[-+*/cCsS]$"));

    public double readOperand() {
        while (true) {
            String operand = scanner.nextLine();
            if (isNumber(operand)) {
                return Double.parseDouble(operand);
            } else {
                System.err.println("Введите корректное число");
            }
        }
    }

    public char readOperator() {
        while (true) {
            String operator = scanner.nextLine().toUpperCase();
            if (isOperator(operator) && operator.length() == 1) {
                return operator.charAt(0);
            } else {
                System.err.println("Введите корректную арифметическую операцию: (+, -, *, /) или команду (C — сброс, S — выход)");
            }
        }
    }

    private boolean isNumber(String operand) {
        return OPERAND_PATTERN.matcher(operand).matches();
    }

    private boolean isOperator(String operator) {
        return OPERATOR_PATTERN.matcher(operator).matches();
    }
}
