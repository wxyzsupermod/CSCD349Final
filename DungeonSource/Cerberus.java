
public class Cerberus extends Monster{

	    public Cerberus(){
			super("Cerberus the strong", 150, 3, .4, .2, 40, 55, 35, 60);
			//need to add attack in ctr
	    }
	    @Override
		public void attack(DungeonCharacter opponent)
		{
			System.out.println(getName() + " slowly swings a fist at " +
								opponent.getName() + ":");
			super.attack(opponent);

		}
}