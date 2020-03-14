
public class MonsterFactory {
	
	public Monster createMonster(int choice) {
		if(choice == 1) {
			return new Gremlin();
		}
		
		else if(choice == 2) {
			return new Ogre();
		}
		
		else if(choice == 3) {
			return new Skeleton();
		}
		
		else {
			return null;
		}
	}

}
