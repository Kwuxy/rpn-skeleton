package rpn.operators;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import rpn.exceptions.NotEnoughOperandException;

import java.util.EmptyStackException;
import java.util.Stack;

public class Minus extends Operator {
    public Minus() {
        this.symbol = "-";
    }

    @Override
    public void calculate(Stack<Double> operands) throws NotEnoughOperandException {
        try {
            Double operand = operands.pop();
            operands.push(operands.pop() - operand);
        }catch(EmptyStackException e) {
            throw new NotEnoughOperandException(this);
        }
    }

    @Override
    public String toString() {
        return "Minus{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
