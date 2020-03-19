package dungeon;
public class HeroFactory {
	public Hero createHero(int choice) {
		Hero h;
		if(choice == 1) {
			h = new Warrior();
			h.setAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Mighty Sword"));
			h.setSpecialAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Crushing Blow"));
		} else if(choice == 2) {
			h = new Sorceress();
			h.setAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Fireball Spell"));
			h.setSpecialAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Increase Hit Points"));
		} else if(choice == 3) {
			h = new Thief();
			h.setAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Dagger Throw"));
			h.setSpecialAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Surprise Attack"));
			
		
		}
		else if(choice == 4) {
			h = new ElfWizard();
			h.setAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Increase Hit Points"));
			h.setSpecialAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Surprise Attack"));
		}
		else if(choice == 5) {
			h = new Gandalf();
			h.setAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Fireball Spell"));
			h.setSpecialAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Surprise Attack"));
		}
		else if(choice == 6) {
			h = new Sorcerer();
			h.setAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Fireball Spell"));
			h.setSpecialAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Surprise Attack"));
		}
		else {
			throw new IllegalArgumentException("Choice " + choice + " is invalid");
		}
		return h;
	}
}
