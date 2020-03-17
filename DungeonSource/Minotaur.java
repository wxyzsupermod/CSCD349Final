
public class Minotaur extends Monster implements Attack {

	    public Minotaur()
		{
			super("Max the Minotaur", 130, 4, .5, .2, 25, 45, 40, 55);
		}
	    @Override
		public void attack(DungeonCharacter opponent)
		{
			System.out.println(getName() + " slowly swings a club toward's " +
								opponent.getName() + ":");
			super.attack(opponent);
		}
	}
