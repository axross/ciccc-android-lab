package app.axross.ciccc.simplecalc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
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
}