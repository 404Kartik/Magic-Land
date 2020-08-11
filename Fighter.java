public class Fighter extends GameCharacter 
{
	private static int FIGHTER_MAX_HP = 10; 
	
	public Fighter()
	{
		super.CHAR_MAX_HP = FIGHTER_MAX_HP;		
	}

	@Override
	public void randGen(boolean areHitPointsMaxed) 
	{	
		// HitPoints
		if (areHitPointsMaxed)
			this.hitPoints = FIGHTER_MAX_HP;
		else
			hitPoints = rollDice(FIGHTER_MAX_HP);
		
		// STR, INT, WIS
		strength = rollDice(6) + rollDice(6) + rollDice(6) + 1;
		intelligence = rollDice(6) + rollDice(6) + rollDice(6);
		wisdom = rollDice(6) + rollDice(6) + rollDice(6);
		
		int i,j;
		i = rollDice(GameCharacter.howManyNames)-1;
		j = rollDice(GameCharacter.howManyNames)-1;
		name = randomNames[i][j];
	}
	
	@Override
	public void display()
	{
		System.out.println("Class:"+ "\t \t"+"Fighter");
		super.display();
	}

}
