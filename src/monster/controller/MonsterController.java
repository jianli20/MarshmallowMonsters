package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.List;
import monster.view.MonsterDisplay;
import java.util.ArrayList;
import java.util.Scanner;

public class MonsterController
{
	private MonsterDisplay popup;
	private List<MarshmallowMonster> monsterList;
	

	// Created method
	public MonsterController()
	{
		popup = new MonsterDisplay();
		monsterList = new ArrayList<MarshmallowMonster>();
	}

	// Beginning pop ups
	public void start()
	{
		int count = 0; 
//		while (count < 10)
//		{
//			popup.displayText("Am I not the coolest??");
//			count +=2;
//		}
		
//		for(int loop = 0; loop < 10; loop +=1)
//		{
//			popup.displayText("This is loop number # " + (loop + 1) + " of 10.");
//		}
		
		
		
		MarshmallowMonster basic = new MarshmallowMonster();
//		System.out.println(basic);
		popup.displayText(basic.toString());
		MarshmallowMonster Jimmothy = new MarshmallowMonster("Jimmothy Monster", 8, 4, 1.5, false);
//		System.out.println(Jimmothy);
		popup.displayText(Jimmothy.toString());
//		System.out.println("I am feeling hungry, I am going to eat one of Jimmothy's arms");
		popup.displayText("I am feeling hungry, I am going to eat one of Jimmothy's arms");
		Jimmothy.setarmCount(Jimmothy.getarmCount() - 1);
//		System.out.println(Jimmothy);
		popup.displayText(Jimmothy.toString());
		
		monsterList.add(basic);
		monsterList.add(Jimmothy);

		
		interactWithMonster(Jimmothy);
	}
	
	// Methods used to interact with monster, gets user input
	private void interactWithMonster(MarshmallowMonster currentMonster)

	{
		Scanner myScanner = new Scanner(System.in);
		int consumed =0;
		String response = popup.getResponse(currentMonster.getName() + " wants to know how many eyes you want to eat, please type in how many");
		
		while(!isValidInteger(response))
		{
			popup.displayText("Wrong. Do better.");
			response = popup.getResponse("Type in a integer value!");
		}
		
		
		if(isValidInteger(response))
		{
			consumed = Integer.parseInt(response);
		}
		
		if(consumed == 0)
		{
			popup.displayText("Not hungry?");
		}
		else if(consumed < 0)
		{
			popup.displayText("Math is hard for you- it's impossible to eat a negative amount  No eating anymore.");
		}
		else if(consumed > currentMonster.getEyeCount())
		{
			popup.displayText("You are not allowed to eat more than exist on me :(. No eating anymore.");
		}
		else
		{
			currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
			popup.displayText("Ok, now I have this many arms " + currentMonster.getEyeCount());
		}
		
//		int consumed = myScanner.nextInt();
		
		popup.displayText(currentMonster.toString());
		popup.getResponse(currentMonster.getName() + " says how many arms are you interested in eating?, I have "  + currentMonster.getarmCount());
		
		int armEat = 0;
		
		while(!isValidInteger(response))
		{
			popup.displayText("Wrong. Do better.");
			response = popup.getResponse("Type in a integer value!");
		}
		
		if(isValidInteger(response))
		{
			armEat = Integer.parseInt(response);
		}
	
		if (armEat == 0)
		{
			popup.displayText("Not hungry?   so sad.....");
		}
		else if(armEat < 0)
		{
			popup.displayText("Math is hard for you- it's impossible to eat a negative amount. No eating anymore.");
		}
		else if(armEat > currentMonster.getarmCount())
		{
			popup.displayText("You are not allowed to eat more than exist on me :(. No eating anymore.");
		}
		else
		{
			currentMonster.setarmCount(currentMonster.getarmCount() - consumed);
			popup.displayText("Ok, now I have this many arms: " + currentMonster.getarmCount());
		}
		
		double food = 0.0;
		String tentacleResponse = popup.getResponse("How many tentacles are you intested in eating?, I have " + currentMonster.getTentacleAmount());
		
		while(!isValidInteger(response))
		{
			popup.displayText("Wrong. Do better.");
			response = popup.getResponse("Type in a integer value!");
		}
		
		if(isValidDouble(tentacleResponse))
		{
			food = Double.parseDouble(tentacleResponse);
		}
		if(food == currentMonster.getTentacleAmount())
		{
			popup.displayText("You ate all my tentacles!");
		}
		else
		{
			currentMonster.setTentacleAmount(currentMonster.getTentacleAmount() - consumed);
			popup.displayText("Ok, Now I have this many tentacles: " + currentMonster.getTentacleAmount());
		} 
		
			
		myScanner.close();
		
	}

	// Helper methods
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

	// Helper methods for double values
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

	// Helper methods for boolean values
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


 