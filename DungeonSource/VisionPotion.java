public class VisionPotion extends Potion{
	private int effectivity;
	
	public VisionPotion(int effectivity) {
		super("Vision Potion");
		if (effectivity <= 0) {
			throw new IllegalArgumentException("effectivity is zero or negative");
		}
		this.effectivity = effectivity;
	}
	
	public void printVisionPotion(int centerX, int centerY) {
		DungeonAdventure.printRooms(centerX-effectivity, centerY-effectivity, centerX+effectivity, centerY+effectivity);
	}
	
	@Override
	public void affectCharacter(DungeonCharacter c) {
		Hero hero = (Hero) c;
		if (hero != null) {
			System.out.println("You drank the vision potion, and now you can see the rooms surrounding you.");
			printVisionPotion(hero.getPosX(), hero.getPosY());
		}
	}
}
