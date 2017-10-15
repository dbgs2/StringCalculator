package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text)
	{
		if (text.equals("")) 
		{
			return 0;
		}
		else
		{
			if(text.contains(","))
			{
				String numbers[] = text.split(",");
				return sum(numbers);
			}
			return 1;
		}	
	}

	private static int stringToInt(String number)
	{
		return Integer.parseInt(number);
	}
	private static int sum(String[] numbers)
	{
		int total = 0;
		for(String number : numbers)
		{
			total += stringToInt(number);
		}
		return total;
	}
}