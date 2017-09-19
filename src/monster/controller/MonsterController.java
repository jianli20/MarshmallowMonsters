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
		System.out.println(basic);
		MarshmallowMonster Jimmothy = new MarshmallowMonster("Silly Jimmothy Monster", 8, 4, .5, false);
		System.out.println(Jimmothy);
		System.out.println("I am feeling hungry, I am going to eat one of Jimmothy's arms");
		Jimmothy.setarmCount(Jimmothy.getarmCount() - 1);
		System.out.println(Jimmothy);
		
		interactWithMonster(Jimmothy);
	}
	
	private void interactWithMonster(MarshmallowMonster currentMonster)
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.println(currentMonster.getName() + " wants to know how many eyes you want to eat, please type in how many ");
		int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		System.out.println(currentMonster);
	
	
		System.out.println(currentMonster.getName() + " wants to know how many tentacles you want eat, please type in how many ");
		int Tentacleconsumed = myScanner.nextInt();
		currentMonster.setTentacleAmount(currentMonster.getTentacleAmount() - Tentacleconsumed);
		System.out.println(currentMonster);
		
		System.out.println("How many arms are you interested in eating?, I have "  + currentMonster.getarmCount());
		//consumed = myScanner.nextInt();
		int armEat = myScanner.nextInt();
		
		if (armEat == 0)
		{
			System.out.println("Not hungry?  so sad.....");
		}
		else if(armEat < 0)
		{
			System.out.println("Math is hard for you- it's impossible to eat a negative amount");
		}
		else if(armEat - currentMonster.getarmCount() > 0)
		{
			System.out.println("You are not allowed to eat more than exist on me :(");
		}
		else
		{
			System.out.println("OK, now I have this many arms " + currentMonster.getarmCount());
		}
		
		System.out.println("How many eyes would you like to eat?");
		int eyeEat = myScanner.nextInt();
		
		if (eyeEat == 0)
		{
			System.out.println("No eyes today? ");
		}
		else if(eyeEat < 0)
		{
			System.out.println("You can't eat negative amounts!" );
		}
		else if (eyeEat - currentMonster.getEyeCount() > 0)
		{
			System.out.println("haha DUMB");
		}
		else
		{
			currentMonster.setEyeCount(currentMonster.getEyeCount() - eyeEat);
			System.out.println("Now I have " + currentMonster.getEyeCount());
		}

		System.out.println("How many tentacles do you want to eat? I have " + currentMonster.getTentacleAmount());
		double food = myScanner.nextDouble();
		
		if(food == currentMonster.getTentacleAmount())
		{
			System.out.println("You ate all my tentacles!!!");
		}
		else
		{
			System.out.println("More likely");
		}
		
		popup.displayText("Hi there ready to play???");
		String answer = popup.getResponse("What is the air speed of a coconut laden swallow?");
		System.out.println(answer);
		
		
		myScanner.close();
		
	}
}

 