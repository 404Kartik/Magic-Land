import java.util.Arrays;

public class GameCharGenModel
 {
    static public int NUM_CHARS_BLOCK = 500;
    final public int STRENGTH = 0;
    final public int INTELLIGENCE = 1;
    final public int WISDOM = 2;

    private int gameCharCount = 0;
    private GameCharacter[] randomGameChars = new GameCharacter[NUM_CHARS_BLOCK];

    /**
     * Returns the number of randomly-generated characters so far.
     * 
     * @return Number of randomly-generated characters.
     */
    public int getNumCharacters() 
    {
        return gameCharCount;
    }

    /**
     * Adds a character to the array of characters
     * 
     * @param c character to be added
     */
    public void addGameCharacter(GameCharacter c) 
    {
        if (gameCharCount >= randomGameChars.length) 
        {
            GameCharacter[] newRandomChars = Arrays.copyOf(randomGameChars,randomGameChars.length + GameCharGenModel.NUM_CHARS_BLOCK);
            randomGameChars = newRandomChars;
        }
        randomGameChars[gameCharCount] = c;
        gameCharCount++;
    }

    /**
     * Returns a character at a given index
     * 
     * @param idx Provided index
     * @return Character at a given index
     */
    public GameCharacter gameCharacterAt(int idx) 
    {
        if (idx < 0 || idx >= randomGameChars.length)
            throw new IndexOutOfBoundsException();

        return randomGameChars[idx];
    }

    /**
     * Finds a character with either maximum strength, intelligence or wisdom based
     * on the parameter passed.
     * 
     * @return Index of the character with lowest HP in the character array.
     * @throws NoGameCharacterFoundException
     */
    public int getLowestHPGameCharacter() throws NoGameCharacterFoundException 
    {
        int small_index = -1;
        try 
        {
            if (gameCharCount == 0) 
            {
                throw new NoGameCharacterFoundException("No Character Found in database");
            }
            else 
            {

                small_index = 0;
                int small = randomGameChars[0].hitPoints;

                for (int i = 1; i < gameCharCount; i++) 
                {
                    if (randomGameChars[i].hitPoints < small) 
                    {
                        small = randomGameChars[i].hitPoints;
                        small_index = i;
                    }

                }

            }

        } 
        catch (NoGameCharacterFoundException e) 
        {
            System.err.println(e);
        }
        
            return small_index;
        

    }

    public void sortGameCharacterWisdom(boolean ascending) throws NoGameCharacterFoundException
    {
        try 
        {
            if (gameCharCount == 0 || gameCharCount > NUM_CHARS_BLOCK) 
            {
                throw new NoGameCharacterFoundException("No Characters Found in database");
            } 
            else 
            {
                for (int i = 0; i < gameCharCount; i++) 
                {
                    int index_store = i;
                    for (int j = i + 1; j < gameCharCount; j++) 
                    {
                        if ((randomGameChars[j].wisdom < randomGameChars[index_store].wisdom) == ascending) 
                        {
                            index_store = j;
                        }
                    }
                    GameCharacter found_wisdom = randomGameChars[index_store];
                    randomGameChars[index_store] = randomGameChars[i];
                    randomGameChars[i] = found_wisdom;

                }
            }
        } 
        catch (NoGameCharacterFoundException e) 
        {
            System.err.println(e);
        }
       
    }

}