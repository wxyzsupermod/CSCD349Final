import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private int numTurns;
	private static Scanner Keyboard = new Scanner(System.in);
	private int posX;
	private int posY;
	private int pillars;
	private ArrayList<VisionPotion> visionPotions;
	private ArrayList<HealingPotion> healingPotions;
	
	private void visitRoom(Room room) {
		if(room.getHealingPotion() != null) {
			System.out.println("NEW ITEM: You picked up a healing potion!");
			this.healingPotions.add(room.getHealingPotion());
			room.setHealingPotion(null);
		} else if(room.getPillarOfOO() != null) {
			System.out.println("NEW ITEM: You picked up the " + room.getPillarOfOO().toString() + " pillar!");
			this.pillars = this.pillars + 1;
			room.setPillarOfOO(null);
		} else if(room.getVisionPotion() != null) {
			System.out.println("NEW ITEM: You picked up a vision potion!");
			this.visionPotions.add(room.getVisionPotion());
			room.setVisionPotion(null);
		} else if(room.getMonster() == null) {
			if(room.getPit() != null) {
				System.out.println(this.getName() + " fell down a pit!");
				super.subtractHitPoints(5); // call from super because we don't want to block damage from falling down a pit
			}
		}
	}
	
	private Room movePlayer(int x, int y) {
		Dungeon d = DungeonAdventure.getDungeon();
		if(d.locationIsValid(y, x)) {
			posX = x;
			posY = y;
			Room room = d.getRoom(y, x);
			visitRoom(room);
			return room;
		} else {
			System.out.println("Cannot Move in that direction");
		}
		return null;
	}
	
	public Room moveRight() {
		return movePlayer(posX+1, posY);
	}
	
	public Room moveLeft() {
		return movePlayer(posX-1, posY);
	}

	public Room moveUp() {
		return movePlayer(posX, posY-1);
	}

	public Room moveDown() {
		return movePlayer(posX, posY+1);
	}
	
	public void drinkHealingPotion() {
		if (this.getHealingPotions() > 0) {
			HealingPotion p = this.healingPotions.get(0);
			this.healingPotions.remove(0);
			p.affectCharacter(this);
		} else {
			System.out.println("You don't have any healing potions to drink.");
		}
	}

	public void drinkVisionPotion() {
		if (this.getVisionPotions() > 0) {
			VisionPotion p = this.visionPotions.get(0);
			this.visionPotions.remove(0);
			p.affectCharacter(this);
		} else {
			System.out.println("You don't have any vision potions to drink.");
		}
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
		return visionPotions.size();
	}

	public int getHealingPotions() {
		return healingPotions.size();
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
	healingPotions = new ArrayList<HealingPotion>();
	visionPotions = new ArrayList<VisionPotion>();
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
	@Override
	public String toString() {
		return this.getName() + " has " + this.getHitPoints() + " Hit Points " + this.getHealingPotions() + " Healing Potions "
				+ this.getVisionPotions() + " Vision Potions " + this.getPillars() + " Pillars Of OO " ;
	}

}//end Hero class