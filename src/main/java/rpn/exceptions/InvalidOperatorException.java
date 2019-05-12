package rpn.exceptions;

public class InvalidOperatorException extends Exception {
    public InvalidOperatorException(String operator) {
        super("Operator '" + operator + "' is not implemented in the calculator.");
    }
}
