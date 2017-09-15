package monster.model;

public class MarshmallowMonster
{
	//Declaration section of data members
	
	private String name;
	private int eyeCount;
	private int armCount;
	private double tentacleAmount;
	private boolean hasBloop;
	
	public MarshmallowMonster()
	{
		//initializes everything to 0, false or null.
	}
	
	public MarshmallowMonster(String name, int eyeCount, int arms, int tenaclecount, boolean hasBloop)
	{
		this.name = name;
		this.eyeCount = eyeCount;
		this.armCount = arms;
		this.tentacleAmount = tentacleAmount;
		this.hasBloop = hasBloop;
	}
	
	public String toString()
	{
		String description = "I am a monster, my name is " + name + ", I have" + eyeCount + "eyes and only" ;
		description += tentacleAmount +  "tentacles but I have" + armCount + " arms!." + hasBloop + " tells you";
		description += " if I have a bloop";
		return description;
	}
}
