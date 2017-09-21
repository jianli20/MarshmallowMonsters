package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;

public class MonsterController
{
	private MonsterDisplay popup;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();
	}

	public void start()
	{
		MarshmallowMonster basic = new MarshmallowMonster();
//		System.out.println(basic);
		popup.displayText(basic.toString());
		MarshmallowMonster Jimmothy = new MarshmallowMonster("Silly Jimmothy Monster", 8, 4, .5, false);
//		System.out.println(Jimmothy);
		popup.displayText(Jimmothy.toString());
//		System.out.println("I am feeling hungry, I am going to eat one of Jimmothy's arms");
		popup.displayText("I am feeling hungry, I am going to eat one of Jimmothy's arms");
		Jimmothy.setarmCount(Jimmothy.getarmCount() - 1);
//		System.out.println(Jimmothy);
		popup.displayText(Jimmothy.toString());
		
		interactWithMonster(Jimmothy);
	}
	
	private void interactWithMonster(MarshmallowMonster currentMonster)

	{
		Scanner myScanner = new Scanner(System.in);
//		System.out.println(currentMonster.getName() + " wants to know how many eyes you want to eat, please type in how many ");
		int consumed =0;
		String response = popup.getResponse(currentMonster.getName() + " wants to know how many eyes you want to eat, please type in how many");
		
		if(isValidInteger(response))
		{
			consumed = Integer.parseInt(response);
		}
		
//		int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
//		System.out.println(currentMonster);		
//		System.out.println("How many arms are you interested in eating?, I have "  + currentMonster.getarmCount());
		//consumed = myScanner.nextInt();
		
		popup.displayText(currentMonster.toString());
		popup.getResponse(currentMonster.getName() + " How many arms are you interested in eating?, I have "  + currentMonster.getarmCount());
		
//		int armEat = myScanner.nextInt();
		int armEat = 0;
		if(isValidInteger(response))
		{
			consumed = Integer.parseInt(response);
		}
		
		if (armEat == 0)
		{
//			System.out.println("Not hungry?  so sad.....");
			popup.displayText("Not hungry?   so sad.....");
		}
		else if(armEat < 0)
		{
//			System.out.println("Math is hard for you- it's impossible to eat a negative amount");
			popup.displayText("Math is hard for you- it's impossible to eat a negative amount");
		}
		else if(armEat - currentMonster.getarmCount() > 0)
		{
//			System.out.println("You are not allowed to eat more than exist on me :(");
			popup.displayText("You are not allowed to eat more than exist on me :(");
		}
		else
		{
//			System.out.println("OK, now I have this many arms " + currentMonster.getarmCount());
			popup.displayText("Ok, now I have this many arms " + currentMonster.getarmCount());
		}
		
		double food = 0.0;
		String tentacleResponse = popup.getResponse("");
		if(isValidDouble(tentacleResponse))
		{
			food = Double.parseDouble(tentacleResponse);
		}
		if(food == currentMonster.getTentacleAmount())
		{
			popup.displayText("You ate all my tentacles!");
		}
		
		popup.displayText("Hi there ready to play???");
		String answer1 = popup.getResponse("What is the air speed of a coconut laden swallow?");
		System.out.println(answer1);
		
		
		myScanner.close();
		
	}

	//Helper methods
	private boolean isValidInteger(String sample)
	{
		boolean valid = false;
		
		try
		{
			Integer.parseInt(sample);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to input an int," + sample + "is not valid.");
		}
		
		return valid;
	}

	private boolean isValidDouble(String sampleDouble)
	{
		boolean valid = false;
		
		try
		{
			Double.parseDouble(sampleDouble);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to type in a double - " + sampleDouble + " is not a valid answer.");
		}
		return valid;
	}


	private boolean isValidBoolean(String sampleBoolean)
	{
		boolean valid = false;
		
		try
		{
			Boolean.parseBoolean(sampleBoolean);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("Type in a boolean value" + sampleBoolean + " does not count.");
		}
		return valid;
	}
}


 