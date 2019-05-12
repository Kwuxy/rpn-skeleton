package rpn.operators;

import rpn.exceptions.NotEnoughOperandException;

import java.util.EmptyStackException;
import java.util.Stack;

public class Plus extends Operator {
    public Plus() {
        this.symbol = "+";
    }

    @Override
    public void calculate(Stack<Double> operands) throws NotEnoughOperandException {
        try {
            operands.push(operands.pop() + operands.pop());
        }catch(EmptyStackException e) {
            throw new NotEnoughOperandException(this);
        }
    }

    @Override
    public String toString() {
        return "Plus{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
