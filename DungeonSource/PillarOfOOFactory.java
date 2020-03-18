
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
		PillarOfOO p = new PillarOfOO (totalFactoriesCreated);
		totalFactoriesCreated++;
		return p;
	}
	
	public boolean canCreate() {
		return totalFactoriesCreated < 4;
	}
	
}
