
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
		
		else if( choice == 4) {
			return new Cyclops();
		}
		else if( choice == 5) {
			return new Cerberus();
		}
		else if( choice == 6){
			return new Minotaur();
		}
		else {
			return null;
		}
	}

}
