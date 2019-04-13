package rpn;

import java.util.Stack;

public class Minus extends Operator {
    public Minus() {
        this.symbol = "-";
    }

    @Override
    public void calculate(Stack<Double> operands) {
        Double operand = operands.pop();
        operands.push(operands.pop() - operand);
    }

    @Override
    public String toString() {
        return "Minus{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
