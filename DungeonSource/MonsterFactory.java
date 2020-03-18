public class MonsterFactory {
	public Monster createMonster(int choice) {
		if(choice == 0) {
			Monster m = new Gremlin();
			m.setAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Kris"));
			return m;
		} else if(choice == 1) {
			Monster m = new Ogre();
			m.setAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Slow Club"));
			return m;
		} else if(choice == 2) {
			Monster m = new Skeleton();
			m.setAttackStrategy(FlyweightFactory.getInstance().getAttackFlyweight("Rusty Blade"));
			return m;
		} else {
			throw new IllegalArgumentException("Unknown choice: " + choice);
		}
	}
}
