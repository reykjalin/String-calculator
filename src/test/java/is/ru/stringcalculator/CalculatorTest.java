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
    public void oneNumberTest() throws Exception {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void twoNumberTest() throws Exception {
        assertEquals(5, Calculator.add("2,3"));
    }

    @Test
    public void multipleNumbersTest() throws Exception {
        assertEquals(3, Calculator.add("1,2"));
        assertEquals(45, Calculator.add("1,2,3,4,5,6,7,8,9"));
        assertEquals(30, Calculator.add("2,2,2,2,2,5,5,1,1,1,1,1,2,3"));
    }

    @Test
    public void newLineTest() throws Exception {
        assertEquals(6, Calculator.add("1\n2,3"));
        assertEquals(15, Calculator.add("1\n2\n3,4\n5"));
    }

    @Test
    public void negativeNumberTest() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Negatives not allowed: -1");
        Calculator.add("-1,2\n3");
    }

    @Test
    public void multipleNegTest() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Negatives not allowed: -4,-5");
        Calculator.add("1,2,-4,3,5,-5");
    }

    @Test
    public void ignoreThousand() throws Exception {
        assertEquals(15, Calculator.add("1,2,3,4,5,100023"));
    }

    @Test
    public void customDelim() throws Exception {
        assertEquals(3, Calculator.add("//;\n1;2"));
    }
}
