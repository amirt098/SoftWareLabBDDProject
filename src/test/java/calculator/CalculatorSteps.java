package calculator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorSteps {
    private Calculator calculator;
    private int value1;
    private int value2;
    private char operation;
    private double result;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals("Multiplication failed", 12, calculator.calculate(6, 2, '*'), 0.001);
    }

    @Test
    public void testDivide() {
        Assert.assertEquals("Division failed", 3, calculator.calculate(6, 2, '/'), 0.001);
    }

    @Test
    public void testExponentiation() {
        Assert.assertEquals("Exponentiation failed", 36, calculator.calculate(6, 2, '^'), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperator() {
        calculator.calculate(6, 2, '%');
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        calculator.calculate(6, 0, '/');
    }

    @Given("^I have a calculator$")
    public void iHaveACalculator() {
        calculator = new Calculator();
    }

    @Given("^Two input values, (\\d+) and (\\d+)$")
    public void twoInputValuesAnd(int arg0, int arg1) {
        value1 = arg0;
        value2 = arg1;
    }

    @When("^I ([*+/^]) the two values$")
    public void iOperateTheTwoValues(char operation) {
        this.operation = operation;
        result = calculator.calculate(value1, value2, this.operation);
    }

    @Then("^I expect the result (\\d+)$")
    public void iExpectTheResult(int expected) {
        Assert.assertEquals(expected, result, 0.001);
    }
}
