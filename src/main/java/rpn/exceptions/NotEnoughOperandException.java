package rpn.exceptions;

import rpn.operators.Operator;

public class NotEnoughOperandException extends Exception {
    public NotEnoughOperandException(Operator operator) {
        super("Not enough operands to calculate operator '" + operator.symbol + "'");
    }
}
