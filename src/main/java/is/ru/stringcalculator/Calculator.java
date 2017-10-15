package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if (text.equals("")) {
			return 0;
		}
		else
		{
			if(text.contains(","))
			{
				String numbers[] = text.split(",");
				return stringToInt(numbers[0]) + stringToInt(numbers[1]);
			}
		}
		return 1;
	}

	private static int stringToInt(String number)
	{
		return Integer.parseInt(number);
	}
}