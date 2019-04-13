package rpn;

import java.util.Stack;

public abstract class Operator {
    public String symbol;

    public abstract void calculate(Stack<Double> operands);
}
