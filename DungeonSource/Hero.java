import java.util.Scanner;

public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private int numTurns;
	private static Scanner Keyboard = new Scanner(System.in);
	private int posX;
	private int posY;
	private int pillars;
	private int visionPotions;
	private int healingPotions;

	public Room movePlayer(int y, int x, Dungeon d) {
		
		if(d.locationIsValid(x, y)) {
			posX = x;
			posY = y;
			d.getRoom(x, y);
			if(d.getRoom(x, y).getHealingPotion() != null) {
				this.healingPotions = this.healingPotions + 1;
				d.getRoom(x, y).setHealingPotion(null);
				return d.getRoom(x, y);
			}
			if(d.getRoom(x, y).getPillarOfOO() != null) {
				this.pillars = this.pillars + 1;
				d.getRoom(x, y).setPillarOfOO(null);
				return d.getRoom(x, y);
			}
			if(d.getRoom(x, y).getVisionPotion() != null) {
				this.visionPotions = this.visionPotions + 1;
				d.getRoom(x, y).setVisionPotion(null);
				return d.getRoom(x, y);
			}
			if(d.getRoom(x, y).getMonster() != null) {
				//Do Battle
				return d.getRoom(x, y);
			}
			if(d.getRoom(x, y).getPit() != null) {
				System.out.println(this.getName() + " Fell in a pit and took five damage");
				this.subtractHitPoints(5);
				return d.getRoom(x, y);
			}
		}
		else {
			System.out.println("Cannot Move in that direction");
			
		}
		return d.getRoom(posX, posY);
		
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPillars() {
		return pillars;
	}

	public void setPillars(int pillars) {
		this.pillars = pillars;
	}

	public int getVisionPotions() {
		return visionPotions;
	}

	public void setVisionPotions(int visionPotions) {
		this.visionPotions = visionPotions;
	}

	public int getHealingPotions() {
		return healingPotions;
	}

	public void setHealingPotions(int healingPotions) {
		this.healingPotions = healingPotions;
	}

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