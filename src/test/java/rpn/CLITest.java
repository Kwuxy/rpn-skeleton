package rpn;

import org.junit.Before;
import org.junit.Test;
import rpn.exceptions.EmptyExpressionException;
import rpn.exceptions.InvalidOperatorException;
import rpn.exceptions.NotEnoughOperandException;
import rpn.operators.Operator;

import java.util.EmptyStackException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CLITest {
    private Calculator calculator;
    
    @Before
    public void init_tests() {
        List<Operator> operators = CLI.getAllOperators();
        this.calculator = new Calculator(operators);
    }

    @Test
    public void should_evaluate_single_digit_constant() throws Exception {
        assertThat(calculator.evaluate("5")).isEqualTo(5);
    }

    @Test
    public void should_evaluate_multiple_digits_constant() throws Exception {
        assertThat(calculator.evaluate("17")).isEqualTo(17);
    }

    @Test
    public void should_evaluate_single_digit_negative_constant() throws Exception {
        assertThat(calculator.evaluate("-3")).isEqualTo(-3);
    }

    @Test
    public void should_evaluate_multiple_digit_negative_constant() throws Exception {
        assertThat(calculator.evaluate("-45")).isEqualTo(-45);
    }

    @Test
    public void should_evaluate_simple_decimal_digit() throws Exception {
        assertThat(calculator.evaluate("3.5")).isEqualTo(3.5);
    }
    
    @Test
    public void should_evaluate_simple_malformed_decimal_digit() throws Exception {
        assertThat(calculator.evaluate("4,2")).isEqualTo(4.2);
    }

    @Test
    public void should_evaluate_simple_addition() throws Exception {
        assertThat(calculator.evaluate("17 5 +")).isEqualTo(22);
    }

    @Test
    public void should_evaluate_more_complex_addition() throws Exception {
        assertThat(calculator.evaluate("2 3 5 + +")).isEqualTo(10);
    }

    @Test
    public void should_evaluate_complex_addition_with_negative() throws Exception {
        assertThat(calculator.evaluate("2 -8 4 + +")).isEqualTo(-2);
    }

    @Test
    public void should_evaluate_simple_subtraction() throws Exception {
        assertThat(calculator.evaluate("4 3 -")).isEqualTo(1);
    }

    @Test
    public void should_evaluate_more_complex_subtraction() throws Exception {
        assertThat(calculator.evaluate("9 5 - 6 -")).isEqualTo(-2);
    }

    @Test
    public void should_evaluate_complex_addition_and_subtraction() throws Exception {
        assertThat(calculator.evaluate("1 5 + 8 + 4 - 6 + 12 -")).isEqualTo(4);
    }

    @Test
    public void should_evaluate_simple_multiplication() throws Exception {
        assertThat(calculator.evaluate("4 3 *")).isEqualTo(12);
    }

    @Test
    public void should_evaluate_more_complex_multiplication() throws Exception {
        assertThat(calculator.evaluate("6 4 2 * *")).isEqualTo(48);
    }

    @Test
    public void should_evaluate_complex_multiplication_addition_and_subtraction() throws Exception {
        assertThat(calculator.evaluate("1 8 3 * + 4 2 * -")).isEqualTo(17);
    }

    @Test
    public void should_evaluate_complex_multiplication_addition_and_subtraction_with_negative() throws Exception {
        assertThat(calculator.evaluate("-1 4 * 5 + -8 -2 * +")).isEqualTo(17);
    }

    @Test
    public void should_evaluate_simple_division() throws Exception {
        assertThat(calculator.evaluate("6 2 /")).isEqualTo(3);
    }

    @Test
    public void should_evaluate_more_complex_division() throws Exception {
        assertThat(calculator.evaluate("24 3 / 4 /")).isEqualTo(2);
    }

    @Test
    public void should_evaluate_complex_addition_subtraction_multiplication_and_division() throws Exception {
        assertThat(calculator.evaluate("1 7 3 * + 2 / -3 + 7 -")).isEqualTo(1);
    }

    @Test
    public void should_evaluate_simple_division_with_decimal_numbers() throws Exception {
        assertThat(calculator.evaluate("8,28 4.6 /")).isEqualTo(1.8);
    }

    @Test
    public void should_raise_invalid_operator_exception() throws Exception {
        try {
            calculator.evaluate("4 3 ^");
        } catch (InvalidOperatorException e) {
            assertThat(e.getMessage()).isEqualTo("Operator '^' is not implemented in the calculator.");
        }
    }

    @Test
    public void should_raise_not_enough_operand_exception_on_addition() throws Exception {
        try {
            calculator.evaluate("4 +");
        }catch(NotEnoughOperandException e) {
            assertThat(e.getMessage()).isEqualTo("Not enough operands to calculate operator '+'");
        }
    }

    @Test
    public void should_raise_not_enough_operand_exception_on_subtraction() throws Exception {
        try {
            calculator.evaluate("4 -");
        }catch(NotEnoughOperandException e) {
            assertThat(e.getMessage()).isEqualTo("Not enough operands to calculate operator '-'");
        }
    }

    @Test
    public void should_raise_not_enough_operand_exception_on_multiplication() throws Exception {
        try {
            calculator.evaluate("4 *");
        }catch(NotEnoughOperandException e) {
            assertThat(e.getMessage()).isEqualTo("Not enough operands to calculate operator '*'");
        }
    }

    @Test
    public void should_raise_not_enough_operand_exception_on_division() throws Exception {
        try {
            calculator.evaluate("4 /");
        }catch(NotEnoughOperandException e) {
            assertThat(e.getMessage()).isEqualTo("Not enough operands to calculate operator '/'");
        }
    }

    @Test
    public void should_raise_empty_expression_exception_on_empty_expression() throws Exception {
        System.out.println("Running should_raise_empty_expression_exception_on_empty_expression()");
        try{
            calculator.evaluate("");
        } catch (EmptyExpressionException e) {
            assertThat(e.getMessage()).isEqualTo("Nothing to evaluate here.");
        }
    }

    @Test
    public void should_raise_empty_expression_exception_on_expression_full_of_spaces() throws Exception {
        System.out.println("Running should_raise_empty_expression_exception_on_expression_full_of_spaces()");
        try{
            calculator.evaluate("          ");
        } catch (EmptyExpressionException e) {
            assertThat(e.getMessage()).isEqualTo("Nothing to evaluate here.");
        }
    }
}