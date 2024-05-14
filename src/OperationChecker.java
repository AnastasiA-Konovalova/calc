class OperationChecker {
    public boolean isOperationValid(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        } else {
            throw new RuntimeException("Неверная операция");
        }
    }
}
