package is.ru.stringcalculator;

import java.util.ArrayList;


public class Calculator {

	static ArrayList<String> numbersList = new ArrayList<String>();


	public static int add(String text)
	{
		numbersList.clear();
		if (text.equals("")) 
		{
			return 0;
		}
		else
		{
			if(text.contains(","))
			{
				String numbers[] = text.split(",");
				toArrayList(numbers);
				numberListNewLineSplit();
				return sum(numbersList);
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
	private static int sum(ArrayList <String> numbers)
	{
		int total = 0;
		for(String number : numbers)
		{
			total += stringToInt(number);
		}
		return total;
	}
	private static void toArrayList(String[] numbers)
	{
		for(String number : numbers)
		{
			numbersList.add(number);
		}
	}
	private static void numberListNewLineSplit()
	{
		for(int i = 0; i < numbersList.size(); i++)
		{
			if(numbersList.get(i).contains("\n"))
			{
				String temp[] = numbersList.get(i).split("\n");
				if(temp.length == 1)
				{								
					numbersList.set(i, temp[0]);							
				}
				else if(temp.length == 2)
				{
					numbersList.set(i, temp[0]);
					numbersList.add(temp[1]);	
				}
				else
				{
					numbersList.remove(i);
				}
			}
		}
	}
}