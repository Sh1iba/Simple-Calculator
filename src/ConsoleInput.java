import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleInput {
    private final Scanner scanner = new Scanner(System.in);
    private final Pattern OPERAND_PATTERN = Pattern.compile("\\d+");
    private final Pattern OPERATOR_PATTERN = Pattern.compile(("^[-+*/]$"));

    public double readOperand() {
        while (true) {
            String operand = scanner.nextLine();
            if (isNumber(operand)) {
                return Double.parseDouble(operand);
            } else {
                printOperandInputErrorBanner();
            }
        }
    }

    public double readOperator() {
        while (true) {
            String operator = scanner.nextLine();
            if (isOperator(operator)) {
                return Double.parseDouble(operator);
            } else {
                printOperatorInputErrorBanner();
            }
        }
    }

    private boolean isNumber(String operand) {
        return OPERAND_PATTERN.matcher(operand).matches();
    }

    private boolean isOperator(String operator){
        return OPERATOR_PATTERN.matcher(operator).matches();
    }

    private void printOperatorInputErrorBanner(){
        System.out.println("""
            ╔══════════════════════════════════════════════════════════╗
            ║  Введите корректную арифметическую операцию: +, -, *, /  ║
            ╚══════════════════════════════════════════════════════════╝
            """);
    }

    private void printOperandInputErrorBanner(){
        System.out.println("""
            ╔════════════════════════════╗
            ║  Введите корректное число  ║
            ╚════════════════════════════╝
            """);
    }
}
