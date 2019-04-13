package rpn;

import java.util.Arrays;
import java.util.Stack;

public class Calculator {
    public Double evaluate(String expression) {
        String[] tokens = expression.replace(',', '.').split(" ");
        System.out.println(Arrays.toString(tokens));

        Stack<Double> calculator = new Stack<>();
        for (String token: tokens) {
            if("+".equals(token)) {
                calculator.push(calculator.pop() + calculator.pop());
            }else if("-".equals(token)) {
                Double operand = calculator.pop();
                calculator.push(calculator.pop() - operand);
            }else if("*".equals(token)) {
                calculator.push(calculator.pop() * calculator.pop());
            }else if("/".equals(token)) {
                Double operand = calculator.pop();
                calculator.push(calculator.pop() / operand);
            }else{
                calculator.push(Double.valueOf(token));
            }
        }

        return calculator.pop();
    }
}
