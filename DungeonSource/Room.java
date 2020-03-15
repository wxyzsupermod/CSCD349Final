import java.util.Random;

public class Room {

	private Monster monster;
   private DungeonEntity pit;
   private DungeonEntity door;
   private DungeonEntity healingPotion;
   private DungeonEntity visionPotion;
   private DungeonEntity pillarOfOO;
   
	public Room() {
		int num = new Random().nextInt(6);
		
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
      
      else if(num == 3){
         this.pillarOfOO = new PillarOfOO();
      }
      
      else if(num == 4){
         this.visionPotion = new VisionPotion();
      }
		
		else {
			int multipleItems = new Random().nextInt(2);
			
			if(multipleItems == 0) {
				this.healingPotion = new HealingPotion();
				this.pit = new Pit();
			}
			
			else if(multipleItems == 1) {
				this.door = new Door();
				this.visionPotion = new VisionPotion();
				
			}
		}
	}
	
	public String toString() {
		String containingObject = "";
		String roomDesignEW;
		String roomDesignNS;
		
		if((this.healingPotion != null && this.pit != null) 
         || (this.door != null && this.visionPotion != null)) {
			containingObject = " M ";
		}
		
		else if(this.healingPotion != null) {
			containingObject =  " H ";
		}
		
		else if(this.pit != null) {
			containingObject =  " P ";
		}
		
		else if(this.monster != null) {
			containingObject =  " X ";
		}
		
		else if(this.visionPotion != null) {
			containingObject = " V ";
		}
      
      else if(this.pillarOfOO != null){
         containingObject = " ||";
      }	
		
		else {
			containingObject =  " E ";
		}
		
		roomDesignNS = "\n" + " ***" + "\n";
		roomDesignEW = "|" + containingObject + "|";
		
		//return roomDesignNS + roomDesignEW + roomDesignNS;
      
      
      return containingObject;
		
	}
	
	
}
