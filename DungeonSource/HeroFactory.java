
public class HeroFactory {
	
	public Hero createHero(int choice) {
		
		if(choice == 1) {
			return new Sorceress();
		}
		
		else if(choice == 2) {
			return new Thief();
		}
		
		else if(choice == 3) {
			return new Warrior();
		}
		else if(choice == 4) {
			return new ElfWizard();
		}
		else if( choice == 5) {
			return new Gandalf();
			
		}
		else if( choice == 6) {
			return new Sorcerer();
		}
		
		else {
			return null;
		}
	}

}
