import java.util.Random;

public class Room {
	private HealingPotion healingPotion;
	private Pit pit;
	private boolean isEntrance;
	private boolean isExit;
	private Monster monster;
	private PillarOfOO pillar;
	private VisionPotion visionPotion;
	
	public final int x, y;
	
	
	public Room(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		isEntrance = false;
		isExit = false;
		
	}
	
	public void fill() {
		if (isEntrance || isExit) {
			return;
		}
		Random rand = new Random();
		if(rand.nextDouble() < 0.1d) {
			this.healingPotion = new HealingPotion();
		}
		if(rand.nextDouble() < 0.1d) {
			this.visionPotion = new VisionPotion();
		}
		if(rand.nextDouble() < 0.1d) {
			this.pit = new Pit();
		}
		if(rand.nextDouble() < 0.1d){
			MonsterFactory factory = new MonsterFactory();
			this.monster = factory.createMonster(rand.nextInt(4));
		}
	}
	
	
	public void printTopRow() {
		if (y == 0) {
			System.out.print("* * ");
		} else {
			System.out.print("* - ");
		}
	}
	
	public void printMiddleRow() {
		String left;
		
		if (x == 0) {
			left = "*";
		} else {
			left = "|";
		}
		System.out.print(left + " " + getContainingObject() + " ");
	}
	
	@Override
	public String toString() {
		return "* " + (y == 0 ? "*" : "-") + " *\n" + (x == 0 ? "*" : "|") + " " + getContainingObject() + " " + (x == DungeonAdventure.getDungeon().roomsWidth - 1 ? "*" : "|") + "\n* " + (y == DungeonAdventure.getDungeon().roomsHeight - 1 ? "*" : "-") + " *";
	}
	
	
	public String getContainingObject() {
		if(this.isEntrance) {
			return "I";
		}
		
		else if(this.isExit) {
			return "O";
		}
		
		else if(this.hasMixedItems()) {
			return "M";
		}
		
		else if(this.healingPotion != null) {
			return "H";
		}
		
		else if(this.pit != null) {
			return "P";
		}
		
		else if(this.monster != null) {
			return "X";
		}
		
		else if(this.visionPotion != null) {
			return "V";
		}
		else {
			return "E";
		}
		
	}
	
	public boolean hasMixedItems() {
		return (this.healingPotion == null ? 0 : 1) + (this.visionPotion == null ? 0 : 1) + (this.pit == null ? 0 : 1) > 1;
	}
	
	public HealingPotion getHealingPotion() {
		return healingPotion;
	}

	public void setHealingPotion(HealingPotion healingPotion) {
		this.healingPotion = healingPotion;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public PillarOfOO getPillarOfOO() {
		return pillar;
	}

	public void setPillarOfOO(PillarOfOO pillar) {
		this.pillar = pillar;
		clearItems();
	}

	public VisionPotion getVisionPotion() {
		return visionPotion;
	}

	public void setVisionPotion(VisionPotion visionPotion) {
		this.visionPotion = visionPotion;
	}
	public boolean getEntrance() {
		return isEntrance;
	}

	public void setEntrance(boolean e) {
		this.isEntrance = e;
		clearItems();
	}

	public boolean getExit() {
		return isExit;
	}

	public void setExit(boolean e) {
		this.isExit = e;
		clearItems();
	}
	
	public Pit getPit() {
		return pit;
	}

	public void setPit(Pit pit) {
		this.pit = pit;
	}
	
	public void clearItems() {
		this.healingPotion = null;
		this.visionPotion = null;
		this.pit = null;
		this.monster = null;
	}

}