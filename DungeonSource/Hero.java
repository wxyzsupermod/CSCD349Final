import java.util.Scanner;

public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private int numTurns;
	private static Scanner Keyboard = new Scanner(System.in);

public double getChanceToBlock() {
	return chanceToBlock;
}


	public void setChanceToBlock(double chanceToBlock) {
		this.chanceToBlock = chanceToBlock;
	}


	public int getNumTurns() {
		return numTurns;
	}


	public void setNumTurns(int numTurns) {
		this.numTurns = numTurns;
	}


  public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	readName();
  }

 
  public void readName()
  {
		System.out.print("Enter character name: ");
		this.setName(Keyboard.nextLine());
  }//end readName method


  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method


public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(this.getName() + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}


	}//end method


	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = this.getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices

}//end Hero class