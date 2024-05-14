import java.util.HashMap;
import java.util.Map;

class ArithmeticOperationsForRomanic {
    Map<String, Integer> map;
    ArithmeticOperationsForRomanic() {
        map = new HashMap<>();
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);
    }

    public boolean isRomanic(String a) {

        return map.containsKey(a);
    }

    public String romanAnswer(String a, String b, String c) throws RuntimeException {
        int newA = map.get(a);
        int newB = map.get(c);

        int d = 0;

        if (("+").equals(b)) {
            d = newA + newB;
        } else if (("-").equals(b)) {
            d = newA - newB;
        } else if (("*").equals(b)) {
            d = newA * newB;
        } else if (("/").equals(b)) {
            d = newA / newB;
        }
        if (d <= 0) {
            throw new RuntimeException("Неверная операция");
        }
        return convertToRoman(d);
    }

    private static String convertToRoman(int num) {
        if (num < 1 || num > 100) {
            throw new IllegalArgumentException("Недопустимое число");
        }

        String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
        int[] arabicValues = {1, 4, 5, 9, 10, 40, 50, 90, 100};

        StringBuilder romanNumeral = new StringBuilder();

        int i = arabicValues.length - 1;
        while (num > 0) {
            if (num >= arabicValues[i]) {
                romanNumeral.append(romanSymbols[i]);
                num -= arabicValues[i];
            } else {
                i--;
            }
        }
        return romanNumeral.toString();
    }
}