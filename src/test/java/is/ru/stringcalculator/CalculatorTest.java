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

	@Test
	public void testMultipleNumber() {
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testNewLine(){
		assertEquals(6, Calculator.add("1\n2,3"));
		assertEquals(1, Calculator.add("1,\n"));
		assertEquals(2, Calculator.add("\n,1,1\n"));
		assertEquals(2, Calculator.add("\n,1,\n1"));
	}

	@Test
	public void testNegetiveAdd(){
		try
		{
			assertEquals(-1 , Calculator.add("-1,2"));
			assertEquals(-1 , Calculator.add("2,-4,3,-5"));
		}
		catch(Exception e)
		{
			final String expected = "Negatives not allowed: -1";
        	assertEquals(expected, e.getMessage());
		}

		try
		{
			assertEquals(-1 , Calculator.add("2,-4,3,-5"));
		}
		catch(Exception e)
		{
			final String expected = "Negatives not allowed: -4,-5";
        	assertEquals(expected, e.getMessage());
		}
	}

	@Test
	public void testBiggerThenThousand(){
		assertEquals(2, Calculator.add("1001,2"));
	}

	@Test
	public void testDifferentDelimiter(){
		assertEquals(4, Calculator.add("//;2;2"));
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
}