package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CalculatorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void emptyTest() throws Exception {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void oneNumTesT() throws Exception {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void twoNumTest() throws Exception {
        assertEquals(3, Calculator.add("1,2"));
    }

    @Test
    public void multNumTest() throws Exception {
        assertEquals(45, Calculator.add("1,2,3,4,5,6,7,8,9"));
    }

    @Test
    public void nlTest() throws Exception {
        assertEquals(6, Calculator.add("1,2\n3"));
    }

    @Test
    public void exTest() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Negatives not allowed: -1,-3");
        Calculator.add("1,-1\n-3");
    }
}
