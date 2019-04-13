package rpn;

import java.util.Stack;

public class Plus extends Operator {
    public Plus() {
        this.symbol = "+";
    }

    @Override
    public Stack<Double> calculate(Stack<Double> calculator) {
        calculator.push(calculator.pop() + calculator.pop());
        return calculator;
    }

    @Override
    public String toString() {
        return "Plus{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
