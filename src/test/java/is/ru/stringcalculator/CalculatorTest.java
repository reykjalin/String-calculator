package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CalculatorTest {
    @Test
    public void emptyTest(){
        assertEquals(0, Calculator.add(""));
    }
}
