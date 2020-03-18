
public class HeroFactory {

	public Hero createHero(int choice) {
		if(choice == 1) {
			return new Sorceress();
		} else if(choice == 2) {
			return new Thief();
		} else if(choice == 3) {
			return new Warrior();
		} else {
			throw new IllegalArgumentException("Choice " + choice + " is ");
		}
	}

}
