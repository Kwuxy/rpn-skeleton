package rpn;

import rpn.exceptions.InvalidOperatorException;
import rpn.operators.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        List<Operator> operators = getAllOperators();
        Calculator calculator = new Calculator(operators);

        System.out.println("About to evaluate '" + expression + "'");
        Double result = null;
        try {
            result = calculator.evaluate(expression);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(result != null) {
            System.out.println("> " + result);
        }
    }

    static List<Operator> getAllOperators() {
        List<Operator> operators = new ArrayList<>();
        operators.add(new Plus());
        operators.add(new Minus());
        operators.add(new Times());
        operators.add(new Divide());
        return operators;
    }
}
