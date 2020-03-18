import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero extends DungeonCharacter {
	private double chanceToBlock;
	private int numTurns;
	private int pillars;
	private ArrayList<VisionPotion> visionPotions;
	private ArrayList<HealingPotion> healingPotions;
	private Attack specialAttackStrategy;
	
	public Hero(String name, int hitPoints, int attackSpeed,
			double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock)
	{
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		healingPotions = new ArrayList<HealingPotion>();
		visionPotions = new ArrayList<VisionPotion>();
	}

	@Override
	void visitRoom(Room room) {
		super.visitRoom(room);
		if(room.getExit() && this.getPillars() == 4) {
			// NIM!
			DungeonAdventure.finish();
		} else if(room.getMonster() != null) {
			DungeonAdventure.battle(room.getMonster());
		} else if(room.getHealingPotion() != null) {
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
				room.getPit().damageCharacter(this);
			}
		}
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
	
	public void getExtraTurn() {
		System.out.println(getName() + " gets an additional turn.");
		this.numTurns++;
	}


	public boolean canDefend() {
		return Math.random() <= chanceToBlock;
	}
	
	public void subtractHitPoints(int hitPoints, boolean canDefend) {
		if (canDefend && canDefend()) {
			System.out.println(this.getName() + " BLOCKED the damage!");
		} else {
			subtractHitPoints(hitPoints);
		}
	}

	public void battle(DungeonCharacter opponent, Scanner kb) {
	    numTurns = Math.max(1, this.getAttackSpeed()/opponent.getAttackSpeed());
		System.out.println("The total number of turns this round is: " + numTurns);
		int choice;
		do {
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Special Ability");
		    System.out.print("Choose an option: ");
		    choice = kb.nextInt();
		    if(choice == 1) {
		    	attack(opponent);
		    } else if(choice == 2) {
		    	specialAttack(opponent);
		    } else {
		    	System.out.println("invalid choice!");
		    }
			this.setNumTurns(this.getNumTurns()-1);
			if (this.getNumTurns() > 0) {
			    System.out.println("Number of turns remaining is: " + this.getNumTurns());
			}
		} while(this.getNumTurns() > 0);
	}
	
	public void setSpecialAttackStrategy(Attack attackStrategy) {
		if (attackStrategy != null) {
			specialAttackStrategy = attackStrategy;
		} else {
			throw new IllegalArgumentException("Cannot set attack strategy to null");
		}
	}
	
	public void specialAttack(DungeonCharacter opponent) {
		if (specialAttackStrategy != null) {
			specialAttackStrategy.attack(this, opponent);
		} else {
			throw new IllegalStateException("This hero does not have a specal ability. Set it with Hero.setSpecialAttackStrategy()");
		}
	}
}
