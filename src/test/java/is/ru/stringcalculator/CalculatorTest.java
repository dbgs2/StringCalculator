package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public calss CalculatorTest {

	@Test
	public void testEmtryString() {
		assertEquals(0, Calculator.add(""));
	}
}