
public class Minotaur extends Monster {

	    public Minotaur()
		{
			super("Max the Minotaur", 130, 4, .5, .2, 25, 45, 40, 55);
			//need to add attack to the ctr
		}
	    @Override
		public void attack(DungeonCharacter opponent)
		{
			System.out.println(getName() + " slowly swings a club toward's " +
								opponent.getName() + ":");
			super.attack(opponent);
		}
	}
