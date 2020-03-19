package dungeon;

public class PillarOfOOFactory {
	private static PillarOfOOFactory instance;
	
	private int totalFactoriesCreated;
	
	public static PillarOfOOFactory getInstance() {
		return instance;
	}
	
	public PillarOfOOFactory() {
		if (instance != null) {
			throw new IllegalStateException("Cannot create more than one PillarOfOOFactory");
		}
		instance = this;
		
		totalFactoriesCreated = 0;
	}
	
	public PillarOfOO create() {
		if (totalFactoriesCreated >= 4) {
			throw new IllegalStateException ("Cannot create more than 4 PillarOfOO objects");
		}
		PillarOfOO p;
		if (totalFactoriesCreated == 0) {
			p = new PillarOfOO("Abstraction");
		} else if (totalFactoriesCreated == 1) {
			p = new PillarOfOO("Encapsulation");
		} else if (totalFactoriesCreated == 2) {
			p = new PillarOfOO("Inheritance");
		} else {
			p = new PillarOfOO("Polymorphism");
		}
		totalFactoriesCreated++;
		return p;
	}
	
	public boolean canCreate() {
		return totalFactoriesCreated < 4;
	}
	
}
