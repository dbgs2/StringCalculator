package is.ru.stringcalculator;

import java.util.ArrayList;


public class Calculator {

	private static ArrayList<String> numbersList = new ArrayList<String>();


	public static int add(String text)
	{
		numbersList.clear();
				
		if (text.equals("")) 
		{
			return 0;
		}
		else
		{	
			String delimiter = ",";
			if(text.contains("//"))
			{
				delimiter = text.substring(2,3);
				text = text.substring(3);
			}				
			if(text.contains(delimiter))
			{
				String numbers[] = text.split(delimiter);				
				toArrayList(numbers);
				numberListNewLineSplit();
				String negatives = negativesNumbers();
				negativesCheck(negatives);
	
				return sum(numbersList);
			}

			//return stringToInt(numbersList.get(0));
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
			if(stringToInt(number) <= 1000)
			{
				total += stringToInt(number);
			}			
		}
		return total;
	}
	private static int sum(ArrayList <String> numbers)
	{
		int total = 0;
		for(String number : numbers)
		{
			if(stringToInt(number) <= 1000)
			{
				total += stringToInt(number);
			}
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
				if(temp.length == 0)
				{
					numbersList.remove(i);
				}
				if(temp.length == 1)
				{
					numbersList.set(i, temp[0]);					
				}
				else if(temp.length == 2)
				{
					if(temp[0].isEmpty())
					{
						numbersList.set(i, temp[1]);						
					}
					else
					{
						numbersList.set(i, temp[0]);
						numbersList.add(temp[1]);						
					}
				}

			}
		}
	}
	private static String negativesNumbers()
	{
		String negativesNumbers = "";
		for(String number : numbersList)
		{					
			if(stringToInt(number) < 0)
			{
				if(negativesNumbers.equals(""))
				{
					negativesNumbers += number;
				}
				else
				{
					negativesNumbers += "," + number;
				}
			}
		}
		return negativesNumbers;
	}
	private static void negativesCheck(String negatives)
	{
		if(negatives != "")
		{
			throw new IllegalArgumentException("Negatives not allowed: " + negatives);
		}
	}
	
}