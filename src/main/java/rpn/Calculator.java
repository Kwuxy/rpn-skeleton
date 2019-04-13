package rpn;

import java.util.List;
import java.util.Stack;

public class Calculator {
    private List<Operator> operators;

    public Calculator(List<Operator> operators) {
        this.operators = operators;
    }

    public Double evaluate(String expression) {
        Stack<Double> operands = new Stack<>();
        boolean tokenProcessed;

        String[] tokens = expression.replace(',', '.').split(" ");

        for(String token : tokens) {
            tokenProcessed = false;
            for(Operator operator : operators) {
                if(operator.symbol.equals(token)) {
                    operator.calculate(operands);
                    tokenProcessed = true;
                    break;
                }
            }

            if(!tokenProcessed) {
                operands.push(Double.valueOf(token));
            }
        }

        return operands.pop();
    }
}
