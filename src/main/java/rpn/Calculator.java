package rpn;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Calculator {
    private List<Operator> operators;

    public Calculator(List<Operator> operators) {
        this.operators = operators;
    }

    public Double evaluate(String expression) {
        String[] tokens = expression.replace(',', '.').split(" ");
        System.out.println(Arrays.toString(tokens));

        Stack<Double> operands = new Stack<>();
        boolean tokenProcessed;

        for(String token : tokens) {
            tokenProcessed = false;
            for(Operator operator : operators) {
                System.out.println(operator);
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

//        for (String token: tokens) {
//            if("+".equals(token)) {
//                calculator.push(calculator.pop() + calculator.pop());
//            }else if("-".equals(token)) {
//                Double operand = calculator.pop();
//                calculator.push(calculator.pop() - operand);
//            }else if("*".equals(token)) {
//                calculator.push(calculator.pop() * calculator.pop());
//            }else if("/".equals(token)) {
//                Double operand = calculator.pop();
//                calculator.push(calculator.pop() / operand);
//            }else{
//                calculator.push(Double.valueOf(token));
//            }
//        }

        return operands.pop();
    }
}
