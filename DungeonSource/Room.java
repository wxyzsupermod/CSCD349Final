import java.util.Random;

public class Room {
	private DungeonEntity pit;
	private DungeonEntity door;
	private DungeonEntity healingPotion;
	private Monster monster;
   
	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public DungeonEntity getPit() {
		return pit;
	}

	public void setPit(DungeonEntity pit) {
		this.pit = pit;
	}

	public DungeonEntity getDoor() {
		return door;
	}

	public void setDoor(DungeonEntity door) {
		this.door = door;
	}


   public DungeonEntity getHealingPotion() {
	return healingPotion;
}

public void setHealingPotion(DungeonEntity healingPotion) {
	this.healingPotion = healingPotion;
}

public DungeonEntity getVisionPotion() {
	return visionPotion;
}

public void setVisionPotion(DungeonEntity visionPotion) {
	this.visionPotion = visionPotion;
}

public DungeonEntity getPillarOfOO() {
	return pillarOfOO;
}

public void setPillarOfOO(DungeonEntity pillarOfOO) {
	this.pillarOfOO = pillarOfOO;
}

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
