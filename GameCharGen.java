import java.util.Scanner;

public class GameCharGen 
{

	public static void main(String[] args) throws NoGameCharacterFoundException 
	{
		GameCharGenModel myCharGen = new GameCharGenModel();
		Scanner menuInput = new Scanner(System.in);

		while (true) 
		{
			System.out.println("*** WoK GameCharGen Menu***");
			System.out.println("Create Wizard \t\t WZ");
			System.out.println("Create Fighter \t\t FG");
			System.out.println("Create Cleric \t\t CL");
			System.out.println("Lowest HP Character \t LHC");
			System.out.println("Sort Character Asc. \t SCA");
			System.out.println("Sort Character Desc. \t SCD");
			System.out.println("Display Characters \t DC");
			System.out.println("Exit Program \t\t EX");
			System.out.print("Enter Selection:");
			String choice = menuInput.nextLine();
			if (choice.equalsIgnoreCase("WZ")) 
			{
				Wizard WZ = new Wizard();
				WZ.randGen(true);
				myCharGen.addGameCharacter(WZ);
				WZ.display();
			} 
			else if (choice.equalsIgnoreCase("FG")) 
			{
				Fighter FG = new Fighter();
				FG.randGen(false);
				myCharGen.addGameCharacter(FG);
				FG.display();
			}
			else if (choice.equalsIgnoreCase("CL")) 
			{
				Cleric CL = new Cleric();
				CL.randGen(true);
				myCharGen.addGameCharacter(CL);
				CL.display();
			}
			else if (choice.equalsIgnoreCase("EX")) 
			{

				menuInput.close();
				System.out.println("***************");
				System.out.println("Quitting now...");
				System.out.println("***************");
				System.exit(0);
			}
			else if (choice.equalsIgnoreCase("LHC")) 
			{

				int lowest_hp_index = myCharGen.getLowestHPGameCharacter();
				System.out.printf(lowest_hp_index == -1 ? "" : "%s %d %s", "\nGame Character at", lowest_hp_index,"has the Lowest Hit Points\n\n");
				if(lowest_hp_index!=-1)
					myCharGen.gameCharacterAt(lowest_hp_index).display();

			}
			else if (choice.equalsIgnoreCase("SCA")) 
			{
				myCharGen.sortGameCharacterWisdom(true);

			}
			else if (choice.equalsIgnoreCase("SCD")) 
			{
				myCharGen.sortGameCharacterWisdom(false);
			}
			else if (choice.equalsIgnoreCase("DC")) 
			{
				for (int i = 0; i < myCharGen.getNumCharacters(); i++) 
				{
					myCharGen.gameCharacterAt(i).display();
					System.out.println();
				}
			} 
			else 
			{
				System.out.println("Unrecognised Command");
			}

		}

	}
	
}