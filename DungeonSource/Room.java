import java.util.Random;

public class Room {
	private HealingPotion healingPotion;
	private Pit pit;
	private Entrance entrance;
	private Exit exit;
	private Monster monster;
	private PillarOfOO pillar;
	private VisionPotion visionPotion;
	
	private final int x, y;
	
	
	public Room(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public void fill() {
		if (entrance != null || exit != null) {
			return;
		}
		int num = new Random().nextInt(4);
		if(num == 0) {
			this.healingPotion = new HealingPotion();
		}
		
		else if(num == 1) {
			this.pit = new Pit();
		}
		
		else if(num == 2){
			int MonsterNum = new Random().nextInt(4);
			
			MonsterFactory factory = new MonsterFactory();
			this.monster = factory.createMonster(MonsterNum);
		}
		
		else {
			int multipleItems = new Random().nextInt(2);
			
			if(multipleItems == 0) {
				this.healingPotion = new HealingPotion();
				this.pit = new Pit();
			}
			
			else if(multipleItems == 1) {
				this.visionPotion = new VisionPotion();
				
			}
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
	
	public void printBottomRow() {
		if (y == 4) {
			System.out.print("* * ");
		}
	}
	
	
	
	public String getContainingObject() {
		if(this.entrance != null) {
			return "I";
		}
		
		else if(this.exit != null) {
			return "O";
		}
		
		else if(hasMixedItems()) {
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
		return (this.healingPotion != null && this.pit != null) || (this.visionPotion != null);
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
	}

	public VisionPotion getVisionPotion() {
		return visionPotion;
	}

	public void setVisionPotion(VisionPotion visionPotion) {
		this.visionPotion = visionPotion;
	}
	public Entrance getEntrance() {
		return entrance;
	}

	public void setEntrance(Entrance entrance) {
		this.entrance = entrance;
	}

	public Exit getExit() {
		return exit;
	}

	public void setExit(Exit exit) {
		this.exit = exit;
	}
	public Pit getPit() {
		return pit;
	}

	public void setPit(Pit pit) {
		this.pit = pit;
	}

}