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

    public void decimalNumbersReturnSum() throws Exception {
        assertEquals(calculator.calculate("1.2,2.3"), 3.50);
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeInputReturnsException() throws Exception {
        calculator.calculate("-1");
    }

    public void ignoreNumbersGreaterThan1000() throws Exception {
        assertEquals(calculator.calculate("10,10,1000"), 20);
    }

    public void twoNumbersReturnSubtract() {
        assertEquals(calculator.calculateSubtract("1,1"), 0);
    }

    public void threeNumbersReturnSubtract() {
        assertEquals(calculator.calculateSubtract("4,2,-3"), 5.00);
    }

    public void decimalNumbersReturnSubtract() {
        assertEquals(calculator.calculateSubtract("3.2,1.3"), 1.90);
    }

    public void twoNumbersReturnDivision() {
        assertEquals(calculator.calculateDivision("4,3"), 1.33);
    }

    public void twoDecimalNumbersReturnDivision() {
        assertEquals(calculator.calculateDivision("4.5,1.3"), 3.46);
    }

    public void twoNumbersReturnMultiplication() {
        assertEquals(calculator.calculateMultiplication("2,5"), 10);
    }

    public void twoDecimalNumbersReturnMultiplication() {
        assertEquals(calculator.calculateMultiplication("1.2,2.3"), 2.76);
    }

    public void numberReturnPower() {
        assertEquals(calculator.calculatePower("2,3"), 8);
    }

    public void numberExponentZeroReturnPower() {
        assertEquals(calculator.calculatePower("3,0"), 1);
    }

    public void numberBaseZeroReturnPower() {
        assertEquals(calculator.calculatePower("0,3"), 0);
    }

    public void decimalNumberReturnPower() {
        assertEquals(calculator.calculatePower("1.2,1.2"), 1.24);
    }

    public void decimalNumberExponentZeroReturnPower() {
        assertEquals(calculator.calculatePower("2,1.2"), 2.3);
    }

    public void decimalBaseZeroReturnPower() {
        assertEquals(calculator.calculatePower("0.01,3"), 0);
    }
}