import java.util.Scanner;

public class Main {
    ArithmeticOperationForArabic arithmeticOperationForArabic;
    ArithmeticOperationsForRomanic arithmeticOperationsForRomanic = new ArithmeticOperationsForRomanic();;
    OperationChecker operationChecker;

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scan.nextLine();
        String result = main.calc(input);
        System.out.println("Результат " + result);
    }

    public String calc(String input) throws ArrayIndexOutOfBoundsException {
        String[] str = input.split(" ");

        if (str.length != 3) {
            throw new ArrayIndexOutOfBoundsException("Перехваченное исключение. Должно быть 3 элемента.");
        }
        operationChecker = new OperationChecker();
        operationChecker.isOperationValid(str[1]);

        if (arithmeticOperationsForRomanic.isRomanic(str[0]) &&
                arithmeticOperationsForRomanic.isRomanic(str[2])) {

            String firstNumberRomanic = str[0];
            String secondNumberRomanic = str[2];
            String sign = str[1];

            return arithmeticOperationsForRomanic.romanAnswer(firstNumberRomanic, sign, secondNumberRomanic);
        }

        if (isNumeric(str[0]) && isNumeric(str[2])) {
                int firstNumberArabic = Integer.parseInt(str[0]);
                int secondNumberArabic = Integer.parseInt(str[2]);

                String e = str[1];
                arithmeticOperationForArabic = new ArithmeticOperationForArabic();
                return arithmeticOperationForArabic.arabicAnswer(firstNumberArabic, secondNumberArabic, e);

            }
        throw new RuntimeException("Недопустимая операция");
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}