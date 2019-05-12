package rpn;

import rpn.exceptions.InvalidOperatorException;
import rpn.operators.Operator;

import java.util.List;
import java.util.Stack;

public class Calculator {
    private List<Operator> operators;

    public Calculator(List<Operator> operators) {
        this.operators = operators;
    }

    public Double evaluate(String expression) throws Exception {
        Stack<Double> operands = new Stack<>();
        boolean tokenProcessed;
        String[] tokens = expression.replace(',', '.').split(" ");

        for(String token : tokens) {
            //Token is a number
            if(tokenIsNumeric(token)) {
                operands.push(Double.valueOf(token));
                continue;
            }

            tokenProcessed = false;
            for(Operator operator : operators) { //Token is an implemented operator
                if(operator.symbol.equals(token)) {
                    operator.calculate(operands);
                    tokenProcessed = true;
                    break;
                }
            }

            if(!tokenProcessed) { //Token is unknown
                throw new InvalidOperatorException(token);
            }
        }

        return operands.pop();
    }

    private boolean tokenIsNumeric(String token) {
        try {
            Double.parseDouble(token);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
