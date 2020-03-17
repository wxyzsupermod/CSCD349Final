
public class Ogre extends Monster implements Attack
{

    public Ogre()
	{
		super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50, 80);


    }//end constructor
    @Override
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " slowly swings a club toward's " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end Monster class