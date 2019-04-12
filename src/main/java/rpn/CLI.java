package rpn;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        long result = evaluate(expression);
        System.out.println("> " + result);
    }

    static long evaluate(String expression) {
        String tokens[] = expression.split(" ");
        System.out.println(Arrays.toString(tokens));

        Stack<Long> calculator = new Stack<>();
        for (String token: tokens) {
            if("+".equals(token)) {
                calculator.push(calculator.pop() + calculator.pop());
            }else if("-".equals(token)) {
                Long operand = calculator.pop();
                calculator.push(calculator.pop() - operand);
            }else{
                calculator.push(Long.valueOf(token));
            }
        }

        return calculator.pop();
    }
}
