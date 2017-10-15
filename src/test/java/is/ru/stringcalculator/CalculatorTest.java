package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEmtryString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testSingleNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumber() {
		assertEquals(3, Calculator.add("1,2"));
	}
}