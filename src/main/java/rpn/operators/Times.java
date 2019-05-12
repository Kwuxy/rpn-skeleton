package rpn.operators;

import java.util.Stack;

public class Times extends Operator {
    public Times() {
        this.symbol = "*";
    }

    @Override
    public void calculate(Stack<Double> operands) {
        operands.push(operands.pop() * operands.pop());
    }

    @Override
    public String toString() {
        return "Times{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
