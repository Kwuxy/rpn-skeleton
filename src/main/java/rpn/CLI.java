package rpn;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));
        Calculator calculator = new Calculator();

        System.out.println("About to evaluate '" + expression + "'");
        Double result = calculator.evaluate(expression);
        System.out.println("> " + result);
    }
}
