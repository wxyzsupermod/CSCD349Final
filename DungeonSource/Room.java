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
		int num = new Random().nextInt(6);
		
		this.x = x;
		this.y = y;
		
		if(num == 0) {
			this.healingPotion = new HealingPotion();
		}
		
		else if(num == 1) {
			this.pit = new Pit();
		}
		
		else if(num == 2) {
			this.entrance = new Entrance();
		}
		
		else if(num == 3) {
			this.exit = new Exit();
		}
		
		else if(num == 4){
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
			System.out.print("* * *");
		} else {
			System.out.print("* - *");
		}
	}
	
	public void printMiddleRow() {
		String left, right;
		
		if (x == 0) {
			left = "*";
		} else {
			left = "|";
		}
		if (x == 4) {
			right = "*";
		} else {
			right = "|";
		}
		System.out.print(left + " " + getContainingObject() + " " + right);
	}
	
	public void printBottomRow() {
		if (y == 4) {
			System.out.print("* * *");
		} else {
			System.out.print("* - *");
		}
	}
	
	
	
	public String getContainingObject() {
		if((this.healingPotion != null && this.pit != null) || (this.visionPotion != null)) {
			return "M";
		}
		
		else if(this.healingPotion != null) {
			return "H";
		}
		
		else if(this.pit != null) {
			return "P";
		}
		
		else if(this.entrance != null) {
			return "I";
		}
		
		else if(this.exit != null) {
			return "O";
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
	
	public String toString() {
		String containingObject = "";
		String roomDesignEW;
		String roomDesignNS;
		
		if((this.healingPotion != null && this.pit != null) || (this.visionPotion != null)) {
			containingObject = " M ";
		}
		
		else if(this.healingPotion != null) {
			containingObject =  " H ";
		}
		
		else if(this.pit != null) {
			containingObject =  " P ";
		}
		
		else if(this.entrance != null) {
			containingObject =  " I ";
		}
		
		else if(this.exit != null) {
			containingObject =  " O ";
		}
		
		else if(this.monster != null) {
			containingObject =  " X ";
		}
		
		else if(this.visionPotion != null) {
			containingObject = " V ";
		}
		
		
		
		else {
			containingObject =  "E";
		}
		
		roomDesignNS = "\n" + " ***" + "\n";
		roomDesignEW = "|" + containingObject + "|";
		
		return roomDesignNS + roomDesignEW + roomDesignNS;
		
	}
	
	
}
