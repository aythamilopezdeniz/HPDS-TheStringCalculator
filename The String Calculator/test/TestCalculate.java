import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Test
public class TestCalculate {
    private Calculator calculator;

    @BeforeTest
    public void init(){
        calculator = new Calculator();
    }

    public void emptyStringReturnsZero() throws Exception {
        assertEquals(calculator.calculate("0"), 0);
    }

    public void singleValueIsReplied() throws Exception {
        assertEquals(calculator.calculate("1"), 1);
    }

    public void twoNumbersCommaDelimitedReturnSum() throws Exception {
        assertEquals(calculator.calculate("1,2"), 3);
    }

    public void twoNumbersNewLineDelimitedReturnSum() throws Exception {
        assertEquals(calculator.calculate("1\n2"), 3);
    }

    public void threeNumbersDelimitedBothWayReturnSum() throws Exception {
        assertEquals(calculator.calculate("1,2,3"), 6);
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeInputReturnsException() throws Exception {
        calculator.calculate("-1");
    }

    public void ignoreNumbersGreaterThan1000() throws Exception {
        assertEquals(calculator.calculate("10,10,1000"), 20);
    }
}