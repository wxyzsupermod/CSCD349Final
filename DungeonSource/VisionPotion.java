
public class VisionPotion extends Potion {
	
	public VisionPotion() {
		super();
	}
	
	@Override
	public void doEffect(DungeonCharacter c) {
		System.out.println ("Character " + c.getName() + " received Potion vision effect.");
		// do the potion things here
	}
	
}
