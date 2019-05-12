package rpn.operators;

import rpn.exceptions.NotEnoughOperandException;

import java.util.EmptyStackException;
import java.util.Stack;

public class Divide extends Operator {
    public Divide() {
        this.symbol = "/";
    }

    @Override
    public void calculate(Stack<Double> operands) throws NotEnoughOperandException {
        try{
            Double operand = operands.pop();
            operands.push(operands.pop() / operand);
        }catch(EmptyStackException e) {
            throw new NotEnoughOperandException(this);
        }
    }

    @Override
    public String toString() {
        return "Divide{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
