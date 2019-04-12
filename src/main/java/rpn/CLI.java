package rpn;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        Double result = evaluate(expression);
        System.out.println("> " + result);
    }

    static Double evaluate(String expression) {
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
