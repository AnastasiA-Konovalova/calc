class ArithmeticOperationForArabic {
    public String arabicAnswer(int numA, int numB, String e) {
        int d = 0;
        if (numA > 10 || numB > 10) {
            throw new RuntimeException("Калькулятор принимает числа до 10 включительно.");
        }
        if (("+").equals(e)) {
            d = numA + numB;
        } else if (("-").equals(e)) {
            d = numA - numB;
        } else if (("*").equals(e)) {
            d = numA * numB;
        } else if (("/").equals(e)) {
            d = numA / numB;
        }
        return Integer.toString(d);
    }
}

