
public class Cyclops extends Monster {

	    public Cyclops()
		{
			super("Cyclops the Impossible", 180, 1, .3, .2, 40, 40, 20, 70);
			//need to add attack

	    }//end constructor
	    @Override
		public void attack(DungeonCharacter opponent)
		{
			System.out.println(getName() + " slowly swings a mace towards " +
								opponent.getName() + ":");
			super.attack(opponent);

		}//end override of attack

}