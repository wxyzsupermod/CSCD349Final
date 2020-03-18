public class PillarOfOO extends DungeonEntity {
	private String pillarOfOO;
	
	public PillarOfOO(int type) {
		if(type == 0) {
			this.setPillarOfOO("Abstraction");
		} else if(type == 1) {
			this.setPillarOfOO("Inheritance");
		} else if(type == 2) {
			this.setPillarOfOO("Polymorphism");
		} else {
			this.setPillarOfOO("Encapsulation");
		}
	}

	public String getPillarOfOO() {
		return pillarOfOO;
	}

	public void setPillarOfOO(String pillarOfOO) {
		this.pillarOfOO = pillarOfOO;
	}
	
	@Override
	public String toString() {
		return pillarOfOO;
	}
}
