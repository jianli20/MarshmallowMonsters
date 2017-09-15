package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;

public class MonsterController
{

	
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
		
		myScanner.close();
		
	}
}

 