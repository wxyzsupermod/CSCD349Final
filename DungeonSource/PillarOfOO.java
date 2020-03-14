import java.util.Random;
public class PillarOfOO {
	private String pillarOfOO;
	
	public PillarOfOO() {
		int num = new Random().nextInt(4);
		
		if(num == 0) {
			this.setPillarOfOO("Abstraction");
		}
		
		else if(num == 1) {
			this.setPillarOfOO("Inheritance");
		}
		
		else if(num == 2) {
			this.setPillarOfOO("Composition");
		}
		
		else {
			this.setPillarOfOO("Encapsulation");
		}
	}

	public String getPillarOfOO() {
		return pillarOfOO;
	}

	public void setPillarOfOO(String pillarOfOO) {
		this.pillarOfOO = pillarOfOO;
	}
}
