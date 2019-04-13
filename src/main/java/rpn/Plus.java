package rpn;

import java.util.Stack;

public class Plus extends Operator {
    public Plus() {
        this.symbol = "+";
    }

    @Override
    public void calculate(Stack<Double> operands) {
        operands.push(operands.pop() + operands.pop());
    }

    @Override
    public String toString() {
        return "Plus{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
