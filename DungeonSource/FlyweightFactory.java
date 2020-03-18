import java.util.HashMap;

public class FlyweightFactory {
	private static FlyweightFactory instance;
	
	public static FlyweightFactory getInstance() {
		return instance;
	}
	
	private HashMap<String, Attack> attackFlyweights;
	
	public FlyweightFactory() {
		if (instance != null)
			throw new IllegalStateException("Cannot create more than one FlyweightFactory");
		instance = this;
		attackFlyweights = new HashMap<String, Attack>();
		
		attackFlyweights.put("Mighty Sword", new MightySword());
		attackFlyweights.put("Crushing Blow", new CrushingBlow());
		attackFlyweights.put("Fireball Spell", new FireballSpell());
		attackFlyweights.put("Increase Hit Points", new IncreaseHitPoints());
		attackFlyweights.put("Surprise Attack", new SurpriseAttack());
		attackFlyweights.put("Dagger Throw", new DaggerThrow());
		attackFlyweights.put("Kris", new Kris());
		attackFlyweights.put("Rusty Blade", new RustyBlade());
		attackFlyweights.put("Slow Club", new SlowClub());
	}
	
	public Attack getAttackFlyweight(String key) {
		if (attackFlyweights.containsKey(key)) {
			return attackFlyweights.get(key);
		} else {
			throw new IllegalStateException("There is no Attack flyweight associated with key \"" + key + "\"");
		}
	}
	
	
}
