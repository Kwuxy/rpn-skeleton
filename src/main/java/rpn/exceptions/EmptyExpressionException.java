package rpn.exceptions;

public class EmptyExpressionException extends Exception {
    public EmptyExpressionException() {
        super("Nothing to evaluate here.");
    }
}
