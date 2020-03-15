import java.util.Random;
public class PillarOfOO extends DungeonEntity{
	
	public PillarOfOO() {
		int num = new Random().nextInt(4);
		
		if(num == 0) {
			this.setName("Abstraction");
		}
		
		else if(num == 1) {
			this.setName("Inheritance");
		}
		
		else if(num == 2) {
			this.setName("Composition");
		}
		
		else {
			this.setName("Encapsulation");
		}
	}
}
