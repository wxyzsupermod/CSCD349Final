import java.util.HashMap;

public class FlyweightFactory {
	private static FlyweightFactory instance;
	
	public static FlyweightFactory getInstance() {
		return instance;
	}
	
	
	private HashMap<String, Flyweight> flyweights;
	
	public FlyweightFactory() {
		if (instance != null)
			throw new IllegalStateException("Cannot create more than one FlyweightFactory");
		instance = this;
		flyweights = new HashMap<String, Flyweight>();
	}
	
	public void setFlyweight(String key, Flyweight fw) {
		flyweights.put(key, fw);
	}
	
	public Flyweight getFlyweight(String key) {
		if (flyweights.containsKey(key)) {
			return flyweights.get(key);
		} else {
			return null;
		}
	}
	
	
}
