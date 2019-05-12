package rpn.operators;

import java.util.Stack;

public class Divide extends Operator {
    public Divide() {
        this.symbol = "/";
    }

    @Override
    public void calculate(Stack<Double> operands) {
        Double operand = operands.pop();
        operands.push(operands.pop() / operand);
    }

    @Override
    public String toString() {
        return "Divide{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
