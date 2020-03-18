
public class AttackFlyweight {
	private static AttackFlyweight instance;
	
	public static AttackFlyweight getInstance() {
		return instance;
	}
	
	
	public AttackFlyweight() {
		if (instance != null)
			throw new IllegalStateException("Cannot create more than one AttackFlyweight");
		instance = this;
	}
	
	
}
