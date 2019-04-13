package rpn;

import java.util.Stack;

public abstract class Operator {
    public String symbol;

    public abstract Stack<Double> calculate(Stack<Double> calculator);
}
