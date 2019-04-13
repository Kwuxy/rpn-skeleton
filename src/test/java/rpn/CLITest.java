package rpn;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
    public void should_evaluate_single_digit_constant() {
        assertThat(calculator.evaluate("5")).isEqualTo(5);
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        assertThat(calculator.evaluate("17")).isEqualTo(17);
    }

    @Test
    public void should_evaluate_single_digit_negative_constant() {
        assertThat(calculator.evaluate("-3")).isEqualTo(-3);
    }

    @Test
    public void should_evaluate_multiple_digit_negative_constant() {
        assertThat(calculator.evaluate("-45")).isEqualTo(-45);
    }

    @Test
    public void should_evaluate_simple_decimal_digit() {
        assertThat(calculator.evaluate("3.5")).isEqualTo(3.5);
    }
    
    @Test
    public void should_evaluate_simple_malformed_decimal_digit() {
        assertThat(calculator.evaluate("4,2")).isEqualTo(4.2);
    }

    @Test
    public void should_evaluate_simple_addition() {
        assertThat(calculator.evaluate("17 5 +")).isEqualTo(22);
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        assertThat(calculator.evaluate("2 3 5 + +")).isEqualTo(10);
    }

    @Test
    public void should_evaluate_complex_addition_with_negative() {
        assertThat(calculator.evaluate("2 -8 4 + +")).isEqualTo(-2);
    }

    @Test
    public void should_evaluate_simple_subtraction() {
        assertThat(calculator.evaluate("4 3 -")).isEqualTo(1);
    }

    @Test
    public void should_evaluate_more_complex_subtraction() {
        assertThat(calculator.evaluate("9 5 - 6 -")).isEqualTo(-2);
    }

    @Test
    public void should_evaluate_complex_addition_and_subtraction() {
        assertThat(calculator.evaluate("1 5 + 8 + 4 - 6 + 12 -")).isEqualTo(4);
    }

    @Test
    public void should_evaluate_simple_multiplication() {
        assertThat(calculator.evaluate("4 3 *")).isEqualTo(12);
    }

    @Test
    public void should_evaluate_more_complex_multiplication() {
        assertThat(calculator.evaluate("6 4 2 * *")).isEqualTo(48);
    }

    @Test
    public void should_evaluate_complex_multiplication_addition_and_subtraction() {
        assertThat(calculator.evaluate("1 8 3 * + 4 2 * -")).isEqualTo(17);
    }

    @Test
    public void should_evaluate_complex_multiplication_addition_and_subtraction_with_negative() {
        assertThat(calculator.evaluate("-1 4 * 5 + -8 -2 * +")).isEqualTo(17);
    }

    @Test
    public void should_evaluate_simple_division() {
        assertThat(calculator.evaluate("6 2 /")).isEqualTo(3);
    }

    @Test
    public void should_evaluate_more_complex_division() {
        assertThat(calculator.evaluate("24 3 / 4 /")).isEqualTo(2);
    }

    @Test
    public void should_evaluate_complex_addition_subtraction_multiplication_and_division() {
        assertThat(calculator.evaluate("1 7 3 * + 2 / -3 + 7 -")).isEqualTo(1);
    }

    @Test
    public void should_evaluate_simple_division_with_decimal_numbers() {
        assertThat(calculator.evaluate("8,28 4.6 /")).isEqualTo(1.8);
    }
}