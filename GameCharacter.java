import java.util.Random;

public abstract class GameCharacter 
{
	protected int CHAR_MAX_HP = 0;
	protected String name;
	protected int hitPoints;
	protected int strength;
	protected int intelligence;
	protected int wisdom;
	protected String[][] randomNames = { { "Arthur", "Achilles", "Hector" }, { "Conan", "Caesar", "Lancilot" },
			{ "Harry P.", "Felonius", "Gandalf" } };
	protected static int howManyNames = 3;

	public abstract void randGen(boolean areHitPointsMaxed);

	public int getStrength()
    {
		return strength;
	}

	public int getIntelligence() 
	{
		return intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	protected int rollDice(int numFaces) 
	{
		Random dice = new Random();
		// Rolls a numFaces-sided dice
		return (1 + dice.nextInt(numFaces));
	}

	public void display() 
	{
		System.out.println("Name: " + "\t \t" + name);
		System.out.println("Hit Points: " + "\t" + hitPoints);
		System.out.println("Strength: " + "\t" + strength);
		System.out.println("Intelligence: " + "\t" + intelligence);
		System.out.println("Wisdom: " + "\t" + wisdom);
	}

}