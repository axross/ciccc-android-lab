package app.axross.ciccc.simplecalc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class CalculatorTest {
    private Calculator calculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double result = calculator.add(1d, 1d);

        assertThat(result, is(equalTo(2d)));
    }

    @Test
    public void addTwoNegativeNumbers() {
        double result = calculator.add(-1d, 2d);

        assertThat(result, is(equalTo(1d)));
    }

    @Test
    public void addTwoFloatNumbers() {
        double result = calculator.add(1.111f, 1.111d);

        assertThat(result, is(closeTo(2.222, 0.01)));
    }

    @Test
    public void subTwoNumbers() {
        double resultSub = calculator.sub(1d, 1d);

        assertThat(resultSub, is(equalTo(0d)));
    }

    @Test
    public void subWorksWithNegativeResult() {
        double resultSub = calculator.sub(1d, 17d);

        assertThat(resultSub, is(equalTo(-16d)));
    }

    @Test
    public void mulTwoNumbers() {
        double resultMul = calculator.mul(32d, 2d);

        assertThat(resultMul, is(equalTo(64d)));
    }

    @Test
    public void divTwoNumbers() {
        double resultDiv = calculator.div(32d,2d);

        assertThat(resultDiv, is(equalTo(16d)));
    }

    @Test
    public void divTwoNumbersZero() {
        double resultDiv = calculator.div(32d,0);

        assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));
    }
}